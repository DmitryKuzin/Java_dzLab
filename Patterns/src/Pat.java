import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pat {
    public static void main(String[] args) {
        String s1="NAME";
        String s2="adfnamefda";
        String s3a="aabbbbb";
        String s3b="*********";
        String param="123";
        String s3c="123123123";
        String s3d="\nsg\n\n";
        String s4="511-22-33";
        String s5="+7(843)654-89-65";
        String s6="Ivanov Ivan Ivanovich";
        String s7="example@mail.com";
        String s8="123:abc\n345:dsf";
        String s9="<a href=\"google.com\"/>";
        String s10="<a href=\"someuselesssite.com\"/>";
        String s11="<a href=\"mail.ru\"/><a href=\"ya.ru\"/>";
        String s12="<a href=\"hedgehog\"/>";
        String s13="<a href=\"1\" class=\"2\"/>";
        String s14="a href=\"home\" class=\"123\"/>hello!</a>";
        String s15="/**\n" +
                " * Created by kuzin on 9/30/2015.\n" +
                " */" +
                "some words" +
                "//        String s15=\"/**\\n\" +\n" +
                "//                \" * Created by kuzin on 9/30/2015.\\n\" +\n" +
                "//                \" */\" +\n" +
                "//                \"some words\" +\n" +
                "//                \"\";";
        String s16="100;10;name;zero100;10;name;zero100;10;name;zero";
        String s17="100;10;name;zero100;10;name;zero100;10;name;zero100;10;name;zero100;10;name;zero";

        Pattern p1=Pattern.compile("NAME");
        Pattern p2=Pattern.compile(".*?name*?.");
        Pattern p3a=Pattern.compile("a+b*");
        Pattern p3b=Pattern.compile("\\\\*\\**");
        Pattern p3c=Pattern.compile("(param){3}");
        Pattern p3d=Pattern.compile("(.|\n){5}");
        Pattern p4=Pattern.compile("[0-9]{3}-[0-9]{2}-[0-9]{2}");
        Pattern p5=Pattern.compile("\\+\\d\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}");
        Pattern p6=Pattern.compile("[A-Z?-?][a-z?-?]*?\\s[A-Z?-?][a-z?-?]*?\\s[A-Z?-?][a-z?-?]*?");
        Pattern p7=Pattern.compile("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}");

        Matcher m1=p1.matcher(s1);
        System.out.println(s1+"     "+m1.matches());

        Matcher m2=p2.matcher(s2);
        System.out.println(s2+"     "+m2.matches());

        Matcher m3a=p3a.matcher(s3a);
        System.out.println(s3a+"     "+m3a.matches());

        Matcher m3b=p3b.matcher(s3b);
        System.out.println(s3b+"     "+m3b.matches());

        Matcher m3c=p3c.matcher(s3c);
        System.out.println(s3c+"     "+m3c.matches());

        Matcher m3d=p3d.matcher(s3d);
        System.out.println(s3d+"     "+m3d.matches());

        Matcher m4=p4.matcher(s4);
        System.out.println(s4+"     "+m4.matches());

        Matcher m5=p5.matcher(s5);
        System.out.println(s5+"     "+m5.matches());

        Matcher m6=p6.matcher(s6);
        System.out.println(s6+"     "+m6.matches());

        Matcher m7=p7.matcher(s7);
        System.out.println(s7+"     "+m7.matches());

       // String[] p8=str8.split("\\n");
       // Matcher email=p7.matcher(str7);
       // System.out.println(email.matches());
        Map<Integer,String> map=new TreeMap();
//        for(String s : p8)
//        {
//            map.put(new Integer(s.substring(0, 3)), s.substring(4));
//        }
      //  String[] p9=str.split("\\\\<a href=");
     //   String[] p9a=str.split("\\\\<a href=?");
//        for(String s1:p9){
//            System.out.println(s1.substring(9,s1.indexOf("/>")-1));
//        }
//        String p10=str.replaceAll("\".*\"","\"123\"");
//        String p12=str.replaceAll("<a href=", "<a class=");
//        String p14=str.replace("\\.*/\\>\\</a\\>", " ");
    //    String p16=str.replaceFirst(";.+?;",";");
//        System.out.println(p10);
//        System.out.println(p12);
//        System.out.println(p14);
   //     System.out.println(p16);
   //     Pattern p=Pattern.compile("");
//        Pattern p8=Pattern.compile("(.*?):(.*)(\n|$)");

   //     Matcher m=p6.matcher(str);

        // n.replaceAll("$1");
        // map.put(m.group(1),m.group(2));
     //   System.out.println(m.matches());
    }
}
