import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter dize of array ");
        int size=in.nextInt();
        int count=0;
        int[] array=new int[size];
        for (int i=0;i< array.length;i++){
            System.out.println("enter input for element "+i);
            int input=in.nextInt();
            array[i]=input;}
        for (int i=1;i< 100;i++){
            count=0;
           for(int j=0;j< array.length;j++){
               if(array[j]==i){
                   count++;
               }
           }if(count!=0){
            System.out.println("number of "+i+"s is "+count);
        }}

    }}