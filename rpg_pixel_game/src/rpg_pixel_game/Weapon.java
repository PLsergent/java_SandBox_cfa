package rpg_pixel_game;


public abstract class Weapon {

    protected int damage;


    // Constructor
    Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }

    public void improve(int improvmt) {
        this.damage += improvmt;
    }
}
