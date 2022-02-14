package maceraOyunu;

public class Weapon {

    private int id;
    private int damage;
    private int money;
    private String name;

    public Weapon(String name, int id, int damage, int money) {
        this.id = id;
        this.damage = damage;
        this.money = money;
        this.name = name;
    }

    public static Weapon[] weapons(){

        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon("Tabanca",1,2,15);
        weaponList[1] = new Weapon("Kılıç",2,3,35);
        weaponList[2] = new Weapon("Tüfek",3,7,45);

        return weaponList;
    }

    public static Weapon getWeaponObjByID(int id){

        for (Weapon w: Weapon.weapons()) {
            if(w.getId() == id)
                return w;
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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
}
