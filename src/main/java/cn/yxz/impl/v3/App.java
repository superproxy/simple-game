package cn.yxz.impl.v3;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import cn.yxz.Ball;
import cn.yxz.Race;

public class App {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				GameImpl game = new GameImpl();

				game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				Race race = new RaceImpl();
				game.setRace(race);

				Ball turtoriseBall  = new TurtoriseBallImpl(game);
                turtoriseBall.setName("Turtorise");
                turtoriseBall.setColor(Color.GREEN);
				game.add(turtoriseBall);

                Ball rabbitBall = new RabbitBallImpl(game);
                rabbitBall.setName("Rabbit");
                rabbitBall.setColor(Color.RED);
				game.add(rabbitBall);

				game.setVisible(true);

				game.startRun();

			}
		});

	}

}
