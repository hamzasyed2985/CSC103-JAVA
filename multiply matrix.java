import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("enter row size of array ");
        int row = in.nextInt();
        System.out.println("enter column size of array ");
        int col = in.nextInt();
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j=0;j<col;j++){
                System.out.println("enter element of row" + i+" \n enter for col " +j);
                array[i][j] = in.nextInt();}}
        System.out.println("NOw enter elements for 2nd array: ");
        int[][] array2 = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j=0;j<col;j++){
                System.out.println("enter element of row" + i+" \n enter for col " +j);
                array[i][j] = in.nextInt();}}


        int[][] multiply = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j=0;j<col;j++){
                for(int k=0;k<row;k++)

                    multiply[i][j]+=array[i][k]*array2[k][j];
                }
                }

        for (int i = 0; i < row; i++) {
            for (int j=0;j<col;j++){
                System.out.println(multiply[i][j]);
            }}
    }}