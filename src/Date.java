public class Date {
    private final int LEAP_YEAR_DAYS = 366;
    private final int YEAR_DAYS = 365;

    private int day;
    private int month;
    private int year;

    private int []months =
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int day, int month, int year) {
        this();
        if(DateValidator.isCorrectDay(day)
                && DateValidator.isCorrectMonth(month)
                && DateValidator.isCorrectYear(year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    public Date() {
        day = 1;
        month = 1;
        year = 1970;
    }

    @Override
    public String toString() {
        String dayS = day >= 10 ? String.valueOf(day) : "0"+day;
        String monthS = month >= 10 ? String.valueOf(month) : "0"+month;
        return String.valueOf(dayS + "." + monthS + "." + year);
    }
    private int dayOfMonth(int month) {
        int result = months[month - 1];
        if(month != 2)
            return result;
        return DateValidator.isLeapYear(year) ? result + 1 : result;
    }
    private int dayOfYeaR(int year) {
        return DateValidator.isLeapYear(year) ? LEAP_YEAR_DAYS : YEAR_DAYS;
    }

    public void addDay(int numOfDay) {
        if(numOfDay > 0) {
            day += numOfDay;
            while (day > dayOfYeaR(year)) {
                day -= dayOfYeaR(year);
                year++;
            }
            while (day > dayOfMonth(month)) {
                day -= dayOfMonth(month);
                month ++;
                if(month > 12) {
                    month = 1;
                    year++;
                }
            }
        }

    }
    public void addWeek(int numOfWeek) {
        if(numOfWeek > 0)
            addDay(numOfWeek * 7);
    }
    public void addMonth(int numOfMonth) {
        if(numOfMonth > 0) {
            for(int i = 0 ; i < numOfMonth ; i ++) {
                addDay(dayOfMonth(month));
            }
        }
    }
    public void addYear(int numOfYear) {
        if(numOfYear > 0) {
            for(int i = 0 ; i < numOfYear ; i ++) {
                addDay(dayOfYeaR(year));
            }
        }
    }

    public static void main(String[] args) {
        Date d = new Date(31,1,2100);
        System.out.println(d);
        d.addDay(29);
        System.out.println(d);
    }
}
