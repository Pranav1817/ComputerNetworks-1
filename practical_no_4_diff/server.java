package practical_no_4_diff;

import java.io.*;
import java.net.*;
public class server {


    public static String diff_manchester_decoding(String str)
    {
        String dc ="";
        for(int i = 0; i< str.length(); i = i+2)
        {
            if(str.substring(i,i+2).equals("10") && i == 0)
            {
                dc = dc + '1';
            }
            else if ( str.substring(i,i+2).equals("01") && i == 0)
            {
                dc = dc + '0';
            }
            else if( str.substring(i-2,i).equals(str.substring(i,i+2)))
            {
                dc = dc +'0';
            }
            else if( !(str.substring(i-2,i).equals(str.substring(i,i+2))))
            {
                dc = dc + '1';
            }
        }

        return dc;
    }

    public static void main(String []args) throws Exception
    {

        ServerSocket ss = new ServerSocket(8850);
        Socket s = ss.accept();
        try{
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String message = dis.readUTF();
            System.out.println("message received from client:- "+message);
            message = diff_manchester_decoding(message);
            System.out.println("decoded message is:- "+message);
            System.out.println("Program terminated successfully");

        }catch(Exception e)
        {
            System.out.println("Program terminated.");
        }
        finally{
            ss.close();
            s.close();
        }
    }
    
}
