package generic;

import java.util.Random;

/**
 * @author yanyuchi
 * @date 2019-08-24 10:58
 */
public class StringRandomImpl implements IGeneric<String> {

    @Override
    public String next() {
        Random random = new Random();
        return String.valueOf(random.nextInt(3));
    }
}
