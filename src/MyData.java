

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import static java.net.InetAddress.getLocalHost;

public class MyData {

    public static void info() throws UnknownHostException {
        displayDateAndTime();
        displayName();
        displayLoggedUser();
        displayOperatingSystem();
        displayJavaVersion();
        displayAddr();

    }

    public static void displayDateAndTime(){
        SimpleDateFormat formatDate = new SimpleDateFormat(
                "dd/MM/yyyy  HH:mm:ss z");
        Date date = new Date();
        System.out.println(formatDate.format(date));

    }

    public static void displayName(){
        System.out.println("Michalina Janik 254564");
    }

    public static void displayLoggedUser(){
        System.out.println(System.getProperty("user.name"));
    }

    public static void displayOperatingSystem(){
        System.out.println(System.getProperty("os.name"));
    }

    public static void displayJavaVersion(){
        System.out.println(System.getProperty("java.version"));
    }


    public static void displayAddr() throws UnknownHostException {
        System.out.println(Inet4Address.getLocalHost().getHostAddress());
    }






}

