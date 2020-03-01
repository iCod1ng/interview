package concurrency.cp1.template;

/**
 * 模板设计模式
 * 父类编写结论，子类实现逻辑
 * Thread的run 和 start方法
 * start方法中的start0() 会调用该线程的run方法
 * @author yanyuchi
 * @date 2020-02-24 17:29
 */
public class TemplateMethod {

    public final void print(String msg){
        System.out.println("**********");
        wrapPrint(msg);
        System.out.println("**********");

    }

    protected void wrapPrint(String msg){

    }

    public static void main(String[] args) {
        TemplateMethod t = new TemplateMethod(){
            @Override
            protected void wrapPrint(String msg) {
                System.out.println("$"+msg+"$");
            }
        };

        t.print("Hello otto");
    }
}
