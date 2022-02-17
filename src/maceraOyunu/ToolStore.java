package maceraOyunu;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public Boolean onLocation() {
        System.out.println("------Mağazaya Hoşgeldiniz!-----------");
        boolean showMenu = true;
        while (showMenu){

            System.out.println("1) Silahlar");
            System.out.println("2) Zırhlar");
            System.out.println("3) Çıkış Yap");
            System.out.print("Seçiminizi Yapın : ");
            int selectCase = Location.input.nextInt();

            while(selectCase<1 || selectCase>3){
                System.out.println("Geçersiz değer, tekrar giriniz.");
                selectCase = Location.input.nextInt();
            }

            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar Bekleriz!");
                    showMenu=false;
                    break;
            }

        }
        return true;
    }

    public void printWeapon(){
        System.out.println("Silahlar");

        for (Weapon w: Weapon.weapons()) {
            System.out.println(w.getId() +"-"+w.getName() +" <Para : "+ w.getMoney()+" , Hasar : " + w.getDamage() + ">");
            
        }

        System.out.println("0 ile çıkış yap");

    }

    public void buyWeapon(){
        System.out.print("Silah Seçiminiz: ");
        int selectCase = Location.input.nextInt();

        while(selectCase<0 || selectCase>Weapon.weapons().length){
            System.out.println("Geçersiz değer, tekrar giriniz.");
            selectCase = Location.input.nextInt();
        }

        if(selectCase != 0) {

            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectCase);

            if(selectedWeapon != null) {
                if(selectedWeapon.getMoney()>this.getPlayer().getMoney()){
                    System.out.println("Yeterli Para Bulunmamaktadır.");
                } else {
                    //Satin almanin gerceklestigi alan
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız");
                    int balance = this.getPlayer().getMoney()-selectedWeapon.getMoney();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : "+ this.getPlayer().getMoney());
                    System.out.println("Önceki Silahınız : "+this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız : "+this.getPlayer().getInventory().getWeapon().getName());
                }
            }

        }

    }

    public void printArmor(){
        System.out.println("Zırhlar");

        for (Armor a: Armor.armors()) {
            System.out.println(a.getId() +"-"+a.getName() +" <Para : "+ a.getPrice()+" , Blocked : " + a.getBlock() + ">");

        }

        System.out.println("0 ile çıkış yap");
    }

    public void buyArmor(){
        System.out.println("Zırh Seçiniz: ");
        int selectCase = input.nextInt();

        while(selectCase<0 || selectCase>Weapon.weapons().length){
            System.out.println("Geçersiz değer, tekrar giriniz.");
            selectCase = Location.input.nextInt();
        }

        if(selectCase != 0){

            Armor selectedArmor = Armor.getArmorObjByID(selectCase);

            if(selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız yok.");
                } else {
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız.");
                    int balance = this.getPlayer().getMoney()-selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    System.out.println("Önceki Zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Şimdiki zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
                }
            }

        }

    }
}
