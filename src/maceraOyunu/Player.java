package maceraOyunu;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public void selectChar(){
        Character[] charList = {new Samurai(),new Archer(),new Knight()};

        for (Character character: charList ) {
            System.out.println("ID: "+character.getId()+"\t Karakter:"+character.getName()+ "\t Hasar: "+character.getDamage()+ "\t Sağlık: "+character.getHealth()+ "\t Para:"+character.getMoney());
        }

        System.out.println("----------------------------------");
        System.out.println("Lütfen Karakter Seçiniz : ");

        int selectChar = input.nextInt();

        switch(selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println(this.getCharName() + " karakterini seçtiniz");

    }

    public void initPlayer(Character character){

        this.setCharName(character.getName());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}
