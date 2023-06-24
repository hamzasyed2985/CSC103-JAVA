public class hello {

        public static void main(String[] agrs) {
            int n=7;
            for(int i =1;i<=n;i++){

                for(int j =1;j<=n;j++){
                    if(i==j|| j==n/2 +1||i==4  || i+j==n+1 ){
                        System.out.print("* ");}
                    else{
                        System.out.print("  ");
                    }}
                System.out.println("");
            }
        }
}
