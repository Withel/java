package com.matthew;

public class Main {

    public static void main(String[] args) {
//        Player player = new Player();
//        player.name = "time";
//        player.health = 20;
//        player.weapon = "sword";
//
//        int damage=10;
//        player.loseHealth(damage);
//
//        System.out.println(player.health);
//        //another way to do this is
//        System.out.println("remaining health = "+player.healthRemaining());
//
//        damage =11;
//        player.loseHealth(damage);
//        System.out.println(player.health);

        EnhancedPlayer theplayer = new EnhancedPlayer("Tim", 50, "Sword");
        System.out.println("Initial health is " + theplayer.getHealth());
        EnhancedPlayer randomplayer = new EnhancedPlayer();
        randomplayer.showPlayer();

        String playerName = "Dariusz";
        int playerHealth = 20;
        String playerWeapon = "Laser Gun";

        EnhancedPlayer playerInit = new EnhancedPlayer(playerName, playerHealth, playerWeapon);
        System.out.println("/n");
        playerInit.showPlayer();
    }
}
