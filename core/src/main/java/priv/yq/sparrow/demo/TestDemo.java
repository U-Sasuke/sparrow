package priv.yq.sparrow.demo;

import java.util.Arrays;

/**
 * Created by yaoqing on 2019/1/8.
 */
public class TestDemo {

    private static int[] arr = new int[]{7, 5, 9, 8, 4, 2, 6, 5, 4, 3};

    public static void main(String[] args) {
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            int[] temp = new int[high - low + 1];
            int i = low;
            int j = mid + 1;
            int k = 0;
            while (i <= mid && j <= high) {
                if (a[i] < a[j]) {
                    temp[k++] = a[i++];
                } else {
                    temp[k++] = a[j++];
                }
            }
            while (i <= mid) {
                temp[k++] = a[i++];
            }
            while (j <= high) {
                temp[k++] = a[j++];
            }
            for (int x = 0; x < temp.length; x++) {
                a[x + low] = temp[x];
            }
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int key = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= key) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= key) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = key;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    private static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    private static void selectSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
    }

    private static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}

