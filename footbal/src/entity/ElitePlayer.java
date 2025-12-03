package entity;

public class ElitePlayer extends NormalPlayer {
    String spec;

    public ElitePlayer() {
    }


    public ElitePlayer(String name, String position, int skill, int salary, String unique, String spec) {
        super(name, position, skill, salary, unique);
        this.spec = spec;
    }

    public String getSpec() {
        return spec;
    }

    @Override
    public String toString() {
        return "ElitePlayer{" + super.toString() +
                "spec='" + spec + '\'' +
                "} ";
    }
}
