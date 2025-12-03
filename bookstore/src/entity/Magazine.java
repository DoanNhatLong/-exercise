package entity;

public class Magazine extends Publication{
    private String author;
    private int volume;

    public Magazine() {
    }


    public Magazine(int year, String name, String date, String author, int volume) {
        super(year, name, date);
        this.author = author;
        this.volume = volume;
    }

    public String toCSV(){
        return "Magazine,"+super.toCSV()+","+getAuthor()+","+ getVolume();
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "author='" + author + '\'' +
                ", volumn=" + volume +
                "} " + super.toString();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
