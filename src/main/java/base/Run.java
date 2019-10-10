package base;

import java.math.BigDecimal;

/**
 * @author yanyuchi
 * @date 2019-08-24 22:20
 */
public class Run {
    public static void main(String[] args) {
        CalenderTest.showCalender();

    }

    public  static  void  doubleOpera(){
        //浮点数不适用于无法接受舍入误差的金融计算中
        double a = 2.0;
        double b  = 1.1;
        double res = a - b;
        System.out.println(res); //0.8999999999999999

        //用字符串,用数值还是0.8999999999999999
        double bigRes = new BigDecimal("2.0").subtract(new BigDecimal("1.1")).doubleValue();
        System.out.println(bigRes); //0.9
    }
}
