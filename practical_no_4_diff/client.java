package practical_no_4_diff;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class client {

    public static String diff_manchester_encoding(String str)
    {
        String en = "";

        for(int i= 0; i< str.length(); i++)
        {
            if(str.charAt(i) == '0' && i == 0)
            {
                en = en + "01";
            }else if(str.charAt(i) == '1' && i == 0)
            {
                en = en + "10";
            }else if( str.charAt(i) == '0' && i != 0)
            {
                en = en + en.charAt(en.length()-2)+en.charAt(en.length()-1);
            }else if( str.charAt(i) == '1' && i != 1)
            {
                en = en + en.charAt(en.length()-1)+en.charAt(en.length()-2);
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
            dos.writeUTF(diff_manchester_encoding(str));
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