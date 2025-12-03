package entity;

public abstract class Publication {
    private int year;
    private String name;
    private String date;

    public Publication() {
    }

    public Publication(int year, String name, String date) {
        this.year = year;
        this.name = name;
        this.date = date;
    }

    public String toCSV(){
        return getYear()+","+getName()+","+getDate();
    }

    @Override
    public String toString() {
        return "name='" + name +
                ", year=" + year +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
