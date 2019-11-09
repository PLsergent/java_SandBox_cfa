package rpg_pixel_game;


public interface CharacterInterface {

    String getName();
    String getCharClass();
    String getAttributes();

    void basicAttack();
    void levelUp();

    int getLifePoint();
    int getArmor();
    int getSpeed();
    int getStrength();
    Weapon getWeapon();
}