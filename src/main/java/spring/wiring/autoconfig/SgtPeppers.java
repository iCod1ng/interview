package spring.wiring.autoconfig;

import org.springframework.stereotype.Component;

/**
 * 唱片实现
 * @author yanyuchi
 * @date 2020-02-04 21:29
 * Component annotation means this class will be a component class ,and tell Spring to create a bean for it.
 * 在XML中配置bean称为显示配置bean。
 * 使用了@Component没有必要显示配置bean，可以通过组件扫描寻找带@Component的类，并为其创建Bean。
 * 组件扫描默认是不启用的。需要配置
 */
@Component
public class SgtPeppers implements CompactDisc {
    private String title ="Sgt.Pepper's Lonely";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing "+title+" by "+artist);
    }
}
