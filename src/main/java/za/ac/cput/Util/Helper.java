package za.ac.cput.Util;

import java.util.Random;
import java.util.UUID;

public class Helper {

    public static boolean isNullOrEmpty(String str) {
        if (str.isEmpty() || str == null)
            return true;
        return false;
    }

    public static boolean isValidEmail(String email) {
        if(email != null&&email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            return true;
      } else {
           return false;
      }

    }
//    public static boolean isValidCurrencyFormat(String amount, int length) {
//        if (amount == null || amount.startsWith("R")) {
//            return false;
//        }
//
//        String numberPart = amount.substring(1); // Remove 'R' and check the rest
//        if (!numberPart.matches("\\d+")) {
//            return false;
//
//
//
//        }
//
//        return amount.length() == length; // Ensure it has the required length
//    }

    public static String gernerateId(){
        //String prefix = "CPUT";
        return UUID.randomUUID().toString();
    }

    // Method to generate a random number for Primary Keys
    public static String generateID(String prefix) {
        Random rand = new Random();
        int randomNum = rand.nextInt(9000000) + 1000000;
        //String prefix ="";
        String generateID= prefix + randomNum;
        return generateID;

    }


}



