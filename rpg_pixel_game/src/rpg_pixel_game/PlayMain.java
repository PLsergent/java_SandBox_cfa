package rpg_pixel_game;
import java.util.Scanner;


public class PlayMain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    
    public static void main(String[] args) {
        System.out.println("============START GAME============");
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a character name: ");
        String char_name = reader.nextLine();
        int char_class;
        do {
            System.out.println("Choose your class: 1)Wizard, 2)Warrior, 3)Hunter");
            char_class = reader.nextInt();
        } while (char_class <= 0 || char_class > 3);
        
        Character char_player = new Warrior(char_name);
        switch (char_class) {
            case 1:
                char_player = new Wizard(char_name);
                break;
            case 2:
                char_player = new Warrior(char_name);
                break;
            case 3:
                char_player = new Hunter(char_name);
                break;
        }

        System.out.println(char_player.getAttributes());
        System.out.println("==================================");

        Boolean gameOver = false;
        while (!gameOver) {
            System.out.println("==============LEVEL" + char_player.getLevel() + "==============");
            System.out.println("Three waves of monsters are coming...");
            Monster[] wave_monsters = {new Monster(char_player.getLevel()), new Monster(char_player.getLevel()), new Monster(char_player.getLevel())};
            
            int i = 0;
            while (i < wave_monsters.length && !gameOver) {
                Monster m = wave_monsters[i];
                System.out.println(m.getAttributes());
                Boolean not_killed = true;
                while (not_killed && !gameOver) {
                    reader = new Scanner(System.in);
                    int spell;
                    do {
                        System.out.println("==================================");
                        System.out.println("Choose a spell to cast: " +  char_player.displaySpells() + " 4)Do nothing");
                        spell = reader.nextInt();
                    } while (spell <= 0 || spell > 3);

                    Boolean m_first;
                    if (m.getSpeed() > char_player.getSpeed()) {
                        System.out.println("The monster was to quick and hit you first...");
                        m.basicAttack(char_player);
                        if (char_player.isDead()) {
                            System.out.println("GAME OVER");
                            break;
                        }
                        m_first = true;
                    } else {
                        m_first = false;
                    }

                    switch (spell) {
                        case 1:
                            char_player.basicAttack(m);
                            break;
                        case 2:
                            char_player.damageSpell(m);
                            break;
                        case 3:
                            char_player.effectSpell();
                            break;
                        case 4:
                            break;
                    }

                    if (!m_first) {
                        m.basicAttack(char_player);
                        if (char_player.isDead()) {
                            System.out.println("GAME OVER");
                            gameOver = true;
                        }
                    }

                    System.out.println("Player LP: " + ANSI_GREEN + char_player.getLifePoint() + ANSI_RESET);
                    System.out.println("Monster LP: " + ANSI_RED + m.getLifePoint() + ANSI_RESET);

                    if (m.isDead()) {
                        not_killed = false;
                        System.out.println("The monster is dead !\n");
                    }
                }
                i++;
            }
            char_player.levelUp();
            System.out.println("LEVEL UP!!");
            System.out.println(char_player.getAttributes());
        }
    }
}