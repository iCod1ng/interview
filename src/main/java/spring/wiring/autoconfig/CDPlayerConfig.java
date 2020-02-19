package spring.wiring.autoconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanyuchi
 * @date 2020-02-04 23:53
 * 使用@ComponentScan启用组件扫描。
 * 未指定路径扫描相同包及其子包。
 * xml启用方式-> <context:component-scan base-package="xxx">
 */

@Configuration
@ComponentScan
public class CDPlayerConfig {
}
