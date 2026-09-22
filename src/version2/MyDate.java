package version2;

public class MyDate {
    private int day;
    private int month;
    private int year;

    private static final String[] MONTH_ABBR = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public MyDate(int day, int month, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = (day >= 1 && day <= 31) ? day : 1;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = (month >= 1 && month <= 12) ? month : 1;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = (year > 0) ? year : 2000;
    }

    public void displayDate() {
        System.out.printf("%02d %s %04d%n", day, MONTH_ABBR[month - 1], year);
    }

    @Override
    public String toString() {
        return String.format("%02d %s %04d", day, MONTH_ABBR[month - 1], year);
    }
}