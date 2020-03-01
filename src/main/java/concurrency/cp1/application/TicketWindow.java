package concurrency.cp1.application;

/**
 * @author yanyuchi
 * @date 2020-02-24 17:36
 * Max 稍大后会出现线程安全问题
 */
public class TicketWindow extends Thread {

    private final String name;

    private static int MAX = 50;

    private static int index = 1;

    public TicketWindow(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX){
            System.out.println("柜台: "+name+" 当前号码: "+(index++));
        }
    }
}
