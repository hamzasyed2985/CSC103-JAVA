import java.util.Arrays;
import java.util.Scanner;

public class nui {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter  size of array ");
        int row = in.nextInt();
        char[] array = new char[row];
        for (int i = 0; i < row; i++) {
            System.out.println("Enter a's b's c's "+i);
           array[i]=in.next().charAt(0);}
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }}