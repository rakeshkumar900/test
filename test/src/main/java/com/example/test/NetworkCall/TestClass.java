package com.example.test.NetworkCall;

import android.os.Build;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;


public class TestClass {
static Boolean aa=true;
    private static final String BASE64_ENCODED_EXPIRY_DATE = "MjAyNS0zLTI4";  // Base64 encoded expiry date for "2024-05-31"

    // Static method to check expiry MjAyNC0wNS0zMQ==  2024-05-31
    public static Boolean checkExpiry()  {//throws Exception
        try{
        // Decode the Base64-encoded expiry date
        String decodedExpiryDateString = decodeBase64ToDate(BASE64_ENCODED_EXPIRY_DATE);

        // Parse the decoded expiry date string to a Date object
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expiryDate = dateFormat.parse(decodedExpiryDateString);
        Date currentDate = new Date();

        // Compare current date with decoded expiry date
        if (currentDate.after(expiryDate)) {
            aa=true;
           // throw new Exception("This JAR file has expired. Please update to the latest version.");
        }else {
            aa=false;
        }
        }catch (Exception e){}
        return aa;
    }

    // Method to decode Base64 string back to a normal date string
    public static String decodeBase64ToDate(String base64EncodedDate) {
        byte[] decodedBytes = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            decodedBytes = Base64.getDecoder().decode(base64EncodedDate);
        }
        return new String(decodedBytes);  // Return decoded date string
    }

    // Method to encode date string to Base64 (for reference)
    public static String encodeDateToBase64(String dateString) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Base64.getEncoder().encodeToString(dateString.getBytes());
        }
        return dateString;
    }

    // Example method to demonstrate functionality
    public String getAppInfo() {
        return "TestClass from com.example.test";
    }
}
