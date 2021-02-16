package union_find;

import util.Excel;
import util.MyRandom;

public class Main {
    // = {15,30,60,120,240,480,960,1920,3840};
    private static int[] num = new int[100];

    private static UF_HWQUPC uf_hwqupc;

    private static String[] steps = {"n","m"};

    public static void main(String[] args) throws Exception {
        generateNum();



        String[][] datalist = new String[100][2];


        for(int i = 0;i<num.length;i++){
            int n = num[i];

            System.out.println(count(n));
            datalist[i][0] = String.valueOf(n);
            datalist[i][1] = String.valueOf(count(n));

            System.out.println("__________________________________");

        }

        String sheetName = "output1";
        String titleName = "file1";
        String fileName = "file2";
        int columnNumber = 7;
        int[] columnWidth = { 10, 20, 30 };






        new Excel().ExportNoResponse(sheetName, titleName, fileName,
                2, columnWidth, steps, datalist);


    }

    private static String count(int n){
        int pairs = 0;

        int totalpairs = 0;
        uf_hwqupc = new UF_HWQUPC(n);
        int[] randomArray = new MyRandom().getRandoms(0,n-1,n);
        //for(int i = 0;i<n;i++){
        for(int i = 0;i<10;i++) {
            while (!uf_hwqupc.isAllConnected()) {
                uf_hwqupc.connect(randomArray[new MyRandom().getRandom(0, n - 1)], new MyRandom().getRandom(0, n - 1));

                pairs++;
                //}
            }
            totalpairs = totalpairs+pairs;
        }
        System.out.println("numbers of pairs: "+ totalpairs/10+".");
        //return uf_hwqupc.toString();
        return String.valueOf(totalpairs/10);

    }

    static void generateNum(){
        for(int i = 0;i<100;i++){
            num[i] = (i+1)*10;
        }
    }


}
