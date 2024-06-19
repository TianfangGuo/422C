//Write a method swapAll that accepts two arrays of integers as parameters and
//swaps their entire contents. Assume that the two arrays are the same length.

import java.util.Arrays;

public class Q1{
    
    public static void swapAll(int[] a1, int[] a2) {
        if(a1.length != a2.length){
            System.out.println("bad input, array sizes are different");
            return;
        }
        else if(a1.length == a2.length){
            int temp = 0;
            for(int i = 0; i < a1.length; i++){
                temp = a1[i];
                a1[i] = a2[i];
                a2[i] = temp;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        int[] a2 = {4, 5, 6};
        swapAll(a1, a2);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }
    

}

