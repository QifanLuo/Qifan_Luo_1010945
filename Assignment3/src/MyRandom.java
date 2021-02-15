package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyRandom {


    public int  getRandom(int min, int max){
        Random random = new Random();
        return random.nextInt(max-min+1)+min;
    }

    public int[] getRandoms(int min, int max, int count){
        int[] randoms = new int[count];
        List<Integer> ListRandom = new ArrayList<>();

        if((max-min+1)<count)
            return null;

        for(int i = min;i<=max;i++){
            ListRandom.add(i);
        }

        for(int i = 0; i < count;i++){
            int index = getRandom(0,ListRandom.size()-1);
            randoms[i]=ListRandom.get(index);
            ListRandom.remove(index);
        }

        return randoms;

    }



}
