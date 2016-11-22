package ru.mail.polis.sort;

/**
 * Created by kubri on 11/21/2016.
 */
public class ShellSort {
    public static int[] sort(int a[]) {
        for (int i = a.length / 2; i > 0; i /= 2) {
            for (int j = i; j < a.length; j++) {
                int temp = a[i];
                int k;
                for (k = j; k >= j; k -= i) {
                    if (temp < a[k - i]) {
                        a[k] = a[k - i];
                    }
                    else {
                        break;
                    }
                }
                a[k] = temp;
            }
        }
        return a;
    }
}
