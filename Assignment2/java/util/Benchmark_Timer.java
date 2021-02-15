/*
 * Copyright (c) 2018. Phasmid Software
 */

package util;

import org.ini4j.Ini;
import sort.Helper;
import sort.HelperFactory;
import sort.InsertionSort;
import sort.SortWithHelper;

import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.junit.Assert.assertTrue;
import static util.Utilities.formatWhole;

/**
 * This class implements a simple Benchmark utility for measuring the running time of algorithms.
 * It is part of the repository for the INFO6205 class, taught by Prof. Robin Hillyard
 * <p>
 * It requires Java 8 as it uses function types, in particular, UnaryOperator&lt;T&gt; (a function of T => T),
 * Consumer&lt;T&gt; (essentially a function of T => Void) and Supplier&lt;T&gt; (essentially a function of Void => T).
 * <p>
 * In general, the benchmark class handles three phases of a "run:"
 * <ol>
 *     <li>The pre-function which prepares the input to the study function (field fPre) (may be null);</li>
 *     <li>The study function itself (field fRun) -- assumed to be a mutating function since it does not return a result;</li>
 *     <li>The post-function which cleans up and/or checks the results of the study function (field fPost) (may be null).</li>
 * </ol>
 * <p>
 * Note that the clock does not run during invocations of the pre-function and the post-function (if any).
 *
 * @param <T> The generic type T is that of the input to the function f which you will pass in to the constructor.
 */
public class Benchmark_Timer<T> implements Benchmark<T> {

    /**
     * Calculate the appropriate number of warmup runs.
     *
     * @param m the number of runs.
     * @return at least 2 and at most m/10.
     */
    static int getWarmupRuns(int m) {
        return Integer.max(2, Integer.min(10, m / 10));
    }

    /**
     * Run function f m times and return the average time in milliseconds.
     *
     * @param supplier a Supplier of a T
     * @param m        the number of times the function f will be called.
     * @return the average number of milliseconds taken for each run of function f.
     */
    @Override
    public double runFromSupplier(Supplier<T> supplier, int m) {
        logger.info("Begin run: " + description + " with " + formatWhole(m) + " runs");
        // Warmup phase
        final Function<T, T> function = t -> {
            fRun.accept(t);
            return t;
        };
        new Timer().repeat(getWarmupRuns(m), supplier, function, fPre, null);

        // Timed phase
        return new Timer().repeat(m, supplier, function, fPre, fPost);
    }

    /**
     * Constructor for a Benchmark_Timer with option of specifying all three functions.
     *
     * @param description the description of the benchmark.
     * @param fPre        a function of T => T.
     *                    Function fPre is run before each invocation of fRun (but with the clock stopped).
     *                    The result of fPre (if any) is passed to fRun.
     * @param fRun        a Consumer function (i.e. a function of T => Void).
     *                    Function fRun is the function whose timing you want to measure. For example, you might create a function which sorts an array.
     *                    When you create a lambda defining fRun, you must return "null."
     * @param fPost       a Consumer function (i.e. a function of T => Void).
     */
    public Benchmark_Timer(String description, UnaryOperator<T> fPre, Consumer<T> fRun, Consumer<T> fPost) {
        this.description = description;
        this.fPre = fPre;
        this.fRun = fRun;
        this.fPost = fPost;


    }

    /**
     * Constructor for a Benchmark_Timer with option of specifying all three functions.
     *
     * @param description the description of the benchmark.
     * @param fPre        a function of T => T.
     *                    Function fPre is run before each invocation of fRun (but with the clock stopped).
     *                    The result of fPre (if any) is passed to fRun.
     * @param fRun        a Consumer function (i.e. a function of T => Void).
     *                    Function fRun is the function whose timing you want to measure. For example, you might create a function which sorts an array.
     */
    public Benchmark_Timer(String description, UnaryOperator<T> fPre, Consumer<T> fRun) {
        this(description, fPre, fRun, null);
    }

