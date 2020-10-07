package com.matthew;

public class Main {

    public static void main(String[] args) {
        Leauge<Team<FootballPlayer>> footbalLeauge = new Leauge<>("AFL");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");

        Team<FootballPlayer> hawthorn = new Team<>("Hawthron");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        Team<BaseballPlayer> baseballTeam = new Team<>("gonwo");

        footbalLeauge.add(adelaideCrows);
        footbalLeauge.add(melbourne);
        footbalLeauge.add(fremantle);
        footbalLeauge.add(hawthorn);

//        footbalLeauge.add(baseballTeam);

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows,3,8);

        adelaideCrows.matchResult(fremantle,2,1);

        footbalLeauge.showLeaugeTable();
    }
}
