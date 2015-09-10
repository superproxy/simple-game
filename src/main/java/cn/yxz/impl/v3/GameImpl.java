package cn.yxz.impl.v3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import cn.yxz.Ball;
import cn.yxz.Game;
import cn.yxz.Race;

public class GameImpl extends JFrame implements Game {

	private static final int _100 = 100;

	private List<Ball> balls = new ArrayList<Ball>();

	private JButton btnStart = new JButton();

	public GameImpl() {
		this.setLayout(null);
		this.setSize(800, 600);
		image = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_RGB);

		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GameImpl.this.startRun();
			}
		});

		this.add(btnStart);

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							GameImpl.this.repaint();
						}
					});

					try {
						Thread.sleep(500);// Fishworld的值
					} catch (InterruptedException e) {
						// e.printStackTrace();
					}

				}
			}
		});

		t.start();
	}

	private Race race;

	private BufferedImage image;

	private boolean enableBuffer = true;

	@Override
	public void paintComponents(Graphics g) {
		// 没有作用
		super.paintComponents(g);
	}

	@Override
	public void paint(Graphics g) {
		update(g); // 双缓冲要在update中

	}

	@Override
	public void update(Graphics g) {

		// 双缓冲
		if (enableBuffer) {
			// image = new BufferedImage(getWidth(), getHeight(),
			// BufferedImage.TYPE_INT_RGB);
			Graphics2D gfx = image.createGraphics();
			doMyPaint(gfx);
			
			g.drawImage(image, 0, 0, null);
			
			gfx.dispose();
			// image = null;
		} else {
			doMyPaint(g);
		}
	}

	private void doMyPaint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(Color.BLACK);
		g.drawString("TEST", 20, 100);

		g.drawLine(_100, 0, _100, this.getHeight());
		g.drawLine(_100 + race.getRace(), 0, 100 + race.getRace(),
				this.getHeight());

		for (int i = 0; i < balls.size(); i++) {
			Ball ball = balls.get(i);
			draw(i, ball, g);
		}
	}

	private void draw(int i, Ball ball, Graphics g) {
		if (ball.getCurrentLocation() == race.getRace()) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLUE);
		}

		int x = ball.getCurrentLocation() + _100;
		int y = (i + 1) * 100 + 100;
		ball.draw(g, x, y);

	}

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
