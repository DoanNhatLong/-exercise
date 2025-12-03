package entity;

public class Drug {
    private String id;
    private String name;
    private String date;
    private int input;
    private int output=0;

    public Drug() {
    }

    public Drug(String id, String name, String date, int input) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.input = input;
    }

    public Drug(String id, String name, String date, int input, int output) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.input = input;
        this.output = output;
    }

    public String toCSV(){
        return getId()+","+getName()+","+getDate()+","+getInput()+","+getOutput();
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id='" + id +
                ", name='" + name +
                ", date='" + date +
                ", input=" + input +
                ", output=" + output +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }
}
