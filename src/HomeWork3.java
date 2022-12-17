

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class HomeWork3 {

    public static void main(String[] args) {
        Task3();
    }
    public static void Task1() {
        int[] arr1 = new int[] {21, 3, 24, 40, 4, 76, 78, 77, 900, 865, 654, 3, 1, 3754};
        mergeRecursion(arr1,0, arr1.length-1);
        for(int i : arr1) {
            System.out.print(i + " ");
        }

    }
    public static void mergeRecursion(int[] array, int mal, int big) {
        if (big <= mal) return;

        int seredina = (mal+big)/2;
        mergeRecursion(array, mal, seredina);
        mergeRecursion(array, seredina+1, big);
        merge(array, mal, seredina, big);
    }
    public static void merge(int[] array, int mal, int seridina, int big) {
        int larr[] = new int[seridina - mal + 1];
        int rarr[] = new int[big - seridina];
        int lind = 0;
        int rind = 0;

        for (int i = 0; i < larr.length; i++)
            larr[i] = array[mal + i];
        for (int i = 0; i < rarr.length; i++) {
            rarr[i] = array[seridina + i + 1];
        }

        for (int i = mal; i < big + 1; i++) {

            if (lind < larr.length && rind < rarr.length) {
                if (larr[lind] < rarr[rind]) {
                    array[i] = larr[lind];
                    lind++;
                } else {
                    array[i] = rarr[rind];
                    rind++;
                }
            } else if (lind < larr.length) {
                array[i] = larr[lind];
                lind++;
            } else if (rind < rarr.length) {

                array[i] = rarr[rind];
                rind++;
            }
        }
    }
    public static void Task2() {

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            arr.add(new Random().nextInt(1000));
        }
        System.out.println(arr);
        System.out.println(arr.stream().filter(x -> x % 2 != 0).collect(Collectors.toList()));
    }
    public static void Task3() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < 11; i++) {
            arr.add(new Random().nextInt(1000));
        }
        System.out.println(arr);
        System.out.println(Collections.max(arr));
        System.out.println(Collections.min(arr));
        Collections.sort(arr);
        if(arr.size() % 2 == 0) {
            int i = arr.size()/2;
            System.out.println(arr);
            System.out.println("Среднее число из списка могут быть [" + arr.get(i) +", " + arr.get(i+1) + "]");
        }
        else {
            System.out.println(arr);
            double i = (double) arr.size()/2;
            int a = ((int) i);
            System.out.println("Среднее число из списка могут быть [" + arr.get(a) + "]");
        }
    }
}