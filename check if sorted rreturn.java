import java.util.Arrays;
import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            System.out.println("enter " + i);
            array[i] = input.nextInt();
            System.out.println(
                    "The list is " + (Isorted(array) ? "already " : "not ") + "sorted");
        }
    }
    public static boolean Isorted(int[] array){

        for (int i = 0; i < array.length-1; i++) {

                if(array[i]>array[i+1]){
                    return false;
                }
                }

        return true;
    }}