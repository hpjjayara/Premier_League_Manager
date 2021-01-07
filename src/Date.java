import java.io.Serializable;

public class Date implements Serializable {
    private static final long serialVersionUID = 2L;
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

    }

    public Date() {

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return getDate();

    }

    public String getDate() {
        String date;
	//set date in "01/03/2020" this format
        if (month <= 9) {
            if (day <= 9) {
                date = "0" + day + "/0" + month + "/" + year;
            } else {
                date = day + "/0" + month + "/" + year;
            }
        } else {
            if (day <= 9) {
                date = "0" + day + "/" + month + "/" + year;
            } else {
                date = day + "/" + month + "/" + year;
            }
        }

        return date;
    }


}




