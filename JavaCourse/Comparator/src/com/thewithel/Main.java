package com.thewithel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam);
        System.out.println("After Sorting : " + footballTeam);

        Comparator<Player> s = (firstPlayer, secondPlayer) -> firstPlayer.compareTo(secondPlayer);

        for(Player p : footballTeam){
            System.out.println(p.getName());
        }

        PlayerAgeComparator playerComparator = new PlayerAgeComparator();

        Collections.sort(footballTeam, playerComparator);

        for(Player p : footballTeam){
            System.out.println(p.getName());
        }

        Collections.sort(footballTeam, (pl1, pl2) -> pl1.getAge() - pl2.getAge());

        for(Player p : footballTeam){
            System.out.println(p.getName());
        }

        Comparator<Player> byRanking = Comparator
                .comparing(Player::getRanking);
        Comparator<Player> byAge = Comparator
                .comparing(Player::getAge);

        Comparator<Player> sort = (firstPlayer, secondPlayer) -> firstPlayer.getRanking() - secondPlayer.getRanking();
        Collections.sort(footballTeam, sort);


        Collections.sort(footballTeam, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getRanking() - o2.getRanking();
            }
        });


        Collections.sort(footballTeam, (pl1, pl2) -> pl1.getRanking() - pl2.getRanking());


        Collections.sort(footballTeam, Comparator.comparing(Player::getName));
    }
}
