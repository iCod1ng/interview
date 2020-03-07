package concurrency.cp2and3.example.impl;

import com.google.common.collect.Lists;
import concurrency.cp2and3.example.FightQuery;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author yanyuchi
 * @date 2020-03-01 12:04
 */
public class FightQueryTask extends Thread implements FightQuery {

    private final String origin;

    private final String destination;

    private final List<String> flightList = Lists.newArrayList();

    public FightQueryTask(String airLine, String origin, String destination){
        super("["+airLine+"]");
        this.origin =origin;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.printf("%s-query from %s to %s \n",getName(),origin,destination);

        int randomVal = ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(randomVal);
            this.flightList.add(getName() + "-"+randomVal);
            System.out.printf("The fight:%s list query successful \n",getName());
        }catch (InterruptedException e){

        }
    }

    @Override
    public List<String> get() {
        return this.flightList;
    }
}
