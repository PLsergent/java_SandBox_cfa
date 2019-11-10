package rpg_pixel_game;


public class Warrior extends Character {

    Warrior(String name) {
        super(name);
        this.armor = 3;
        this.speed = 1;
        this.strength = 3;
        this.weapon = new Sword(5);
    }
}