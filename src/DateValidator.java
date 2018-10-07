public class DateValidator {

    public static boolean isCorrectDay(int day) {
        return day > 0 && day <= 31;
    }
    public static boolean isCorrectMonth(int month) {
        return month > 0 && month <= 12;
    }
    public static boolean isCorrectYear(int year) {
        return year > 0;
    }
    public static boolean isCorrectDate(int day, int month, int year) {
        if(isCorrectDay(day) && isCorrectMonth(month) && isCorrectYear(year)) {
            int dayOfMonth = Month.values()[month - 1].getDay();
            if(month == 2)
                dayOfMonth = isLeapYear(year) ? dayOfMonth + 1 : dayOfMonth;
            return day <= dayOfMonth;
        }
        return false;
    }
    public static boolean isLeapYear(int year) {
        /*
          год, номер которого кратен 400, — високосный;
          остальные годы, номер которых кратен 100, — невисокосные;
          остальные годы, номер которых кратен 4, — високосные.
         */
        if(year % 400 == 0)
            return true;
        else if (year % 100 == 0)
            return false;
        else return year % 4 == 0;
    }
}
