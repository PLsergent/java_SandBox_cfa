package rpg_pixel_game;


public class Monster {

    private static final double LP_LEVEL_RATIO = 1.2;
    private static final double ARMOR_LEVEL_RATIO = 1.1;
    private static final double SPEED_LEVEL_RATIO = 1.1;

    private int lifePoint;
    private int armor;
    private int speed;
    private int strength;
    private int level;

    Monster() {
        this.lifePoint = 12;
        this.armor = 1;
        this.speed = 1;
        this.strength = 2;
        this.level = 1;
    }

    public void beingAttack(int damageTaken) {
        this.lifePoint -= damageTaken;
    }
}