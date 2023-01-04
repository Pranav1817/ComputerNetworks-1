package practical_no_5;

import java.util.Scanner;

public class characterStuffing {

    public static String charStuff(String str) {
        String ans = "";

        if (str.length() >= 8) {
            ans = ans + "/";
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                count++;

                if (count == 8) {
                    ans = ans + "/";
                }

                ans = ans + str.charAt(i);
            }
            ans = ans + "/";
            return ans;
        } else {
            ans = "/" + str + "/";
        }
        return ans;
    }

    public static String charDeStuff(String str) {
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '/') {
                ans = ans + str.charAt(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("Enter you code:-");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = charStuff(str);
        System.out.println("String after character stuffing:- ");
        System.out.println(str);
        System.out.println("String after destuffing:-");
        System.out.println(charDeStuff(str));
        sc.close();
    }
}
