import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of given options: ");
        System.out.println("1. For largest element in array: ");
        System.out.println("2. For index of largest element in array: ");
        System.out.println("3. For summing elements in array: ");
        System.out.println("4. For random array in array: ");
        System.out.println("5. For shuffling element in array: ");
        System.out.println("6. For shifting elements in array: ");
        System.out.println("7. For searching elements in array: ");
        System.out.println("8. For binary searching elements in array: ");
        int option = in.nextInt();
        if (option == 1) {
            System.out.println("enter 1. for double dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter row size of array ");
            int row = in.nextInt();
            System.out.println("enter column size of array ");
            int col = in.nextInt();
            int[][] array = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j=0;j<col;j++){
                System.out.println("enter element of row" + i+" \n enter for col " +j);
                array[i][j] = in.nextInt();}}
            largestelement(array);
        }
        if (option == 2) {
            System.out.println("enter 1. for double dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter row size of array ");
            int row = in.nextInt();
            System.out.println("enter column size of array ");
            int col = in.nextInt();
            int[][] array = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j=0;j<col;j++){
                    System.out.println("enter element of row" + i+" \n enter for col " +j);
                    array[i][j] = in.nextInt();}}

            indexoflargest(array);
        }
        if (option == 3) {
            System.out.println("enter 1. for double dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter row size of array ");
            int row = in.nextInt();
            System.out.println("enter column size of array ");
            int col = in.nextInt();
            int[][] array = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j=0;j<col;j++){
                    System.out.println("enter element of row" + i+" \n enter for col " +j);
                    array[i][j] = in.nextInt();}}

            summing(array);
        }
        if (option == 4) {
            System.out.println("enter 1. for double dimession array: ");
            int dimension = in.nextInt();
            Random rand=new Random();
            System.out.println("enter row size of array ");
            int row = in.nextInt();
            System.out.println("enter column size of array ");
            int col = in.nextInt();
            int[][] array = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j=0;j<col;j++){
                    array[i][j] = rand.nextInt(1,100);}}
            randomarray(array);
        }
        if (option == 5) {
            System.out.println("enter 1. for double dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter row size of array ");
            int row = in.nextInt();
            System.out.println("enter column size of array ");
            int col = in.nextInt();
            int[][] array = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j=0;j<col;j++){
                    System.out.println("enter element of row" + i+" \n enter for col " +j);
                    array[i][j] = in.nextInt();}
            }
            shuffling(array);
        }
        if (option == 6) {
            System.out.println("enter 1. for double dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter row size of array ");
            int row = in.nextInt();
            System.out.println("enter column size of array ");
            int col = in.nextInt();
            int[][] array = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j=0;j<col;j++){
                    System.out.println("enter element of row" + i+" \n enter for col " +j);
                    array[i][j] = in.nextInt();}
            }
            shifting(array);
        }
        if (option == 7) {
            System.out.println("enter 1. for double dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter row size of array ");
            int row = in.nextInt();
            System.out.println("enter column size of array ");
            int col = in.nextInt();
            int[][] array = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j=0;j<col;j++){
                    System.out.println("enter element of row" + i+" \n enter for col " +j);
                    array[i][j] = in.nextInt();}
            }
            searching(array);}
        if (option == 8) {
            System.out.println("enter 1. for double dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter row size of array ");
            int row = in.nextInt();
            System.out.println("enter column size of array ");
            int col = in.nextInt();
            int[][] array = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j=0;j<col;j++){
                    System.out.println("enter element of row" + i+" \n enter for col " +j);
                    array[i][j] = in.nextInt();}}
            System.out.println("enter the element you want to binary search");
            int inp=in.nextInt();
            System.out.println(   binary(array,inp));}
    }

    public static void largestelement(int[][] arr){
        int temp=0;
        for (int i=0;i< arr.length;i++){
            for(int j=0;j< arr.length;j++){
                if(arr[i][j]>temp) {
                    temp = arr[i][j];}}}
        System.out.println("largest "+temp);}
    public static void indexoflargest(int[][] arr){
        int temp=0;
        int temp1=0;
        for (int i=0;i< arr.length;i++){
            for (int j=0;j< arr.length;j++)
            if(arr[i][j]>temp){
                temp=i;
                temp1=j;
            }}
        System.out.println("Index of largest at row "+temp+" col "+temp1);}
    public static void summing(int[][] arr){
        int total=0;
        int total1=0;
        for (int j=0;j< arr.length;j++){
        for (int i=0;i< arr.length;i++){
            total+=arr[i][j];}System.out.println("SUM PER Col:"+total);
            total=0;}}
    public static void randomarray(int[][] arr){
        for(int i=0;i< arr.length;i++){
            for(int j=0;j< arr.length;j++){
                System.out.print(" "+arr[i][j]);
            }
            System.out.println("");
        }

}
    public static void shuffling(int[][] arr){
        System.out.println("Before Shuffling");
        for(int i=0;i< arr.length;i++){
            for(int j=0;j< arr.length;j++){
                System.out.print(" "+arr[i][j]);
            }
            System.out.println("");
        }

        Random rd=new Random();

        for (int i=0;i< arr.length;i++){
            for (int j=0;j< arr.length;j++){
                int randomindexrow=(int)(Math.random()*(arr[i].length));
                int randomindexcol=rd.nextInt(arr[j].length);
                int temp;
             temp=arr[i][j];
            arr[i][j]=arr[randomindexrow][randomindexcol];
            arr[randomindexrow][randomindexcol]=temp;}}
        System.out.println("After shuffling");
        for(int i=0;i< arr.length;i++){
            for(int j=0;j< arr.length;j++){
                System.out.print(" "+arr[i][j]);
            }
            System.out.println("");
        }
    }
    public static void shifting(int[][] arr) {
        Scanner in =new Scanner(System.in);
        System.out.println("enter index number for row to be shifted: ");
        int indexrow=in.nextInt();
        System.out.println("enter index number for col to be shifted: ");
        int indexcol=in.nextInt();
        System.out.println("enter another index number for row to get shifted: ");
        int index1=in.nextInt();
        System.out.println("enter another index number for col to get shifted: ");
        int index2=in.nextInt();
        int temp=0;
        temp=arr[indexrow][indexcol];
        arr[indexrow][indexcol]=arr[index1][index2];
        arr[index1][index2]=temp;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
            System.out.print(" "+arr[i][j]);
        }
            System.out.println(" ");
        }
    }
    public static void searching(int[][] arr){
        Scanner in =new Scanner(System.in);
        System.out.println("enter the element you want to search: ");
        int input =in.nextInt();
        int count=0;
        int fori=0;
        int forj=0;
        for(int i=0;i< arr.length;i++){
            for(int j=0;j< arr.length;j++){

            if (input==arr[i][j]){
                fori=i;
                forj=j;
                count++;}}}
        if(count>0){System.out.println("This element exists in array at row "+fori+"at col: "+forj);}
        else{System.out.println("this does not exist");}
    }
    public static int binary(int[][] arr,int key){
        int temp;
        int count=0;
        int fori=0;
        int forj=0;
        for (int i=0;i< arr.length;i++) {
            for(int j=0;j<arr.length;j++) {
                for (int k = 0; k < arr.length; k++) {
                    for (int l = 0; l < arr.length; l++) {
                        if (arr[i][j] < arr[k][l]) {
                            temp = arr[i][j];
                            arr[i][j] = arr[k][l];
                            arr[k][l] = temp;
                        }}}}}
        for (int i=0;i< arr.length;i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" "+arr[i][j]);}
            System.out.println(" ");}

        int rows = arr.length;
        int cols = arr[0].length;
        int start = 0;
        int end = rows * cols - 1;
        int mid, midRow, midCol, midVal;

        while (start <= end) {
            mid = (start + end) / 2;
            midRow = mid / cols;
            midCol = mid % cols;
            midVal = arr[midRow][midCol];

            if (midVal == key){
                return 1;
            } else if (midVal > key) {
                end = mid - 1;
            } else if (midVal < key){
                start = mid + 1;}}
        return 0;}
}

