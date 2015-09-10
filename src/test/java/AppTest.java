import org.mockito.Mockito;

import cn.yxz.Ball;
import cn.yxz.Game;
import cn.yxz.Race;
import org.testng.annotations.Test;

public class AppTest {

	@Test
	public void test() {

		Ball ball = Mockito.mock(Ball.class);
		Ball ball2 = Mockito.mock(Ball.class);

		Race race = Mockito.mock(Race.class);

		Game game = Mockito.mock(Game.class);

		game.setRace(race);

		game.add(ball);
		game.add(ball2);

//		Mockito.when(game.startRun()).

	}
}
