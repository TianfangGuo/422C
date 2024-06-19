//Write a method merge that accepts two arrays of integers and returns a new array
//containing all elements of the first array followed by all elements of the second.

import java.util.Arrays;

public class Q2{
    
    public static int[] merge(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        for(int i = 0; i < a1.length; i++){
            result[i] = a1[i];
        }
        for(int i = 0; i < a2.length; i++){
            result[i + a1.length] = a2[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {12, 34, 56};
        int[] a2 = {7, 8, 9, 10};
        int[] a3 = merge(a1, a2);
        System.out.println(Arrays.toString(a3)); // [12, 34, 56, 7, 8, 9, 10]
    }
}
