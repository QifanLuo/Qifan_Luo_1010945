package union_find;

import util.MyRandom;

public class UF_Count {

    static UF_HWQUPC uf_hwqupc;
    static UF_HWQUPC_TwoLoops uf_hwqupc_twoLoops;
    static WQUPC wqupc;
    static WQUPC_depth wqupc_depth;

    public static void uf_hwqupc_count(int n,int[] randomArray){
        int pairs = 0;

        int totalpairs = 0;
        uf_hwqupc = new UF_HWQUPC(n);

        for(int i = 0;i<n;i++) {
            while (!uf_hwqupc.isAllConnected()) {
                uf_hwqupc.connect(randomArray[new MyRandom().getRandom(0, n - 1)], new MyRandom().getRandom(0, n - 1));
            }
        }
    }

    public static void uf_hwqupc_twoLoops_count(int n,int[] randomArray){
        int pairs = 0;

        int totalpairs = 0;
        uf_hwqupc_twoLoops = new UF_HWQUPC_TwoLoops(n);

        for(int i = 0;i<n;i++) {
            while (!uf_hwqupc_twoLoops.isAllConnected()) {
                uf_hwqupc_twoLoops.connect(randomArray[new MyRandom().getRandom(0, n - 1)], new MyRandom().getRandom(0, n - 1));
            }
        }
    }

    public static void wqupc_count(int n,int[] randomArray){
        int pairs = 0;

        int totalpairs = 0;
        wqupc = new WQUPC(n);

        for(int i = 0;i<n;i++) {
            while (!wqupc.isAllConnected()) {
                wqupc.connect(randomArray[new MyRandom().getRandom(0, n - 1)], new MyRandom().getRandom(0, n - 1));
            }
        }
    }

    public static void wqupc_depth_count(int n,int[] randomArray){
        int pairs = 0;

        int totalpairs = 0;
        wqupc_depth = new WQUPC_depth(n);

        for(int i = 0;i<n;i++) {
            while (!wqupc_depth.isAllConnected()) {
                wqupc_depth.connect(randomArray[new MyRandom().getRandom(0, n - 1)], new MyRandom().getRandom(0, n - 1));
            }
        }
    }


}
