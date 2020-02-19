package spring.autoconfig;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.wiring.autoconfig.CDPlayerConfig;
import spring.wiring.autoconfig.CompactDisc;
import spring.wiring.autoconfig.MediaPlayer;

import static org.junit.Assert.*;

/**
 * @author yanyuchi
 * @date 2020-02-05 00:04
 */

/**
 * SpringJUnit4ClassRunner,测试开始前自动创建Spring上下文
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * @ContextConfiguration指定加载配置
 */
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }

    @Test
    public void play(){
        player.play();
        assertEquals("Playing Sgt.Pepper's Lonely by The Beatles\n",log.getLog());
    }
}
