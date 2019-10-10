package base;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author yanyuchi
 * @date 2019-08-25 10:39
 */
public class CalenderTest {

    public static  void  showCalender(){

        LocalDate date = LocalDate.now();

        int month = date.getMonthValue();

        int today = date.getDayOfMonth();


        date = date.minusDays(today-1);
        DayOfWeek week = date.getDayOfWeek();
        int value = week.getValue();

        System.out.println("Mon  Tue  Wed  Tue  Fri  Sat  Sun");
        for (int i=1;i<value;i++){
            System.out.print("     ");  //三个空格加一个Tab
        }
        while (date.getMonthValue()==month){
            System.out.printf("%3d",date.getDayOfMonth());
            if(date.getDayOfMonth() == today){
                System.out.print("*");
            }else {
                System.out.print("  ");
            }
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1){
                System.out.println();
            }
        }
        if(date.getDayOfWeek().getValue() != 1){
            System.out.println();
        }
    }
}
