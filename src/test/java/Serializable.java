import com.alibaba.fastjson.JSON;
import org.junit.Test;
import serializable.Model;

/**
 * @author yanyuchi
 * @date 2019-06-18 21:22
 */

public class Serializable {

    @Test
    public void SerializabkeTest(){
        Model model = new Model();
        model.setAge(10);
        model.setName("bb");
        String json = JSON.toJSONString(model);
        System.out.println(json);
        System.out.println("====");

        Model model1 = JSON.parseObject(json,Model.class);
        System.out.println(model1);

    }
}
