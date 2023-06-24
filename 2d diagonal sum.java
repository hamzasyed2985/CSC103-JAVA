import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter 1. for double dimession array: ");
        int dimension = in.nextInt();
        System.out.println("enter row size of array ");
        int row = in.nextInt();
        System.out.println("enter column size of array ");
        int col = in.nextInt();
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("enter element of row" + i + " \n enter for col " + j);
                array[i][j] = in.nextInt();
            }
        }

        summing(array);
    }

    public static void summing(int[][] arr) {
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" "+arr[i][j]);
            }
            System.out.println(" ");}
        int total = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++) {
                if(i==j){
                total += arr[i][j];}
            }

        }
        System.out.println("SUM of diagnal:" + total);
    }




}