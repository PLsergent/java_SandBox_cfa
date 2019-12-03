package back;


import java.util.Arrays;

public class Spell {
    String name;
    Energy[] energyNeeded;
    String damage;
    String description;

    Spell(String name, Energy[] energyNeeded, String damage, String description) {
        this.name = name;
        this.energyNeeded = energyNeeded;
        this.damage = damage;
        this.description = description;
    }

    public String toString() {
        return "Spell{" +
                "name='" + name + '\'' +
                ", energyNeeded=" + Arrays.toString(energyNeeded) +
                ", damage='" + damage + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}