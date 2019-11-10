package rpg_pixel_game;


public class Wizard extends Character {

    Wizard(String name) {
        super(name);
        this.armor = 2;
        this.speed = 2;
        this.strength = 2;
        this.weapon = new Wand(5);
    }
}