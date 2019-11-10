package rpg_pixel_game;


public class Hunter extends Character {

    Hunter(String name) {
        super(name);
        this.armor = 1;
        this.speed = 3;
        this.strength = 2;
        this.weapon = new Bow(6);
    }
}