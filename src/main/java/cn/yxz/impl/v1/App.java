package cn.yxz.impl.v1;


import java.awt.Color;

import cn.yxz.Ball;
import cn.yxz.Game;
import cn.yxz.Race;

public class App {

	public static void main(String[] args) {

		Ball ball = new BallImpl();
		ball.setName("Bob");
		ball.setColor(Color.RED);

		Game game = new GameImpl();

		Race race = new RaceImpl();
		game.setRace(race);

		game.add(ball);

		game.startRun();

	}

}
