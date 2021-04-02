package service3;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class StringToCalendar {
    static GregorianCalendar convert(String str) {
        GregorianCalendar cal = new GregorianCalendar();
        String dayOfWeek = str.substring(0, 3);
        String dayNum = str.substring(8, 10);
        String hour = str.substring(16, 18);
        String min = str.substring(19);
        switch (dayOfWeek) {
            case "Mon" -> cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            case "Tue" -> cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            case "Wed" -> cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
            case "Thu" -> cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            case "Fri" -> cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            case "Sat" -> cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            case "Sun" -> cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        }
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dayNum));
        cal.set(Calendar.MINUTE, Integer.parseInt(min));
        cal.set(Calendar.HOUR, Integer.parseInt(hour));
        cal.set(Calendar.MONTH, Calendar.APRIL);
        cal.set(Calendar.YEAR, 2021);
        return cal;
    }
}
