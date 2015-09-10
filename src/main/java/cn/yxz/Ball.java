package cn.yxz;

import java.awt.Color;
import java.awt.Graphics;

public interface Ball {

	void setColor(Color color);

	void run(Race race);

	String getName();

	void setName(String s);

	int getCurrentLocation();

	void setCurrentLocation(int location);

	void draw(Graphics g, int x, int y);

}
