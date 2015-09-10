package cn.yxz;

public interface Game {

	/**
	 * 假定只有一场比赛
	 * 
	 * @param race
	 */
	void setRace(Race race);

	void add(Ball ball);

	void startRun();

	void stopRun();

}
