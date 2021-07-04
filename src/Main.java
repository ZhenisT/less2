import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//      Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
//            int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] == 1) {
//                    arr[i] = 0;
//                } else {
//                    arr[i] = 1;
//                }
//                System.out.print(arr[i] + " ");
//            }

//       Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
//            int[] arr2 = new int[8];
//            for (int i = 0, j = 0; i < 8; i++, j+=3) {
//                arr2[i] = j ;
//        }
//            System.out.print(Arrays.toString(arr2));


//      Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
//        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] < 6) {
//                    arr[i] *= 6;
//                }
//            }
//        System.out.print(Arrays.toString(arr));


//      Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
//        int[][] arr = new int[4][4];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if ((arr[i] == arr[j]) && (arr[j] == arr[i]))
//                    arr[i][j] = 1;
//
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

//      ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

//        int [] arr = {11, 5, 35, 2, 11, 4, 5, 25, 4, 8, 9, 10};
//        int minArr = arr[0], maxArr = arr[0], temp;
//        if (arr[0] < arr[1]){
//            minArr = arr[0];
//            maxArr = arr[1];
//        } else {
//            maxArr = arr[0];
//            minArr = arr[1];
//        }
//
//        for (int i = 2; i < arr.length; i++) {
//            if (arr[i] < minArr){
//                minArr = arr[i];
//            } else {
//                if (arr[i] > maxArr){
//                    maxArr = arr[i];
//                }
//            }
//
//        }
//         System.out.println("Максимальный элемент массива: " + maxArr);
//         System.out.println("Минимальный элемент массива: " + minArr);

//      ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в
//        массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance
//         ([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
//         граница показана символами ||, эти символы в массив не входят .

        int[] arr = {11, 5, 35, 2, 11, 4, 5, 25, 4, 8, 9, 17};
        int[] arr2 = {11, 5, 35, 2, 11, 4, 5, 25, 4, 8, 9, 10};
        sumArr(arr);
        sumArr(arr2);
        arrSdvig(arr, -2);
    }


    public static boolean sumArr(int[] arr) {
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < 6; i++) {
            sumLeft += arr[i];
        }
        for (int i = 6; i < arr.length; i++) {
            sumRight += arr[i];
        }
        if (sumLeft == sumRight) {
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
    }

    public static void arrSdvig(int[] arr3, int n){
        n *=-1;
        for (int j=1; j <= n; j++) {
            int tmp = arr3[0];
            for (int i = 0; i < arr3.length - 1; i++) {
                arr3[i] = arr3[i + 1];
            }
            arr3[arr3.length - 1] = tmp;}
        System.out.print(Arrays.toString(arr3));
        }

}
