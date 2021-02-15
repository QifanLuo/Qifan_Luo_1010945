package union_find;

import util.MyRandom;

public class Main {
    private static int[] num = {15,30,60,120,240,480,960};
    private static UF_HWQUPC uf_hwqupc;

    public static void main(String[] args){

        for(int i = 0;i<num.length;i++){
            int n = num[i];

            System.out.println(count(n));
            System.out.println("__________________________________");





        }
    }

    private static String count(int n){
        int pairs = 0;
        uf_hwqupc = new UF_HWQUPC(n);
        int[] randomArray = new MyRandom().getRandoms(0,n-1,n);
        //for(int i = 0;i<randomArray.length;i++){
        while (!uf_hwqupc.isAllConnected()) {
            uf_hwqupc.connect(randomArray[new MyRandom().getRandom(0, n - 1)], new MyRandom().getRandom(0, n - 1));

            pairs++;
            //}
        }
        //System.out.println("numbers of pairs: "+ pairs+".");
        return uf_hwqupc.toString();

    }


}
