package rpg_pixel_game;


public class Hunter extends Character {

    private static final double LP_LEVEL_RATIO = 1.6;
    private static final double ARMOR_LEVEL_RATIO = 1.1;
    private static final double SPEED_LEVEL_RATIO = 1.4;
    private static final double STRENGTH_LEVEL_RATIO = 1.2;

    Hunter(String name) {
        super(name);
        this.armor = 1;
        this.speed = 3;
        this.strength = 2;
        this.weapon = new Bow(6);
    }

    public void damageSpell(Character m) {
        int totalDmg = (int)(this.weapon.getDamage() * 1.8);
        int dmgDealed = m.beingAttack((int)(this.weapon.getDamage() * 1.8));
        System.out.println("Big arrow " + PlayMain.ANSI_RED + "-" + dmgDealed + PlayMain.ANSI_RESET);
    }

    public void effectSpell() {
        System.out.println("Increase speed!!");
        this.speed++;
    }

    public String displaySpells() {
        return "1)basicAttack 2)bigArrow 3)increaseSpeed";
    }

    public void levelUp() {
        this.lifePoint = 20;
        this.lifePoint += (int)(this.level * LP_LEVEL_RATIO);
        this.armor += (int)(this.level * ARMOR_LEVEL_RATIO);
        this.speed += (int)(this.level * SPEED_LEVEL_RATIO);
        this.strength += (int)(this.level * STRENGTH_LEVEL_RATIO);
        this.weapon.improve((int)(this.speed * 0.5));
        this.level++;
    }
}