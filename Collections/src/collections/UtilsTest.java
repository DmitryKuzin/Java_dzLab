package collections;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Gataullin Kamil
 * 28.09.2014 22:13:54
 */
public class UtilsTest {
    public static void main(String[] args) throws ParseException {
//        testPrimitiveWrappers();

//        testArrayUtils();

        testStringUtils();

//        testDateUtils();

 //       testRegexp();

    }


    private static void testPrimitiveWrappers() {
        System.out.println("***Parsing strings***");
        try {
            int i = Integer.parseInt("g");         // Перевод строки в число
            System.out.println(i);
            float f = Float.parseFloat("12.24");
            System.out.println(f);
            Integer integer = null;
            integer = new Integer(i);
            integer += 1;
            System.out.println(integer);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

    private static void testArrayUtils() {
        int[] srcArray = {1, 2, 3, 4, 5};
        int[] dstArray = {101, 102, 103, 104, 105};

        System.out.println("***arraycopy method***");
        System.arraycopy(srcArray, 3, dstArray, 2, 2);
        for (int i : dstArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("***sort method***");
        Arrays.sort(dstArray);
        for (int i : dstArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("***binarySearch method***");
        int index = Arrays.binarySearch(dstArray, 5);
        System.out.print(index);
        System.out.println();
    }

    private static void testStringUtils() {
        System.out.println("***Creating Strings***");
        String welcomeString = "Welcome";
        welcomeString += " to Java";
        System.out.println(welcomeString);

        System.out.println("***Concat strings***");
        long before = System.currentTimeMillis();
        String concatString = "";
        for (int i = 0; i < 10000; i++) {
            concatString += i;
        }
        long after = System.currentTimeMillis();
        long time = after - before;
        System.out.println("String concat time: " + time);

        System.out.println("***Append StringBuilder***");
        before = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append(i);
        }
        after = System.currentTimeMillis();
        time = after - before;
        System.out.println("StringBuilder concat time: " + time);

        System.out.println("***charAt method***");
        char c = welcomeString.charAt(12);
        System.out.println(c);

        System.out.println("***equals method***");
        boolean equals = welcomeString.equals("Welcome to JAVA");    // Сравнение строк
        System.out.println(equals);

        System.out.println("***equalsIgnoreCase method***");
        equals = welcomeString.equalsIgnoreCase("Welcome to JAVA");  // Сравнение строк без учета регистра
        System.out.println(equals);

        System.out.println("***indexOf method***");
        int index = welcomeString.indexOf("J");                      // Поиск подстроки, возврат индекса
        System.out.println(index);

        System.out.println("***subString method***");
        String subString = welcomeString.substring(3, 9);            // Возврат подстроки с 3 по 8 элемент
        System.out.println(subString);

        System.out.println("***split method***");
        String[] elems = welcomeString.split(" ");                   // Разбивает строку на подстроки по разделителю в скобках,
        for (String elem : elems) {                                  // возвращает массив строк,
            System.out.println(elem);                                // и он так же обрабатывает регулярные выражения
        }

        System.out.println("***replaceAll method***");
        String replacedString = welcomeString.replaceAll(" ", "_");  // Замена одной подстроки на другую
        System.out.println(replacedString);                          // так же работает с регулярными выражениями

        System.out.println("***endsWith method***");
        boolean endsWith = welcomeString.endsWith("Java");           // Проверка что строка заканчивается на "Java"
        System.out.println(endsWith);
    }

    private static void testDateUtils() throws ParseException {
        System.out.println("***Date creation***");
        Date now = new Date();
        System.out.println(now);                               // Находится текущее время

        System.out.println("***milliseconds in date***");
        long time = now.getTime();
        System.out.println(time);

        System.out.println("***Date comparison***");
        Date beforeDate = new Date(time - 100);
        boolean before = beforeDate.before(now);
        System.out.println(before);

        System.out.println("***Date formatting***");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String nowStr = dateFormat.format(now);
        System.out.println(nowStr);

        System.out.println("***Date parsing***");
        try {
            Date parsedDate = dateFormat.parse("14.10.1985 12:00");
            System.out.println(parsedDate);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(now);

        System.out.println("***Getting fields from Calendar***");
        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);

        System.out.println("***Rolling fields of Calendar***");
        calendar.roll(Calendar.DAY_OF_MONTH, 50);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.MONTH));

        System.out.println("***Adding fields of Calendar***");
        calendar.add(Calendar.DAY_OF_MONTH, 20);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.MONTH));
    }

    private static void testRegexp() {
        String emailRegexp = ".+@.+\\.[a-z]+";
        String email1 = "test123@gmail.com";
        String email2 = "test@test@test";
        boolean email1Matches = email1.matches(emailRegexp);
        boolean email2Matches = email2.matches(emailRegexp);
        System.out.println(email1Matches);
        System.out.println(email2Matches);
        System.out.println("Date: " + "11.15.2014".matches("\\d{2}\\.\\d{2}\\.\\d{4}"));
        System.out.println("Query: " + " >".matches("[^\\>\\<]+"));

        String phoneRegexp = "[+\\-()\\s0-9]+";
        String phone1 = "+7 (123) 456-78-99";
        String phone2 = "+7(abc)4567899";
        boolean phone1Matches = phone1.matches(phoneRegexp);
        boolean phone2Matches = phone2.matches(phoneRegexp);
        System.out.println(phone1Matches);
        System.out.println(phone2Matches);
        String a8="123:sdf\n234:dfg\n567:sdf";
        String a9="<a href=\"abc.xyz \"";
        String a10="<a href=\"abc.xyz \"";
        String a11="<a href=\"abc.xyz \"";
        String a12="<a href=\"abc.xyz \"";
        String a13="<a href=\"1\" class=\"2\"/>";
        String a14="a href=\"/home\" class=\"123\"/> привет</a>";
        String a15="adfggdg//adfadgdag/**/dsgsdgsdg/**/dsg";
        String a16="100;10;name;zero;";
        String a17="100;10;name;zero;";
        Pattern p8=Pattern.compile("\\d+:\\w");
        Matcher m8 = p8.matcher(a8);
        String str="";
        Map<Integer,String> map=new TreeMap<>();
        while(m8.find()){
            str= m8.group();
            map
        }
    }
}
