package concurrency.cp2and3.example;

import concurrency.cp2and3.example.impl.FightQueryTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanyuchi
 * @date 2020-03-01 12:24
 */
public class FightQueryExample {

    private static List<String> fightCompany = Arrays.asList("CSA","CEA","HNA");


    public static void main(String[] args) {
        List<String> result = search("CD","LA");
        System.out.println("=========result========");
        result.forEach(System.out::println);
    }

    private static List<String> search(String original,String dest){
        final List<String> result = new ArrayList<>();

        List<FightQueryTask> tasks = fightCompany.stream().map(f->createSearchTask(f,original,dest)).collect(Collectors.toList());

        tasks.forEach(Thread::start);

        tasks.forEach(t->{
            try{
                t.join();
            }catch (InterruptedException e){

            }
        });

        tasks.stream().map(FightQueryTask::get).forEach(result::addAll);
        return result;
    }

    private static FightQueryTask createSearchTask(String fight,String original,String dest){
        return new FightQueryTask(fight,original,dest);
    }
}
