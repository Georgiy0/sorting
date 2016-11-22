package ru.mail.polis.sort;

/**
 * Created by kubri on 11/21/2016.
 */
public class QuickSortFixedPivot {
    public static int[] sort(int a[]) {
        SortSup sort = new SortSup();
        sort.quickSort(a);
        return a;
    }
}

class SortSup {

    public void quickSort(int a[]) {
        quickSort(a, 0, a.length - 1);
    }


    public void quickSort(int a[], int left, int right) {
        int i = left;                          
        int k = right;                         

        if (right - left >= 1) {
            int pivot = a[left];       

            while (k > i) {
                while (a[i] <= pivot && i <= right && k > i)  
                    i++;                                    
                while (a[k] > pivot && k >= left && k >= i) 
                    k--;                                        
                if (k > i)                                      
                    swap(a, i, k);                      
            }
            swap(a, left, k);          
            quickSort(a, left, k - 1); 
            quickSort(a, k + 1, right);
        }
        else {
            return;
        }
    }

    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
