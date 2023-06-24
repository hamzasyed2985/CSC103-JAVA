import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] array =
                        {{2 ,4, 3, 4, 5, 8, 8},
                        {7, 3, 4, 3, 3, 4, 4},
                        {3, 3, 4, 3, 3, 2, 2},
                        {9, 3, 4, 7, 3, 4, 1},
                        {3, 5, 4, 3, 6, 3, 8},
                        {3, 4, 4, 6, 3, 4, 4},
                        {3, 7, 4, 8, 3, 8, 4},
                        {6, 3, 5, 9, 2, 7, 9}};
        summing(array);}

    public static void summing(int[][] arr) {
        int[] array1=new int[7];
        int total = 0;
        for (int i = 0; i < arr[i].length; i++){

            total=0;
            for (int j = 0; j < arr[j].length; j++) {
                total+=arr[i][j];
            }
            array1[i]=total;
            }
        Arrays.sort(array1);
        int temp;
        for (int i = array1.length-1; i >= 0; i--){
            System.out.println("Employee "+i+" total hours "+array1[i]);

        }
    }




}