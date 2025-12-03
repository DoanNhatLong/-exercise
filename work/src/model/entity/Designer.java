package model.entity;

public class Designer extends Employee{
    String app;

    public Designer() {
    }

    public Designer(String app) {
        this.app = app;
    }

    public Designer(String id, String name, int year, String position, double salary, String app) {
        super(id, name, year, position, salary);
        this.app = app;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "app='" + app + '\'' +
                "} " + super.toString();
    }
}
