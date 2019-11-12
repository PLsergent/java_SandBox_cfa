package rpg_pixel_game;


public class Wizard extends Character {

    private static final double LP_LEVEL_RATIO = 1.6;
    private static final double ARMOR_LEVEL_RATIO = 1.1;
    private static final double SPEED_LEVEL_RATIO = 1.1;
    private static final double STRENGTH_LEVEL_RATIO = 1.1;

    Wizard(String name) {
        super(name);
        this.armor = 2;
        this.speed = 2;
        this.strength = 2;
        this.weapon = new Wand(5);
    }

    public void damageSpell(Character m) {
        int totalDmg = (int)(this.weapon.getDamage() * 1.8);
        int dmgDealed = m.beingAttack(totalDmg);
        System.out.println("Fire ball jutsu " + PlayMain.ANSI_RED + "-" + dmgDealed + PlayMain.ANSI_RESET);
    }

    public void effectSpell() {
        int totalHeal = 3 + (int)(this.level * 1.8);
        System.out.println("Heal " + PlayMain.ANSI_GREEN + "+" + totalHeal + PlayMain.ANSI_RESET);
        this.lifePoint += totalHeal;
    }

    public String displaySpells() {
        return "1)basicAttack 2)fireBall 3)heal";
    }

    public void levelUp() {
        this.lifePoint = 20;
        this.lifePoint += (int)(this.level * LP_LEVEL_RATIO);
        this.armor += (int)(this.level * ARMOR_LEVEL_RATIO);
        this.speed += (int)(this.level * SPEED_LEVEL_RATIO);
        this.strength += (int)(this.level * STRENGTH_LEVEL_RATIO);
        this.weapon.improve(this.strength);
        this.level++;
    }
}