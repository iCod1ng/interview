package gitchat.annotation.processor;

import com.google.common.collect.Sets;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import lombok.Value;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author yanyuchi
 * @date 2019-07-15 15:57
 */
@SuppressWarnings("unchecked")
public abstract class BaseProcessor<A extends Annotation> extends AbstractProcessor {

    /**
     * 需要处理的注解类
     */
    private  final  Class clazz;

    /**
     * 用于回写新生成的java文件
     */
    private Filer filer;

    private Messager messager;

    public BaseProcessor(Class<A> clazz){
        this.clazz = clazz;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Sets.newHashSet(clazz.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.filer = processingEnv.getFiler();
        this.messager = processingEnv.getMessager();
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //获取所有标记该注解的元素
        Set<Element> elements = roundEnv.getElementsAnnotatedWith(this.clazz);

        for(Element element : ElementFilter.typesIn(elements)){
            A a = (A) element.getAnnotation(this.clazz);
            foreachClass(a,element,roundEnv);
        }

        return false;
    }

    protected abstract void foreachClass(A a, Element element,RoundEnvironment roundEnv);


    /**
     * 获取元素的所有字段信息
     * @param element
     * @param filter
     * @return
     */
    protected Set<TypeAndName> findFields(Element element, Predicate<Element> filter){
        return ElementFilter.fieldsIn(element.getEnclosedElements()).stream().filter(filter)
                .map(variableElement -> new TypeAndName(variableElement))
                .collect(Collectors.toSet());
    }


    /**
     * 获取所有的Getter方法
     * @param element
     * @param filter
     * @return
     */
    protected Set<TypeAndName> findGetter(Element element,Predicate<Element> filter){
        return ElementFilter.methodsIn(element.getEnclosedElements()).stream()
        .filter(filter)
        .filter(executableElement -> isGetter((executableElement.getSimpleName().toString())))
        .map(executableElement -> new TypeAndName(executableElement))
        .collect(Collectors.toSet());
    }

    private boolean isGetter(String s){
        return s.startsWith("id") || s.startsWith("get");
    }

    /**
     * 获取基于注解的忽略过滤器
     * @param <I>
     */
    protected <I extends  Annotation> Predicate<Element> filterForIgnore(Class<I> iClass){
        return new IgnoreFilter<I>(iClass);

    }


    /**
     * 忽略过滤器,如果元素上添加了Ignore注解，对其进行忽略
     * @param <I>
     */
    protected static class  IgnoreFilter<I extends  Annotation> implements Predicate<Element>{
        private final Class<I> iClass;

        public IgnoreFilter(Class<I> iClass){
            this.iClass = iClass;
        }

        @Override
        public boolean test(Element element) {
            return element.getAnnotation(iClass) == null;
        }
    }


    /**
     * 生成Java文件
     * @param typeSpecBuilder
     * @param pkgName
     */
    protected void createJavaFile(TypeSpec.Builder typeSpecBuilder,String pkgName){
        try{
            JavaFile javaFile = JavaFile.builder(pkgName,typeSpecBuilder.build())
                    .addFileComment("This codes are generated automatically!")
                    .build();
            javaFile.writeTo(filer);
            System.out.println(javaFile);
            this.messager.printMessage(Diagnostic.Kind.WARNING,javaFile.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }




    @Value
    protected  static class TypeAndName{
        private  final  String name;

        private final TypeName type;

        public TypeAndName(VariableElement variableElement) {
            this.name = variableElement.getSimpleName().toString();
            this.type = TypeName.get(variableElement.asType());
        }

        public TypeAndName(ExecutableElement executableElement){
            this.name = getFieldName(executableElement.getSimpleName().toString());
            this.type = TypeName.get(executableElement.getReturnType());
        }

        private String getFieldName(String s){
            String r = null;
            if(s.startsWith("get")){
                r = s.substring(3,s.length());
            }else if(s.startsWith("is")){
                r = s.substring(2,s.length());
            }else {
                r = s;
            }
            return r.substring(0,1).toLowerCase() + r.substring(1,r.length());
        }




    }
}
