package maceraOyunu;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public Boolean onLocation() {
        System.out.println("Güvenli evdesiniz");
        System.out.println("Canınız yenilendi!");
        return true;
    }
}
