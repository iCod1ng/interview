package spring.wiring.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yanyuchi
 * @date 2020-02-18 22:44
 */
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    public void play(){
        cd.play();
    }
}
