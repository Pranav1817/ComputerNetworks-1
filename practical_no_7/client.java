package practical_no_7;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class client {


    public static void main(String[] args)throws Exception {
        Socket s = new Socket("localhost",8850);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter Data bits: ");
            while(true){
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                System.out.print("Client:- ");
                String str = sc.nextLine();
                if(str.equals("end"))
                {
                    break;
                }
                dos.writeUTF(str);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                System.out.println(dis.readUTF());
            }
        } catch (Exception e) {
            System.out.println("Connection Terminated!!");
        }
        finally{
            s.close();
            sc.close();
        }
    }
    
}
