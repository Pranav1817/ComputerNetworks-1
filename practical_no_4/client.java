package practical_no_4;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class client {

    public static String manchester(String str) {
        String en = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                en = en + "10";
            } else {
                en = en + "01";
            }
        }
        return en;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("localhost", 8850);
        try {
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            System.out.println("Enter data that you want to send:- ");
            String str = sc.nextLine();
            dos.writeUTF(manchester(str));
            System.out.println("message is Successfully send.");
            System.out.println("Program terminated.");
            s.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Connection Close");
        } finally {
            sc.close();
            s.close();
        }
    }

}
