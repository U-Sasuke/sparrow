package priv.yq.sparrow.demo;

import java.util.Arrays;

/**
 * Created by yaoqing on 2019/1/8.
 */
public class TestDemo {

    private static int[] arr = new int[]{1, 5, 9, 8, 4, 2, 6, 5, 4, 3};

    public static void main(String[] args) {
        charuSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void kuaisuSort(int[] arr){

    }

    private static void charuSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    private static void xuanzeSort(int[] arr) {
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

    private static void maopaoSort(int[] arr) {
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

