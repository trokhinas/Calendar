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
            if(month == 2){
                return isLeapYear(year) ? day <= 29 : day <= 28;
            }
            return true;
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
