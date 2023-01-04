package practical_no_3;

import java.util.Scanner;
import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket("localhost", 8850);
            System.out.println("Enter the message:- ");

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(sc.nextLine());
            while (true) {
                System.out.println("reply form server is: " + dis.readUTF());
                System.out.println("Enter your message:- ");
                String str = sc.nextLine();
                if (str.equals(str)) {
                    System.out.println("Connection Terminated !!!");
                    break;
                }
                dos.writeUTF(str);

            }
            sc.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Connection Terminates!!");
        }

    }
}
