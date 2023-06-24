import java.util.Arrays;
import java.util.Scanner;

public class hello {
    /** Main method */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            System.out.println("enter "+i);
            array[i]= input.nextInt();
        }
        int temp;
        boolean swap;
        do{
            swap=false;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i]<array[i+1]){
                    temp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;
                    swap=true;
                }
            }
        }while (swap);
        System.out.println(Arrays.toString(array));
    }}