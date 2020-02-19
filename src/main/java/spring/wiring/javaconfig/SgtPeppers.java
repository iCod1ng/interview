package spring.wiring.javaconfig;

/**
 * @author yanyuchi
 * @date 2020-02-18 22:41
 */
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

}
