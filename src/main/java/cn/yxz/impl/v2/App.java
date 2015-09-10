package cn.yxz.impl.v2;

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

				Ball ball = null;
				ball = new BallImpl(game);
				ball.setName("Bob");
				ball.setColor(Color.RED);
				game.add(ball);

				ball = new BallImpl(game);
				ball.setName("Alice");
				ball.setColor(Color.RED);
				game.add(ball);
				
				
				ball = new BallImpl(game);
				ball.setName("Turtorise");
				ball.setColor(Color.RED);
				game.add(ball);
				
				
				ball = new BallImpl(game);
				ball.setName("Rabbit");
				ball.setColor(Color.RED);
				game.add(ball);

				game.setVisible(true);
				
				game.startRun();

			}
		});

	}

}