    /**
     * Constructor for a Benchmark_Timer with only fRun and fPost Consumer parameters.
     *
     * @param description the description of the benchmark.
     * @param fRun        a Consumer function (i.e. a function of T => Void).
     *                    Function fRun is the function whose timing you want to measure. For example, you might create a function which sorts an array.
     *                    When you create a lambda defining fRun, you must return "null."
     * @param fPost       a Consumer function (i.e. a function of T => Void).
     */
    public Benchmark_Timer(String description, Consumer<T> fRun, Consumer<T> fPost) {
        this(description, null, fRun, fPost);
    }

    /**
     * Constructor for a Benchmark_Timer where only the (timed) run function is specified.
     *
     * @param description the description of the benchmark.
     * @param f           a Consumer function (i.e. a function of T => Void).
     *                    Function f is the function whose timing you want to measure. For example, you might create a function which sorts an array.
     */
    public Benchmark_Timer(String description, Consumer<T> f) {
        this(description, null, f, null);
    }

    private final String description;
    private final UnaryOperator<T> fPre;
    private final Consumer<T> fRun;
    private final Consumer<T> fPost;

    final static LazyLogger logger = new LazyLogger(Benchmark_Timer.class);

    private static int[] N = {5,10,20,40,80};


    private static InsertionSort insertionSort = new InsertionSort();


    public static void main(String[] args){

        //Integer[] array = generateArray(1,10);
        //System.out.println("  ");



        //int nRuns = 10;
        //int warmups = 10;
        InsertionSort insertionSort = new InsertionSort();



        //for(int j = 1;j<=4;j++) {
        int j = 1;
        //i is present for N
        int i =0;

            //index: 1 random 2 order 3 partially order 4 reverse
            System.out.println("this is for the "+j+"st array");
        double seconds = 0;
            for (int k = 0; k < 10; k++) {

                int n = N[i];
                //final Config config = Config.setupConfig("true", "0", "1", "", "");
                //Helper<Integer> helper = HelperFactory.create("InsertionSort", n, config);
                //helper.init(n);
                //helper.getN();

                Integer[] xs = generateArray(j,n);


                //Supplier<Integer[]> supplier = () -> helper.random(Integer.class, r -> r.nextInt(1000));
                int finalJ = j;
                Supplier<Integer[]> supplier = () -> generateArray(finalJ,n);


                Benchmark<Integer[]> bm = new Benchmark_Timer<>(
                        "testWaitPeriods",
                        null,
                        b -> {
                            insertionSort.sort(xs);
                        },
                        null);

                double millseconds = bm.runFromSupplier(supplier, 10);
                System.out.println("Array length is " + n + "  and the time is " + millseconds);

                //if(k>9) {

                    seconds = seconds + millseconds;
                //}

            }

        System.out.println("the average time is "+seconds/10+" .");
        //}





    }


    private static Integer[] generateArray(int index, int num){
        Integer[] array = new Integer[num];
        //index: 1 random 2 order 3 partially order 4 reverse
        switch (index){
            case 1:
                HashSet<Integer> set = new HashSet<>();
                array = randomSet(0,1000,num,set);
                break;
            case 2:
                for(int i = 0;i<num;i++){
                    array[i] = i+2;
                }
                break;
            case 3:
                int partially = num/2+1;
                Integer[] array2 = new Integer[partially];
                HashSet<Integer> set2 = new HashSet<>();
                array2 = randomSet(0,1000,partially,set2);
                for(int i = 0;i<num;i++){
                    if(i<=partially-1){
                        array[i] = array2[i];
                    }else {
                        array[i] = 1000 + i * 2;
                    }
                }
                break;
            case 4:
                int dex = 0;
                for(int i = num-1;i>=0;i--){

                    array[dex] = i*10;
                    dex++;
                }
                break;
        }

        return array;

    }

    public static Integer[] randomSet(int min, int max, int n, HashSet<Integer> set) {
        Integer[] array = new Integer[n];
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            // 调用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);// 将不同的数存入HashSet中
        }
        int setSize = set.size();
        // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
        if (setSize < n) {
            randomSet(min, max, n - setSize, set);// 递归
        }

        //array = (Integer[]) set.stream().toArray();

        set.toArray(array);


        return array;
    }


}
