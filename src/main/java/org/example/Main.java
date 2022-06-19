package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void programForDate(String date){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(date, formatter);
            System.out.printf("%s%n", localDate);

            // будет через 30 дней
            System.out.print("Через 30 дней будет ");
            System.out.println(localDate.plusDays(30));

            // будет последним воскресеньем в месяце от этой даты
            YearMonth ym = YearMonth.of(localDate.getYear(), localDate.getMonth());
            LocalDate endDate = ym.atEndOfMonth();
            DayOfWeek day = endDate.getDayOfWeek();
            int lastDay = day.getValue();
            System.out.print("Эта дата будет последним воскресеньем в этом месяце: ");
            if(lastDay < 7)
                endDate = endDate.minusDays(lastDay);
            System.out.println(endDate);

            //Программа должна рассчитать сколько дней составляет между этой датой и Новым Годом 31 декабря того же года
            Calendar calOne = Calendar.getInstance();
            int dayOfYear = calOne.get(Calendar.DAY_OF_YEAR);
            int year = calOne.get(Calendar.YEAR);
            Calendar calTwo = new GregorianCalendar(year, 11, 31);
            int Day = calTwo.get(Calendar.DAY_OF_YEAR);
            int total_days = Day - dayOfYear;
            System.out.println(total_days+" дней составляет между этой датой и Новым Годом");

        } catch (DateTimeParseException exc) {
            System.out.printf("%s is not parsable!%n", date);
        }

    }
    public static void main(String[] args) {
        programForDate("2022-06-18");
    }
}
