import java.util.Arrays;
import java.util.Scanner;

public class nui {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter  size of array ");
        int row = in.nextInt();
        int[] array = new int[row];


        for (int i = 0; i < row; i++) {
            System.out.println("Enter for "+i);
           array[i]=in.nextInt();}
        for( int x: array)
            System.out.println(x);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length ; j++) {

                if (i != j){
                    System.out.println(""+array[i]+"  "+array[j]);
                }
            }
        }

    }}