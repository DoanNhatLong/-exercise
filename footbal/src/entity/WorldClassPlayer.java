package entity;

public class WorldClassPlayer extends ElitePlayer {
    String spec2;

    public WorldClassPlayer() {
    }

    public WorldClassPlayer(String name, String position, int skill, int salary, String unique, String spec, String spec2) {
        super(name, position, skill, salary, unique, spec);
        this.spec2 = spec2;
    }

    public String getSpec2() {
        return spec2;
    }

    @Override
    public String toString() {
        return "WorldClassPlayer{" + super.toString() +
                "spec2='" + spec2 + '\'' +
                ", spec='" + spec + '\'' +
                "} ";
    }
}
