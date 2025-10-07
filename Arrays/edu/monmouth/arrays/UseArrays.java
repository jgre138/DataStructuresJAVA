package edu.monmouth.arrays;

import java.util.Arrays;

public class UseArrays {

    public static void main(String[] args) {
        final int SIZE=10, UNINITILZED=-99, KALENGTH=4;
        int ia[];
        ia = new int [SIZE];
        Arrays.fill(ia, UNINITILZED);
        System.out.println(Arrays.toString(ia));

        int ka[] = new int[KALENGTH];
        ka = Arrays.copyOf(ia, KALENGTH);
        System.out.println(Arrays.toString(ka));

        int ka2[] = new int[KALENGTH+2];
        ka2 = Arrays.copyOf(ia, KALENGTH+2);
        System.out.println(Arrays.toString(ka2));

        System.out.println(Arrays.equals(ka,ka2));



    }

}
