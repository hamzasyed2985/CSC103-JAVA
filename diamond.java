public class Main{
    public static void main(String[] agrs) {


        int n=6;
        for (int i=1;i<=n;i++){
            for (int j=n;j>=i;j--){
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++){
                System.out.print(" "+j);
            }
            System.out.println(" ");}
        for (int i=n-1;i>=1;i--){
            for (int j=n;j>=i;j--){
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++){
                System.out.print(" "+j);
            }
            System.out.println(" ");}




    }}
