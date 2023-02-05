// Configuration class for Form Automation project

import java.util.Random;

public class Utils {
    final static String BASE_URL = "https://magento.softwaretestingboard.com/";
    final static String CHROME_DRIVER_LOCATION = "chromedriver";

    public static String didNotLoadMessage(String msg) {
        return msg + " page did not open!";
    }

    public static String randomMail() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";
    }

    public static String randomFirstName() {
        String SALTCHARS1 = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt1 = new StringBuilder();
        Random rnd1 = new Random();
        while (salt1.length() < 5) { // length of the random string.
            int index = (int) (rnd1.nextFloat() * SALTCHARS1.length());
            salt1.append(SALTCHARS1.charAt(index));
        }
        String saltStr1 = salt1.toString();
        return saltStr1;
    }

    public static String randomLastName() {
        String SALTCHARS2 = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt2 = new StringBuilder();
        Random rnd2 = new Random();
        while (salt2.length() < 5) { // length of the random string.
            int index = (int) (rnd2.nextFloat() * SALTCHARS2.length());
            salt2.append(SALTCHARS2.charAt(index));
        }
        String saltStr1 = salt2.toString();
        return saltStr1;
    }

    public static String randomStreetAdress() {
        String SALTCHARS3 = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt3 = new StringBuilder();
        Random rnd2 = new Random();
        while (salt3.length() < 8) { // length of the random string.
            int index = (int) (rnd2.nextFloat() * SALTCHARS3.length());
            salt3.append(SALTCHARS3.charAt(index));
        }
        String saltStr3 = salt3.toString();
        return saltStr3;
    }

    public static String randomPhoneNumber() {
        String SALTCHARS4 = "123456789";
        StringBuilder salt4= new StringBuilder();
        Random rnd2 = new Random();
        while (salt4.length() < 8) { // length of the random string.
            int index = (int) (rnd2.nextFloat() * SALTCHARS4.length());
            salt4.append(SALTCHARS4.charAt(index));
        }
        String saltStr4 = salt4.toString();
        return "+355" + saltStr4 ;
    }
}

