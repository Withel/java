package com.matthew;

public class Main {

    public static void main(String[] args) {
	OutlanderTim outlander = new OutlanderTim(36);
	outlander.steer(45);
	//outlander.showOutlander();
	outlander.accelerate(30);
	outlander.accelerate(40);
	outlander.accelerate(-50);
	outlander.showOutlander();

    }
}
