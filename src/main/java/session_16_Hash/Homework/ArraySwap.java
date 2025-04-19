package session_16_Hash.Homework;

import java.util.Arrays;

public class ArraySwap {
    public static void main(String[] args) {
        Integer[] integerArr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(integerArr));
        swapElements(integerArr, 1, 4);
        System.out.println(Arrays.toString(integerArr));

        System.out.println();
        String[] stringArr = {"Jane", "David", "John", "Alice", "Maria"};
        System.out.println(Arrays.toString(stringArr));
        swapElements(stringArr, 1, 3);
        System.out.println(Arrays.toString(stringArr));
    }

    public static <T> void swapElements(T[] arr, int firstIndex, int secondIndex){
        if ((firstIndex >= 0 && firstIndex < arr.length) && (secondIndex >= 0 && secondIndex < arr.length)){
            T temp = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = temp;
        } else {
            System.out.println("Invalid index");
        }
    }
}
