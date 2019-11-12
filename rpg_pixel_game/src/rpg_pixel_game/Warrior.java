package rpg_pixel_game;


public class Warrior extends Character {

    private static final double LP_LEVEL_RATIO = 1.7;
    private static final double ARMOR_LEVEL_RATIO = 1.3;
    private static final double SPEED_LEVEL_RATIO = 1.1;
    private static final double STRENGTH_LEVEL_RATIO = 1.2;

    Warrior(String name) {
        super(name);
        this.armor = 3;
        this.speed = 1;
        this.strength = 3;
        this.weapon = new Sword(5);
    }

    public void damageSpell(Character m) {
        int totalDmg = (int)(this.strength * 1.8);
        int dmgDealed = m.beingAttack(totalDmg);
        System.out.println("Jump in your face " + PlayMain.ANSI_RED + "-" + dmgDealed + PlayMain.ANSI_RESET);
    }

    public void effectSpell() {
        System.out.println("Increase armor!!");
        this.armor++;
    }

    public String displaySpells() {
        return "1)basicAttack 2)jumpHit 3)increaseArmor";
    }

    public void levelUp() {
        this.lifePoint = 20;
        this.lifePoint += (int)(this.level * LP_LEVEL_RATIO);
        this.armor += (int)(this.level * ARMOR_LEVEL_RATIO);
        this.speed += (int)(this.level * SPEED_LEVEL_RATIO);
        this.strength += (int)(this.level * STRENGTH_LEVEL_RATIO);
        this.level++;
    }
}