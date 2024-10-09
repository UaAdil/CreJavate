package Modules.module6.practice5;

import java.util.Arrays;

public class GameTest {
    public static void main(String[] args) {
        Weapon sword = new Weapon("Sword", 15);
        Armor shield = new Armor("Shield", 10);
        Skill fireball = new Skill("Fireball", 30);
        Skill heal = new Skill("Heal", 20);

        Character hero = new Character("Hero", 100, 20, 15, 10, sword, shield,
                Arrays.asList(fireball, heal));

        Character cloneHero = hero.clone();

        System.out.println("Original: " + hero);
        System.out.println("Cloned: " + cloneHero);

        cloneHero.getSkills().get(0).setPower(40);
        System.out.println("After modifying clone:");
        System.out.println("Original: " + hero);
        System.out.println("Cloned: " + cloneHero);
    }
}

