package practical_no_7;

import java.io.*;
import java.net.*;
public class server {

    public static void main(String[] args)throws Exception {
        ServerSocket ss = new ServerSocket(8850);
        String message="";
        try {
            Socket s = ss.accept();
            int count = 1;
           
            while(true)
            {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                message = message + dis.readUTF();
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF("Server: I have received bit number "+count+" send next bit");
                count++;
            }
            
        } catch (Exception e) {
            System.out.println("Data received form the client is:- "+message);
            System.out.println("Connection Terminated!!!");
        }
        finally{
            ss.close();
        }
    }
    
}
