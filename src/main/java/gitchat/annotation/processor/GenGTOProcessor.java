//package gitchat.annotation.processor;
//
//import com.google.auto.service.AutoService;
//import com.google.common.collect.Sets;
//import com.squareup.javapoet.*;
//import gitchat.annotation.anno.GenDTO;
//import gitchat.annotation.anno.GenDTOIgnore;
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.Setter;
//
//import javax.annotation.processing.Processor;
//import javax.annotation.processing.RoundEnvironment;
//import javax.lang.model.element.Element;
//import javax.lang.model.element.Modifier;
//import java.util.Set;
//
///**
// * @author yanyuchi
// * @date 2019-07-15 20:16
// */
//@AutoService(Processor.class)
//public class GenGTOProcessor extends BaseProcessor<GenDTO>{
//    public GenGTOProcessor(){
//        super(GenDTO.class);
//    }
//
//    @Override
//    protected void foreachClass(GenDTO genDTO, Element element, RoundEnvironment roundEnv) {
//        String className = "Base" + element.getSimpleName().toString() + "DTO";
//
//        Set<TypeAndName> typeAndNames = Sets.newHashSet();
//
//        //获取元素中字段的信息
//        Set<TypeAndName> fields = findFields(element,filterForIgnore(GenDTOIgnore.class));
//        typeAndNames.addAll(fields);
//
//        //获取元素中Getters信息
//        Set<TypeAndName> getters = findGetter(element,filterForIgnore(GenDTOIgnore.class));
//        typeAndNames.addAll(getters);
//
//        //生成Java类，类名为className,添加@Data注解，并使用 public、abstract关键字描述
//        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(className)
//                .addAnnotation(Data.class)
//                .addModifiers(Modifier.PUBLIC,Modifier.ABSTRACT);
//
//        //生成构造函数
//        MethodSpec.Builder cMethodSpecBuilder = MethodSpec.constructorBuilder()
//                .addParameter(TypeName.get(element.asType()),"source")
//                .addModifiers(Modifier.PROTECTED);
//
//        for (TypeAndName typeAndName:typeAndNames){
//            FieldSpec fieldSpec = FieldSpec.builder(typeAndName.getType(),typeAndName.getName(),Modifier.PRIVATE)
//                    .addAnnotation(AnnotationSpec.builder(Setter.class)
//                    .addMember("value","$T.PUBLIC",AccessLevel.class)
//                    .build())
//                    .build();
//            typeSpecBuilder.addField(fieldSpec);
//
//            String fieldName = typeAndName.getName().substring(0,1).toUpperCase()
//                    + typeAndName.getName().substring(1,typeAndName.getName().length());
//
//            cMethodSpecBuilder.addStatement("this.set$L(source.get$:())",fieldName,fieldName);
//        }
//
//        //构造函数中添加到类中
//        typeSpecBuilder.addMethod(cMethodSpecBuilder.build());
//
//        String pkgName = genDTO.pkgName();
//
//        createJavaFile(typeSpecBuilder,pkgName);
//
//
//    }
//}
