public enum Zodiac {


    TheRam(21, 3, 20, 4, "Овен"),
    TheBull(21, 4, 21, 5, "Телец"),
    TheTwins(22, 5, 21, 6, "Близнецы"),
    TheCrab(22, 6, 22, 7, "Рак"),
    TheLion(23,7, 21, 8, "Лев"),
    TheMaiden(22, 8, 23, 9, "Дева"),
    TheScales(24, 9, 23, 10, "Весы"),
    TheScorpion(24, 10, 22, 11, "Скорпион"),
    TheArcher(23, 11, 22, 12, "Стрелец"),
    TheMountainSeaGot(23, 12, 20, 1, "Козел"),
    TheWaterBearer(21, 1, 19, 2, "Водолей"),
    TheFish(20, 2, 22, 3, "Рыбы");


    int firstDay;
    int firstMonth;
    int lastDay;
    int lastMonth;
    String title;
    Zodiac(int firstDay, int firstMonth, int lastDay, int lastMonth, String title) {
        this.firstDay = firstDay;
        this.firstMonth = firstMonth;
        this.lastDay = lastDay;
        this.lastMonth = lastMonth;
        this.title = title;
    }
    @Override
    public String toString() {
        String fM = firstMonth < 10 ? "0"+firstMonth : String.valueOf(firstMonth);
        String lM = lastMonth < 10 ? "0"+lastMonth : String.valueOf(lastMonth);

        return firstDay + "." + fM + " - " + lastDay + "." + lM + ":" + title;
    }
}
