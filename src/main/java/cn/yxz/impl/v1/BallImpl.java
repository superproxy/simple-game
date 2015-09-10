package cn.yxz.impl.v1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import cn.yxz.Ball;
import cn.yxz.Race;

public class BallImpl implements Ball {

	private int location = 0;
	private String name;

	@Override
	public void setColor(Color color) {

	}

	@Override
	public void run(Race race) {
		while (getCurrentLocation() < race.getRace()) {

			// 打点的形式
			int oldLocation = getCurrentLocation();
			int newLocation = getCurrentLocation() + new Random().nextInt(10);

			if (newLocation > race.getRace()) {
				newLocation = race.getRace();
			}

			setCurrentLocation(newLocation);

			updatePosition(oldLocation, newLocation);

			// 控制 速度
			sleep(500);
		}
		finish();

	}

	private void sleep(long millsecond) {
		try {
			Thread.sleep(millsecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void updatePosition(int oldPosition, int newPosition) {
		for (int i = oldPosition; i < newPosition; i++) {
			System.out.print(".");
		}
		System.out.print("|");
	}

	private void finish() {
		System.out.print("!");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String s) {
		this.name = s;
	}

	@Override
	public int getCurrentLocation() {
		return this.location;
	}

	@Override
	public void setCurrentLocation(int newLocation) {
		this.location = newLocation;
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
