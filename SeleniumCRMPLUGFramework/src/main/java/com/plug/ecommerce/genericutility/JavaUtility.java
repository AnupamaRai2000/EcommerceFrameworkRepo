package com.plug.ecommerce.genericutility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

    

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10000);
    }

    public int getRandomNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    

    public String getCurrentDate() {

        Date date = new Date();

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy");

        return sdf.format(date);
    }

    public String getCurrentDateAndTime() {

        Date date = new Date();

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

        return sdf.format(date);
    }

   

    /**
     * Default format:
     * yyyyMMdd_HHmmss
     */
    public String getSystemDateInFormat() {

        Date date = new Date();

        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyyMMdd_HHmmss");

        return sdf.format(date);
    }

    

    public String getSystemDateInFormat(String format) {

        Date date = new Date();

        SimpleDateFormat sdf =
                new SimpleDateFormat(format);

        return sdf.format(date);
    }

   

    public String getTimestamp() {

        return new SimpleDateFormat(
                "yyyyMMdd_HHmmss")
                .format(new Date());
    }

   

    public LocalDateTime getLocalDateTime() {

        return LocalDateTime.now();
    }

    public String getLocalDateTimeInFormat(
            String format) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(format);

        return LocalDateTime.now()
                .format(formatter);
    }

    

    public int getCurrentYear() {

        return LocalDateTime.now().getYear();
    }

    

    public int getCurrentMonth() {

        return LocalDateTime.now().getMonthValue();
    }

    

    public int getCurrentDay() {

        return LocalDateTime.now().getDayOfMonth();
    }

   

    public void waitFor(long milliseconds) {

        try {

            Thread.sleep(milliseconds);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            throw new RuntimeException(
                    "Thread was interrupted", e);
        }
    }

    public void waitForSeconds(int seconds) {

        waitFor(seconds * 1000L);
    }

    

    public String getUniqueEmail() {

        return "test"
                + getSystemDateInFormat()
                + "@gmail.com";
    }

    public String getUniqueUsername() {

        return "user"
                + getSystemDateInFormat();
    }

   
    public boolean isNullOrEmpty(String value) {

        return value == null
                || value.trim().isEmpty();
    }

    public String getValueOrEmpty(String value) {

        return value == null ? "" : value;
    }
}
