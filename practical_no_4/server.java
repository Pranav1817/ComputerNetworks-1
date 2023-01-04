package practical_no_4;

import java.io.*;
import java.net.*;
public class server {


    public static String manchester_decoding(String str)
    {
        String dc="";
        for(int i =0 ; i<str.length()-1; i= i+2)
        {
            if(str.substring(i, i+2).equals("10"))
            {
                dc = dc+"1";
            }else{
                dc = dc+"0";
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
            message = manchester_decoding(message);
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
