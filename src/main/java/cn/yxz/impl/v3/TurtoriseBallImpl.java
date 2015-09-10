package cn.yxz.impl.v3;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import cn.yxz.Ball;
import cn.yxz.Race;

public class TurtoriseBallImpl implements Ball {

	private String name;
	private JFrame f;
	private int location;
	private Color color;

	public TurtoriseBallImpl(JFrame f) {
		this.f = f;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
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

			// 控制 速度
			sleep(50);
		}

	}

	private void sleep(long millsecond) {
		try {
			Thread.sleep(millsecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
		g.setColor(this.color);
		g.fillRect(x, y, 16, 16);
		g.drawString(getName(), x, y);
	}
}
