package rpg_pixel_game;


public class Warrior extends Character {

    Warrior() {
        super();
        this.armor = 3;
        this.speed = 1;
        this.strength = 3;
        this.weapon = new Sword(5);
    }
}