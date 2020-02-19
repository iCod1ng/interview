package spring.wiring.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yanyuchi
 * @date 2020-02-05 00:14
 * 自动装配就是让Spring自动满足bean依赖的一种方法，在上下文中寻求匹配某个bean需求的其他bean,借助@Autowired
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    /**
     * 当Spring创建CDPlayer bean时，会通过这个构造器来进行实例化并且会传入一个可设置给CompactDisc类型的bean
     * @param cd
     */
    @Autowired
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    /**
     * 不管是构造器、Setter方法还是其他方法，Spring都会尝试满足方法参数上所声明的依赖。如果有且只有一个bean匹配，这个bean就会被装在进来，
     * 否则会抛出异常。
     */

    @Autowired
    public void setCompactDisc(CompactDisc cd){
        this.cd =cd;
    }

    @Autowired
    public void insertDisc(CompactDisc cd){
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
