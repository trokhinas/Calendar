/**
 * Задача реализовать класс даты день/месяц/год.
 * К датам можно прибавлять определённый период дни,недели, месяцы и года
 *
 * Автор Трохин А.С.
 */


/*
* Осталось реализовать проверку на февраль в конструкторе
* И добавить знаки Зодиака
* */

public class Date {
    /*
    Константы
    * */
    private final int LEAP_YEAR_DAYS = 366;
    private final int YEAR_DAYS = 365;
    private final int DEFAULT_DAY = 1;
    private final int DEFAULT_MONTH = 1;
    private final int DEFAULT_YEAR = 1970;

    /*
    Приватные поля хранящие день, месяц и год соответственно
    * */
    private int day;
    private int month;
    private int year;


    public Date(int day, int month, int year) {
        this();
        if(DateValidator.isCorrectDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    public Date() {
        day = DEFAULT_DAY;
        month = DEFAULT_MONTH;
        year = DEFAULT_YEAR;
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    @Override
    public String toString() {
        String dayS = day >= 10 ? String.valueOf(day) : "0"+day;
        String monthS = month >= 10 ? String.valueOf(month) : "0"+month;
        return String.valueOf(dayS + "." + monthS + "." + year);
    }

    /**
     *
     * @param month - номер месяца число дней в котором надо вычислить
     * @return число дней конкретного месяца
     */
    private int dayOfMonth(int month) {
        int result = Month.values()[month - 1].getDay();
        if(month != 2)
            return result;
        return DateValidator.isLeapYear(year) ? result + 1 : result;
    }

    /**
     *
     * @param year - номер года число дней в котором надо вычислить
     * @return число дней конкретного года
     */
    private int dayOfYeaR(int year) {
        return DateValidator.isLeapYear(year) ? LEAP_YEAR_DAYS : YEAR_DAYS;
    }

    /**
     *
     * @param numOfDay - количество прибавляемых дней.
     *                 В этом метода все достаточно просто:
     *                 1)Записывается общая сумма дней.
     *                 2)Затем, проходит цикл по годам, вычитая из количества дней
     *                 количество дней в текущем году.
     *                 3)Следующий цикл по месяцам: аналогично циклу по годам, только
     *                 с месяцами.
     */
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

    /**
     *
     * @param numOfWeek - количество недель, которое надо прибавить.
     *                  Неделя = 7 дней, а дальше все сводится к добавлению дней
     */
    public void addWeek(int numOfWeek) {
        if(numOfWeek > 0)
            addDay(numOfWeek * 7);
    }

    /**
     *
     * @param numOfMonth - количество месяцев, которое надо прибавить.
     *                   Поскольку месяц - понятие растяжимое, то было принято решение
     *                   за месяц считать, количество дней в текущем месяце. Т.е, если
     *                   текущий месяц январь, то прибавится 31 день и так далее для месяцев.
     */
    public void addMonth(int numOfMonth) {// довольно странный метод  =)
        if(numOfMonth > 0) {
            for(int i = 0 ; i < numOfMonth ; i ++) {
                addDay(dayOfMonth(month));
            }
        }
    }

    /**
     *
     * @param numOfYear - количество лет, которое надо прибавить.
     *                  Тут простой инкремент года, ибо никаких проблем с датами не возникает.
     */
    public void addYear(int numOfYear) {
        if(numOfYear > 0) {
            postponeForMonth(numOfYear * 12);
        }
    }

    /**
     *
     * @param numOfMonth - количество месяцев на которое надо отложить/перенести дату.
     *                   Это самое интересное, потому что допустим перенося встречу с 31.10.2000 на месяц
     *                   вы ожидаете пойти на встречу 31.11.2000, которого не существует.
     *                   Поэтому перенос на месяц сделан по другим правилам нежели добавление месяца.
     */
    public void postponeForMonth(int numOfMonth) {
        if(numOfMonth > 0) {
            year += numOfMonth / 12;
            month += numOfMonth % 12;
            if(month > 12) {
                month -= 12;
                year ++;
            }
            day = day > dayOfMonth(month) ? dayOfMonth(month) : day;
        }
    }

    /**
     *
     * @return знак Зодиака для данной даты.
     */
    public Zodiac getZodiac() {
        for (Zodiac z :
                Zodiac.values()) {
                if(month == z.firstMonth) {
                    if (day >= z.firstDay) return z;
                }
                else if(month == z.lastMonth) {
                    if (day <= z.lastDay) return z;
                }
        }
        return null;
    }

    public static void main(String[] args) {
        Date d = new Date(29,2,2016);
        System.out.println(d);
        d.addYear(4);
        System.out.println(d);
        d.postponeForMonth(48);
        System.out.println(d);
        d.addYear(1);
        System.out.println(d);
//        d.addWeek(52);
//        d.addDay(1);
//
////        d.addDay(365);
//        System.out.println(d);
//        d.addYear(1);
//        System.out.println(d);
//        d.postponeForMonth(12);
//        System.out.println(d);
//        d.addMonth(12);
//        System.out.println(d);
////        for(int i = 0 ; i < 12 ; i ++) {
////            System.out.println(d.getZodiac());
////            d.postponeForMonth(1);
////        }
//////      System.out.println(d);
////        System.out.println(d.getZodiac());
////        d.postponeForMonth(1);
////        System.out.println(d);
////        System.out.println(d.getZodiac());
//    }
}
}

