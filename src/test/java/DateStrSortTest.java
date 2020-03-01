import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yanyuchi
 * @date 2020-02-20 10:34
 */
public class DateStrSortTest {

    private static final List<String> dateStr = Arrays.asList("02-16","02-15","02-13","02-14");

    @Test
    public void test(){
        List<String> afterSorted =  dateStr.stream().sorted().collect(Collectors.toList());
        System.out.println(afterSorted);
    }

    @Test
    public void  mapKeySorted(){
        Map<String,Long> res = Maps.newLinkedHashMap();
        res.put("02-16",16L);
        res.put("02-15",15L);

        res.put("02-13",13L);
        res.put("02-14",14L);
        System.out.println("before:"+ JSON.toJSONString(res));


    }
}
