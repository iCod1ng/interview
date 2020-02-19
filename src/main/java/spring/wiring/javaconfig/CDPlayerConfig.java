package spring.wiring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanyuchi
 * @date 2020-02-18 22:46
 */
@Configuration
public class CDPlayerConfig {


    /**
     * sgtPeppers() 使用了@Bean，Spring会拦截所有对它的调用，保证直接返回该方法所创建的bean，而非每次都对其进行实际的调用
     * 引用Bean必须写到同一个配置文件
     */
    /*
    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(){
        return  new CDPlayer(sgtPeppers());
    }*/




    /**
     * @Bean注解告诉Spring这个方法将返回一个对象，该对象要注册为Spring应用上下文的bean.
     * 方法体中包含产生bean的实际逻辑
     * 默认情况 bean Id = 方法名
     *
     * @return
     */
    @Bean
    public CompactDisc compactDisc(){
        return new SgtPeppers();
    }



    /**
     *
     * 自动装配一个CompactDisc到配置方法中
     * @param compactDisc
     * @return
     */
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
