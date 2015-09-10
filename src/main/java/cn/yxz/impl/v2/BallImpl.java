package cn.yxz.impl.v2;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import cn.yxz.Ball;
import cn.yxz.Race;

public class BallImpl implements Ball {

	private String name;
	private JFrame f;
	private int location;

	public BallImpl(JFrame f) {
		this.f = f;
	}

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

//			updateF();

			// 控制 速度
			sleep(1000);
		}

		finish();
//		updateF();
	}

	private void updateF() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				f.invalidate();
			}
		});
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
		return this.name;
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
	public void setCurrentLocation(int location) {
		this.location = location;

	}

	@Override
	public void draw(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
