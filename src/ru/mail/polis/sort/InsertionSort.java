package ru.mail.polis.sort;

/**
 * Created by kubri on 11/21/2016.
 */
public class InsertionSort {

    public static int[] sort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int copyNumber = a[i];
            int j = i;
            while (j > 0 && copyNumber < a[j-1]) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = copyNumber;
        }
        return a;
    }
}
