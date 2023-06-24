import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter dize of array ");
        int size=in.nextInt();

        int[] array=new int[size];

        for (int i=0;i< array.length;i++){
            System.out.println("enter input for element "+i);
            int input=in.nextInt();
            array[i]=input;}
        for (int i = 0; i < array.length; i++) {
            int j;
            for ( j = 0; j < i; j++) {
                if (array[i] == array[j])
                    break;}
                if (i == j)
                    System.out.print(array[i] + " ");
            
    }}
}




