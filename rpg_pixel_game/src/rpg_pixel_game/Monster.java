package rpg_pixel_game;


public class Monster extends Character {

    private static final double LP_LEVEL_RATIO = 0.8;
    private static final double ARMOR_LEVEL_RATIO = 1.1;
    private static final double SPEED_LEVEL_RATIO = 1.1;
    private static final double STRENGTH_LEVEL_RATIO = 1.2;

    Monster(int level) {
        super();
        this.name = NameGenerator.generateName();
        this.lifePoint = (int)(10 * (level * LP_LEVEL_RATIO));
        this.armor = (int)(1 * (level * ARMOR_LEVEL_RATIO));
        this.speed = (int)(1 * (level * SPEED_LEVEL_RATIO));
        this.strength = (int)(3 * (level * STRENGTH_LEVEL_RATIO));
        this.level = level;
    }

    public String getAttributes() {
        return 
            "=========MONSTER ATTRIBUTES=======" + "\n" +
            "Name: " + this.name + "\n" +
            "LP: " + this.lifePoint + ", Lvl: " + this.level + "\n" +
            "Armor: " + this.armor + ", Speed: " + this.speed + ", Strength: " + this.strength;
    }

    public void basicAttack(Character c) {
        int dmgDealed = c.beingAttack(this.strength);
        System.out.println("Basic attack from the monster " + PlayMain.ANSI_RED + "-" + dmgDealed + PlayMain.ANSI_RESET);
    }

    public String displaySpells() {
        return "If don't have spell I'm a stupid monster";
    }

    public void levelUp() {};
    public void damageSpell(Character c) {};
    public void effectSpell() {};
}