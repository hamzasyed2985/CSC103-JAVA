import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class hello {
    
    public static void main(String[] args) throws IOException {
        try{
        Scanner in = new Scanner(System.in);
        Filecraetion();
        FileWriting();

        while (true) {

            System.out.println("WELCOME! \n1.Press 1 for Admin\n2.Press 2 for User\n3.Press 0 to Exit ");
            String adminORuser = in.next();
            if (adminORuser.equalsIgnoreCase("1")) {
                adminpanel();
            } else if (adminORuser.equalsIgnoreCase("2")) {
                Userpanel();
            } else if (adminORuser.equalsIgnoreCase("0")) {
                break;
            }
        }}
        catch (InputMismatchException e){
            System.out.println("Error");
        }
    }

    public static void Filecraetion() {
        try {
            File myfile = new File("hello1.txt");
            boolean hello1 = myfile.createNewFile();
            System.out.println(hello1);
        } catch (IOException e) {
            System.out.println("erro=r ");
        }
    }

    public static void FileWriting() {
        try {
            FileWriter myfile = new FileWriter("hello1.txt");

            String[][] array = new String[100][10];
            for (int i = 0; i < array.length; i++) {
                if (i > 0) {
                    myfile.write("\n");
                }
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        array[i][j] = "" + i;
                        myfile.write(array[i][j] + ",");
                    } else if (j == 1) {
                        array[i][j] = "AVAILABLE";
                        myfile.write(array[i][j] + ",");
                    } else {
                        array[i][j] = "null";
                        myfile.write(array[i][j] + ",");
                    }

                }
            }
            myfile.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static boolean FileRead(int plotnum) throws IOException {

        try {
            String singlerecord = Files.readAllLines(Paths.get("hello1.txt")).get(plotnum);
            String linej = "Hello";

            String[] line = singlerecord.trim().split(",");
            for (int j = 1; j < 2; j++) {
                linej = line[j];

            }
            if (linej.equalsIgnoreCase("AVAILABLE")) {
                return true;
            } else if (linej.equalsIgnoreCase("Booked")) {
                return false;
            }
        }

    catch(InputMismatchException e)
    {
        System.out.println("Error");
    }
        return false;

}

    public static void adminpanel() throws IOException {
        Scanner in = new Scanner(System.in);
        try {
            if (Adminlogin() == 1) {
                System.out.println("Logged in successfully.");
                System.out.println("press 1. for Booking ");
                System.out.println("press 2. for Plots Status ");
                System.out.println("press 3. for Editing ");
                int admin = in.nextInt();
                if (admin == 1) {
                    booking();
                } else if (admin == 2) {
                    plotstatus();
                } else if (admin == 3) {
                    Editing();
                }
            } else
                System.out.println("Wrong Password");
        } catch (InputMismatchException e) {
            System.out.println("Please enter correct digit ");
        }
    }

    public static void Userpanel()throws IOException{

        plotstatus();
    }

    public static int Adminlogin() {
        Scanner in = new Scanner(System.in);
        String password = "admin";
        System.out.println("Enter your password: ");
        String admpass = in.next();
        if (admpass.equalsIgnoreCase(password)) {
            return 1;
        } else
            return 0;

    }

    public static void booking() throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter plot number for booking");
            int plotnum = in.nextInt();
            FileRead(plotnum);
            if (FileRead(plotnum)) {

                System.out.println("Enter the Owner's name: ");
                in.nextLine();
                String ownername = in.nextLine();
                
                EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 2, ownername);

                System.out.println("Enter Your Mobile Number: ");
                String mobno = in.nextLine();
                EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 3, mobno);
                System.out.println("Enter payment method \nPress 1 for full payment\nPress 2 for installments: ");
                int paymenttype = in.nextInt();
                if (paymenttype == 1) {
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 4, "Full Payment");
                    
                    fullpayment(plotnum);
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 1, "Booked");
                    System.out.println("Plot " + plotnum + " booked");
                } else if (paymenttype == 2) {
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 4, "Installments");
                   
                    Installmentplan(plotnum);
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 1, "Booked");
                    System.out.println("Plot " + plotnum + " booked");
                } else {
                    System.out.println("Enter correct number");
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 1, "Available");
                }

            } else System.out.println("Plot is already Booked");
        } catch (InputMismatchException e) {
            System.out.println("Mismatched error TRY AGAIN!");
        }
    }
    
    public static void EditSpecificLine(String key, String path, int index, int placementindex, String Details) {
        String tempFile = "temp.txt";
        File oldFile = new File(path);
        File newFile = new File(tempFile);

        String currentLine;
        String[] data;
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(",");
                if (data[index].equalsIgnoreCase(key)) {
                    // make changes to data array between these comments data array is like the
                    // row you want to make changes in
                    data[placementindex] = Details;
                    //  end
                    currentLine = String.join(",", data);
                }
                pw.println(currentLine);
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            boolean success = oldFile.delete();
            if (success) {
                System.out.print("");
            } else {
                System.out.println("file could not be deleted");
            }
            File dump = new File(path);
            boolean rename = newFile.renameTo(dump);
            if (rename) {
                System.out.print("");
            } else {
                System.out.print("file could not be renamed");
            }

        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }

    public static void fullpayment(int plotnum) {
        Scanner in = new Scanner(System.in);
        System.out.println("Press 1 if paid And 0 if not paid");
        String paid = in.next();
        if (paid.equals("1")) {
            EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 5, "Payment Status: Paid");
        } else if (paid.equals("0")) {
            EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 5, "Payment Status: Not Paid");
        } else {
            throw new InputMismatchException("Error");
        }

    }

    public static void Installmentplan(int plotnum) throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("Select the Installment Plant:\nPress \"1\" for 2 Installment Plan.\nPress \"2\" for 3 Installment Plan.");
        int plan = in.nextInt();
        if (plan == 1) {
            EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 6, "2 Installment Plan");
            System.out.println("Press 1 if First installment paid or 0 otherwise ");
            int first = in.nextInt();
            if (first == 0) {
                EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 7, "First Installment: NOT Paid");
                EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 8, "Second Installment: NOT Paid");
            } else if (first == 1) {
                EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 7, "First Installment: Paid");
                System.out.println("Press 1 if Second installment paid or 0 otherwise ");
                int second = in.nextInt();
                if (second == 1) {
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 8, "Second Installment: Paid");
                } else if (second == 0) {
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 8, "Second Installment: NOT Paid");
                }
            }
            String singlerecord = Files.readAllLines(Paths.get("hello1.txt")).get(plotnum);
            String[] line = singlerecord.trim().split(",");
            for (int j=0 ; j < 10; j++) {
                if(j==5){
                    if  (line[j].equalsIgnoreCase("null"))
                    {
                        if((line[8].equalsIgnoreCase("Second Installment: NOT Paid")))
                        {
                            EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 5, "Payment Status: Not Paid");

                        }else if(line[8].equalsIgnoreCase("Second Installment: Paid"))
                        {
                            EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 5, "Payment Status: Paid");
                            

                        }
                    }}}
        } else if (plan == 2) {
            EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 6, "3 Installment Plan");
           
            System.out.println("Press 1 if First installment paid or 0 otherwise ");
            int first = in.nextInt();
            if (first == 0) {
                EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 7, "First Installment: NOT Paid");
                EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 8, "Second Installment: NOT Paid");
                EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 9, "Third Installment: NOT Paid");
            } else if (first == 1) {
                EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 7, "First Installment: Paid");
                System.out.println("Press 1 if Second installment paid or 0 otherwise ");
                int second = in.nextInt();
                if (second == 0) {
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 8, "Second Installment: NOT Paid");
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 9, "Third Installment: NOT Paid");
                } else if (second == 1) {
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 8, "Second Installment: Paid");
                    System.out.println("Press 1 if Third installment paid or 0 otherwise ");
                    int third = in.nextInt();
                    if (third == 1) {
                        EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 9, "Third Installment: Paid");
                    } else if (third == 0) {
                        EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 9, "Third Installment: NOT Paid");
                    }
                }
            }
            String singlerecord = Files.readAllLines(Paths.get("hello1.txt")).get(plotnum);
            String[] line = singlerecord.trim().split(",");
            for (int j=0 ; j < 10; j++) {
                if(j==5){
                    if  (line[j].equalsIgnoreCase("null"))
                    {
                        if((line[9].equalsIgnoreCase("Third Installment: NOT Paid")))
                        {
                            EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 5, "Payment Status: Not Paid");
                           

                        }else if(line[9].equalsIgnoreCase("Third Installment: Paid"))
                        {
                            EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 5, "Payment Status: Paid");

                        }
                    }}}
        }
    }

    public static void plotstatus() throws IOException{
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Enter plot number for details (1-99): ");
            int plotnum = in.nextInt();

            if (plotnum < 100) {
                FileRead(plotnum);
                if (!FileRead(plotnum)) {
                    String singlerecord = Files.readAllLines(Paths.get("hello1.txt")).get(plotnum);
                    String[] line = singlerecord.trim().split(",");
                    for (int j=0 ; j < 10; j++) {
                        if(j==0){
                            System.out.println("Plot No: "+line[j]);
                        }
                        if (j == 1) {
                            System.out.println("Plot Status: "+line[j]);
                        } else if (j == 2) {
                            System.out.println("Owner's Name: " + line[j]);
                        } else if (j == 3) {
                            System.out.println("Mobile Number " + line[j]);
                        } else if (j == 4) {
                            System.out.println("Payment Type: " + line[j]);
                        } else if (j == 5) {
                            if  (line[j].equalsIgnoreCase("null")){
                                System.out.println(line[j]);
                            }
                             if (!line[j].equalsIgnoreCase("null"))
                            {
                                if (line[9].equalsIgnoreCase("Third Installment: NOT Paid"))
                                {
                                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 5, "Payment Status: Not Paid");
                                    System.out.println(line[j]);
                                }else if(line[j].equalsIgnoreCase("Third Installment: Paid"))
                                {
                                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 5, "Paid");
                                    System.out.println(line[j]);

                                }
                                else
                                    System.out.println(line[j]);
                                }
                        } else if (j == 6) {
                            if (line[j].equalsIgnoreCase("null")){
                                System.out.print("");}
                            else {
                                System.out.println(line[j]);
                                }
                        } else if (j == 7) {
                            if (line[j].equalsIgnoreCase("null"))
                            {
                                System.out.print("");}
                            else {
                                System.out.println("Payment Status: " +line[j]);
                            }
                        }else if (j == 8) {
                            if(line[j].equalsIgnoreCase("null"))
                            {

                                System.out.print("");}
                            else {
                                System.out.println("Payment Status: " + line[j]);
                                }
                        }if(j==9){
                            if (line[j].equalsIgnoreCase("null"))
                            {
                                System.out.print("");}
                            else {
                                System.out.println("Payment Status: " + line[j]);
                                }
                        }
                    }
                }
                else {
                    System.out.println("Plot is not booked!");
                }}
        }
        catch(InputMismatchException e){
            System.out.println("Enter Correct Number");
        }}

    public static void Editing()throws IOException{
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Plot Number For Changes: ");
        int plotnum=in.nextInt();
        if (!FileRead(plotnum)){

            System.out.println("What do you want to change:\n1. For Name \n2. For Mobile Number\n3. For Payment Status\n4. For 1st Installment\n5. For 2nd Installment\n6. For 3rd Installment");
            String change = in.next();
            if (change.equalsIgnoreCase("1")) {
                System.out.println("Enter New Name: ");
                in.nextLine();
                String name = in.nextLine();
                EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 2, name);
            } else if (change.equalsIgnoreCase("2")) {
                System.out.println("Enter New Mobile Number: ");
                in.nextLine();
                String mobno = in.nextLine();
                EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 3, mobno);
            } else if (change.equalsIgnoreCase("3")) {
                System.out.println("Type Payment Status: Paid or Not Paid");
                in.nextLine();
                String status = in.nextLine();
                if (status.equalsIgnoreCase("Paid")) {
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 5, "Payment Status: Paid");
                }
                else if (status.equalsIgnoreCase("Not Paid")) {
                    EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 5, "Payment Status: Not Paid");
                } else {
                    System.out.println("Status not correct!");
                }
            } else if (change.equalsIgnoreCase("4")) {
                String singlerecord = Files.readAllLines(Paths.get("hello1.txt")).get(plotnum);
                String[] line = singlerecord.trim().split(",");
                for (int j=0 ; j < 10; j++) {
                    if(j==7){
                if (line[j].equalsIgnoreCase("null")) {
                    System.out.print(" ");}
                else {
                    System.out.println("Type 1st Installment Status: Paid or Not Paid");
                    in.nextLine();
                    String status = in.nextLine();
                    if(status.equalsIgnoreCase("Paid")){
                        EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 7, "First Installment: Paid");
                        }
                    else if(status.equalsIgnoreCase("Not Paid")){
                        EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 7, "First Installment: Not Paid");
                    }else{
                        System.out.println("Status not correct!");}}}}
            } else if (change.equalsIgnoreCase("5")) {
                String singlerecord = Files.readAllLines(Paths.get("hello1.txt")).get(plotnum);
                String[] line = singlerecord.trim().split(",");
                for (int j=0 ; j < 10; j++) {
                    if(j==8){
                if (line[j].equalsIgnoreCase("null")) {
                    System.out.print(" ");}
                else {
                    System.out.println("Type 2nd Installment Status: Paid or Not Paid");
                    in.nextLine();
                    String status = in.nextLine();
                    if(status.equalsIgnoreCase("Paid")){
                        EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 8, "Second Installment: Paid");
                         }
                    else if(status.equalsIgnoreCase("Not Paid")){
                        EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 8, "Second Installment: Not Paid");
                    }else{
                        System.out.println("Status not correct!");}}}}
            } else if (change.equalsIgnoreCase("6")) {
                String singlerecord = Files.readAllLines(Paths.get("hello1.txt")).get(plotnum);
                String[] line = singlerecord.trim().split(",");
                for (int j=0 ; j < 10; j++) {
                    if(j==9){
                if (line[j].equalsIgnoreCase("null")) {
                    System.out.print(" ");}
                else {
                    System.out.println("Type 3rd Installment Status: Paid or Not Paid");
                    in.nextLine();
                    String status = in.nextLine();
                    if(status.equalsIgnoreCase("Paid")){
                        EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 9, "Third Installment: Paid");
                        }
                    else if(status.equalsIgnoreCase("Not Paid")){
                        EditSpecificLine(String.valueOf(plotnum), "hello1.txt", 0, 9, "Third Installment: Not Paid");
                    }else{
                        System.out.println("Status not correct!");}
                }}}}
        }
        else{
            System.out.println("Plot is not Booked!");
        }
    }
}




