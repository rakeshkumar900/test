package es.dmoral.toasty;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.view.Gravity;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class My_function {
    String formattedDate="";
    public static String date(String datepost) {
        String date = datepost.split("/")[1] + "/" + datepost.split("/")[0] + "/" + datepost.split("/")[2].substring(0, 4);
        return date;
    }

    public static boolean validateNumber(String toString) {

        boolean s = true;
        if (toString.length() == 10) {
            s = false;
        }
        if (toString.length() == 0) {
            s = false;
        }
        return s;
    }
    public static boolean validateNumber_10(String toString) {

        boolean s = true;
        if (toString.length() == 10) {
            s = false;
        }


        return s;
    }
    public static boolean validate_tl(String toString) {

        boolean s = true;
        if (toString.length() == 0) {
            s = false;
        }


        return s;
    }

    public static String Time(String datepost) {


        String timedate = datepost.split("/")[2].substring(0, 4) + " " + datepost.split("/")[2].split(" ")[1].split(":")[0] + ":" +
                datepost.split("/")[2].split(" ")[1].split(":")[1]
                + " " + datepost.split("/")[2].split(" ")[2];
        ;
        return timedate;
    }

    public static String Time2(String datepost) {


        String timedate = datepost.split("/")[2].substring(0, 4) + "\n" + datepost.split("/")[2].split(" ")[1].split(":")[0] + ":" +
                datepost.split("/")[2].split(" ")[1].split(":")[1]
                + " " + datepost.split("/")[2].split(" ")[2];
        ;
        return timedate;
    }

    public static String date_Time(String datepost) {
       /* Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new.png SimpleDateFormat("MMM");
        int monthnum=Integer.parseInt(datepost.split("/")[0]);
        cal.set(Calendar.MONTH,monthnum-1);
        String		gg = month_date.format(cal.getTime());
        String timedate=
                gg+" "+ datepost.split("/")[1]+", "+datepost.split("/")[2].substring(0,4)+" "+
                        datepost.split("/")[2].split(" ")[1].split(":")[0]+":"+
                        datepost.split("/")[2].split(" ")[1].split(":")[1]
                        +" "+ datepost.split("/")[2].split(" ")[2];*/
        try {
            String timedate = datepost.split("/")[1] + "/" + datepost.split("/")[0] + "/" + datepost.split("/")[2].substring(0, 4) +
                    " " +
                    datepost.split("/")[2].split(" ")[1].split(":")[0] + ":" +
                    datepost.split("/")[2].split(" ")[1].split(":")[1]
                    + " " + datepost.split("/")[2].split(" ")[2];
            ;
            return timedate;
        } catch (Exception e) {
            return "";
        }

    }

    public static String date_Month(String datepost) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMM");
        int monthnum = Integer.parseInt(datepost.split("/")[0]);
        cal.set(Calendar.MONTH, monthnum - 1);
        String gg = month_date.format(cal.getTime());
        String timedate =
                gg + " " + datepost.split("/")[1] + ", " + datepost.split("/")[2].substring(0, 4);
        return timedate;
    }

    public static String date_Month_dd(String datepost) {
        if (datepost.length() != 0) {
            String days = datepost.split("/")[1];
            if (days.length() == 1) {
                days = ("0" + days);
            }
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat month_date = new SimpleDateFormat("MM");
            int monthnum = Integer.parseInt(datepost.split("/")[0]);
            cal.set(Calendar.MONTH, monthnum - 1);
            String gg = month_date.format(cal.getTime());
            String timedate = days + "/" + gg + "/" + datepost.split("/")[2].substring(0, 4);
            return timedate;
        } else {
            return "";
        }
    }

    public static String date_day_month_year(String datepost) {

        try {
            String monthString = datepost.split("/")[1];
            String days = datepost.split("/")[0];
            if (monthString.length() == 1) {
                monthString = ("0" + monthString);
            }

            if (days.length() == 1) {
                days = ("0" + days);
            }
            String timedate = monthString + "/" + days + "/" + datepost.split("/")[2];
            return timedate;
        } catch (Exception e) {
            return "";
        }
    }

    public static String date_Month_dd_yar(String datepost) {
        String days = datepost.split("/")[1];
        if (days.length() == 1) {
            days = ("0" + days);
        }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MM");
        int monthnum = Integer.parseInt(datepost.split("/")[0]);
        cal.set(Calendar.MONTH, monthnum - 1);
        String gg = month_date.format(cal.getTime());
        String timedate =
                gg + "/" + days + "/" + datepost.split("/")[2].substring(0, 4);
        return timedate;
    }

    public static File createImageFile() throws IOException {
        // Create an image file name
        //String timeStamp = new.png SimpleDateFormat("yyyyMMdd_HHmmss").format(new.png Date());
        String timeStamp = "temp";
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DCIM), "Camera");
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        Uri mCurrentPhotoPath = Uri.parse("file:" + image.getAbsolutePath());
        return image;
    }

    public static String mobile(String phone_number) {
        String phone_numbers = "";
        try {


            if (phone_number.length() > 10) {
                int len = phone_number.length() - 10;
                phone_numbers = phone_number.substring(len, phone_number.length());

            } else {
                phone_numbers = phone_number;
            }
        } catch (Exception e) {
        }
        return phone_numbers;

    }

    public static void msg_Toast(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    // Static method to show a DatePickerDialog

    private String datePicker(Context mContext,final String format, final TextView form, String min_max) {

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        //String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());


        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYears, int dayOfMonths) {

                         formattedDate = formatDate(year, monthOfYears, dayOfMonths,format);

                        form.setText(dayOfMonths + "/" + (monthOfYears) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
        if ("0".equalsIgnoreCase(min_max)) {
            datePickerDialog.show();
            datePickerDialog.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis());
        } else {
            datePickerDialog.getDatePicker().setMinDate(Calendar.getInstance().getTimeInMillis());
            datePickerDialog.show();
        }
        return formattedDate;

    }




    // Utility method to format date as a string
    private static String formatDate(int year, int month, int day, String format) {
        String date="";
        String formattedMonth = (month < 9) ? "0" + (month + 1) : String.valueOf(month + 1);
        String formattedDay = (day < 10) ? "0" + day : String.valueOf(day);

        if(format.equalsIgnoreCase("/")){
            date= formattedMonth + format + formattedDay + format + year;
        }
        else {
            date= year + format+ formattedMonth +format + formattedDay;

        }
       return date;
    }

}
