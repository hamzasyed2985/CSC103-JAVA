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
        int a = array[0];
        int b = array[1];
        for( int x: array)
            System.out.println(x);

        for (int i = 0; i < array.length-2; i++){

            array[i]=array[i+2];}
        array[array.length-2]=a;
        array[array.length-1] = b ;


        System.out.println(Arrays.toString(array)
        );


    }}