package union_find;

import sort.InsertionSort;
import util.Benchmark;
import util.Benchmark_Timer;
import util.MyRandom;

import java.util.function.Supplier;

public class Main2 {
    //static int[] num = {15,30,60,120,240,480,960,1920,3840};
    static int[] num = {50,100,200,400,800,1600};
    static int[] N = {5,10,20,40,80};


    public static void main(String[] args){


        UF_Count uf_count = new UF_Count();
        MyRandom myRandom = new MyRandom();

        //int nRuns = 10;
        //int warmups = 10;
        //InsertionSort insertionSort = new InsertionSort();
        for(int i = 0;i<num.length;i++) {
            /*
            UF_HWQUPC uf_hwqupc = new UF_HWQUPC(num[i]);
            UF_HWQUPC_TwoLoops uf_hwqupc_twoLoops = new UF_HWQUPC_TwoLoops(num[i]);
            WQUPC wqupc = new WQUPC(num[i]);
            WQUPC_depth wqupc_depth = new WQUPC_depth(num[i]);
             */

            int[] randomArray = myRandom.getRandoms(0,num[i]-1,num[i]);

            double seconds = 0;
            for (int k = 0; k < 10; k++) {

                //int n = N[i];


                //Supplier<Integer[]> supplier = () -> helper.random(Integer.class, r -> r.nextInt(1000));
                int finalI = i;
                Supplier<int[]> supplier = () -> myRandom.getRandoms(0,num[finalI]-1,num[finalI]);


                Benchmark<int[]> bm1 = new Benchmark_Timer<>(
                        "testWaitPeriods",
                        null,
                        b -> {
                            //uf_count.uf_hwqupc_count(num[finalI],randomArray);
                            //uf_count.uf_hwqupc_twoLoops_count(num[finalI],randomArray);
                            //uf_count.wqupc_count(num[finalI],randomArray);
                            uf_count.wqupc_depth_count(num[finalI],randomArray);


                        },
                        null);

                double millseconds1 = bm1.runFromSupplier(supplier, 10);
                //System.out.println("the time is " + millseconds1);

                //if(k>9) {

                seconds = seconds + millseconds1;
                //}

            }

            System.out.println("the average time is "+seconds/10+" .");
        }


//}
    }

}
