package practical_no_3;

import java.util.Scanner;
import java.io.*;
import java.net.*;
public class server {
    public static void main(String []args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        ServerSocket ss = new ServerSocket(8850);
        try{
            Socket s = ss.accept();

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            System.out.println("message received form the Client:- "+dis.readUTF());

            while(true)
            {
                System.out.println("Enter responce:- ");
                dos.writeUTF(sc.nextLine());

                System.out.println("message received form the Client:- "+dis.readUTF());
            }
        }
        catch(Exception e)
        {
            System.out.println("Connection terminated!!");
        }
        finally{
            sc.close();
            ss.close();
        }


       
    }
}
