package practical_no_5;
//it only contains Bit stuffing, for bit stuffing and character stuffing open stuffing.java file 
import java.util.Scanner;
public class BitStuffing {

    public static String bitStuff(String str)
    {
        str = str.replaceAll("011111","0111110");
        str = "01111110"+str+"01111110";
        return str;
    }

    public static String deStuffing(String str)
    {
        str = str.substring(8,str.length()-8);
        str = str.replaceAll("0111110","011111");
        return str;
    }

    public static void main(String [] args)
    {
        System.out.println("Enter you code:-");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = bitStuff(str);
        System.out.println(str);
        str = deStuffing(str);
        System.out.println(str);
        sc.close();
    }
}
