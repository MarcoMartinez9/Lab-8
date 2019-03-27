import org.junit.Assert;
import org.junit.Test;

public class GamePieceAppearanceTest {

	@Test
	public void testGamePieceAppearance()
	{
		GamePieceAppearance gpa = null;
		
		//RED RACECAR
		gpa = new GamePieceAppearance(Color.RED, Shape.RACECAR);
		Assert.assertEquals("GamePieceAppearance color incorrect", Color.RED , gpa.getColor());
		Assert.assertEquals("GamePieceAppearance color incorrect", Shape.RACECAR , gpa.getShape());
		
		
	}
	
}
