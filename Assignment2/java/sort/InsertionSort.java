/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package sort;

import sort.BaseHelper;
import sort.Helper;
import sort.SortWithHelper;
import util.Config;

public class InsertionSort<X extends Comparable<X>> extends SortWithHelper<X> {

    /**
     * Constructor for any sub-classes to use.
     *
     * @param description the description.
     * @param N           the number of elements expected.
     * @param config      the configuration.
     */
    protected InsertionSort(String description, int N, Config config) {
        super(description, N, config);
    }

    /**
     * Constructor for InsertionSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public InsertionSort(int N, Config config) {
        this(DESCRIPTION, N, config);
    }

    public InsertionSort() {
        this(new BaseHelper<>(DESCRIPTION));
    }

    /**
     * Constructor for InsertionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public InsertionSort(Helper<X> helper) {
        super(helper);
    }

    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public void sort(X[] xs, int from, int to) {
        final Helper<X> helper = getHelper();

        // TO BE IMPLEMENTE
        /*
        for(int i = from;i<to-1;i++){
            for(int j = i+1;j>from;j--){
                if(helper.compare(xs[j],xs[j-1]) == -1){
                    helper.swap(xs,j,j-1);
                }
            }
        }

        */

        if (xs == null || xs.length < 2) {
            return;
        }

        for(int i = from+1;i<to;i++){
            X cur = xs[i];
            boolean flag = false;


            for(int j = i-1;j>from-1;j--){

                //if(helper.compare(xs[j],cur) == 1){
                if(!helper.less(xs[j],cur)){
                    helper.swap(xs,j,j+1);
                    //xs[j+1] = xs[j];
                }else{
                    xs[j+1] = cur;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                xs[0] = cur;
            }
        }

    }

    /**
     * This is used by unit tests.
     *
     * @param ys  the array to be sorted.
     * @param <Y> the underlying element type.
     */
    public static <Y extends Comparable<Y>> void mutatingInsertionSort(Y[] ys) {
        new InsertionSort<Y>().mutatingSort(ys);
    }

    public static final String DESCRIPTION = "Insertion sort";

}
