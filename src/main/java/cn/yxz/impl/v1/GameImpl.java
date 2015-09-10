package cn.yxz.impl.v1;

import java.util.ArrayList;
import java.util.List;

import cn.yxz.Ball;
import cn.yxz.Game;
import cn.yxz.Race;

public class GameImpl implements Game {

	private List<Ball> balls = new ArrayList<Ball>();

	private Race race;

	@Override
	public void setRace(Race race) {
		this.race = race;
	}

	@Override
	public void add(Ball ball) {
		balls.add(ball);
	}

	/**
	 * 每个 Ball启动, from down to top
	 */
	@Override
	public void startRun() {

		for (final Ball ball : balls) {

			// 每个ball开始跑
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					ball.run(race);
				}

			});
			t.start();
		}

	}

	@Override
	public void stopRun() {
	}

}
