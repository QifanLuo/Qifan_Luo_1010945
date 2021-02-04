package simple;


import org.junit.Test;
import sort.BaseHelper;
import sort.GenericSort;
import sort.Helper;
import sort.InsertionSort;
import util.Benchmark;
import util.Benchmark_Timer;
import util.LazyLogger;
import util.Utilities;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Unit tests which are in fact benchmarks of the various sort methods.
 * Keep in mind that we are sorting objects here (Integers). not primitives.
 */
public class Benchmarks {



    @Test
    public void testInsertionSortBenchmark() {
        String description = "Insertion sort";
        Helper<Integer> helper = new BaseHelper<>(description, N);
        final GenericSort<Integer> sort = new InsertionSort<>(helper);
        runBenchmark(description, sort, helper);
    }



    public void runBenchmark(String description, GenericSort<Integer> sort, Helper<Integer> helper) {
        helper.init(N);
        Supplier<Integer[]> supplier = () -> helper.random(Integer.class, r -> r.nextInt());
        final Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                description + " for " + N + " Integers",
                (xs) -> Arrays.copyOf(xs, xs.length),
                sort::mutatingSort,
                null
        );
        logger.info(Utilities.formatDecimal3Places(benchmark.runFromSupplier(supplier, 100)) + " ms");
    }

    final static LazyLogger logger = new LazyLogger(Benchmarks.class);

    public static final int N = 2000;
}
