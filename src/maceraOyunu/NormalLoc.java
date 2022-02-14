package maceraOyunu;

public class NormalLoc extends Location {

    @Override
    public Boolean onLocation() {
        return true;
    }

    public NormalLoc(Player player, String name) {
        super(player, name);
    }
}
