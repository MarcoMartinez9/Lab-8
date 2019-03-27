import org.junit.Assert;
import org.junit.Test;

public class GamePieceTest {

	@Test
	public void testGamePieceValues()
	{
		GamePiece gp = null;
		
		//RED_RACECAR
		gp = GamePiece.RED_RACER;
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Color.RED, gp.getColor());
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Shape.RACECAR, gp.getShape());
		
		//BLUE_RACECAR
		gp = GamePiece.BLUE_RACER;
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Color.BLUE, gp.getColor());
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Shape.RACECAR, gp.getShape());
		
		//MAGENTA_RACECAR
		gp = GamePiece.MAGENTA_RACER;
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Color.MAGENTA, gp.getColor());
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Shape.RACECAR, gp.getShape());
		
		//RED_THIMBLE
		gp = GamePiece.RED_THIMBLE;
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Color.RED, gp.getColor());
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Shape.THIMBLE, gp.getShape());
		
		//BLUE_BOOT
		gp = GamePiece.BLUE_BOOT;
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Color.BLUE, gp.getColor());
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Shape.BOOT, gp.getShape());
		
		//GREEN_BOOT
		gp = GamePiece.GREEN_BOOT;
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Color.GREEN, gp.getColor());
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Shape.BOOT, gp.getShape());
		
		//YELLOW_BOOT
		gp = GamePiece.YELLOW_BOOT;
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Color.YELLOW, gp.getColor());
		Assert.assertEquals("Incorrect enum GamePiece values" + gp.name(), Shape.BOOT, gp.getShape());
	}
	
	@Test
	public void testMoveFirst()
	{	
		GamePiece a = null;
		GamePiece b = null;

		//a priority < b priority
		a = GamePiece.RED_RACER;
		b = GamePiece.BLUE_RACER;
		Assert.assertEquals("MoveFirst method is incorrect", a, GamePiece.movesFirst(a,b));
		
		//a priority > b priority
		a = GamePiece.BLUE_RACER;
		b = GamePiece.RED_RACER;
		Assert.assertEquals("MoveFirst method is incorrect", b, GamePiece.movesFirst(a,b));
	}
	
	@Test
	public void testToString()
	{
		GamePiece gp = GamePiece.RED_RACER;
		
		Assert.assertEquals("GamePiece toString method is incorrect", "RED_RACER: a RED racecar with priority 0", gp.toString());
	}
	
}
