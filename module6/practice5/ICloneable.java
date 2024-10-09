package Modules.module6.practice5;
import java.util.ArrayList;
import java.util.List;
public interface ICloneable<T> {
    T clone();
}

class Skill implements ICloneable<Skill> {
    private String name;
    private int power;

    public Skill(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public Skill clone() {
        return new Skill(this.name, this.power);
    }

    @Override
    public String toString() {
        return "Skill{name='" + name + "', power=" + power + '}';
    }
}

class Weapon implements ICloneable<Weapon> {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public Weapon clone() {
        return new Weapon(this.name, this.damage);
    }

    @Override
    public String toString() {
        return "Weapon{name='" + name + "', damage=" + damage + '}';
    }
}

class Armor implements ICloneable<Armor> {
    private String name;
    private int defense;

    public Armor(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public Armor clone() {
        return new Armor(this.name, this.defense);
    }

    @Override
    public String toString() {
        return "Armor{name='" + name + "', defense=" + defense + '}';
    }
}

class Character implements ICloneable<Character> {
    private String name;
    private int health;
    private int strength;
    private int agility;
    private int intelligence;
    private Weapon weapon;
    private Armor armor;
    private List<Skill> skills;

    public Character(String name, int health, int strength, int agility, int intelligence,
                     Weapon weapon, Armor armor, List<Skill> skills) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.weapon = weapon;
        this.armor = armor;
        this.skills = new ArrayList<>(skills); 
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    @Override
    public Character clone() {
        List<Skill> clonedSkills = new ArrayList<>();
        for (Skill skill : skills) {
            clonedSkills.add(skill.clone());
        }
        return new Character(this.name, this.health, this.strength, this.agility,
                this.intelligence, this.weapon.clone(), this.armor.clone(), clonedSkills);
    }

    @Override
    public String toString() {
        return "Character{name='" + name + "', health=" + health + ", strength=" + strength +
                ", agility=" + agility + ", intelligence=" + intelligence +
                ", weapon=" + weapon + ", armor=" + armor + ", skills=" + skills + '}';
    }
}
