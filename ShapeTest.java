import org.junit.Assert;
import org.junit.Test;

public class ShapeTest {
	
	@Test
	public void testShapeValues()
	{
		Shape sha = null;
		
		//THIMBLE
		sha = Shape.THIMBLE;
		Assert.assertEquals("Incorrect Shape" , sha, Shape.valueOf("THIMBLE"));
		
		//BOOT
		sha = Shape.BOOT;
		Assert.assertEquals("Incorrect Shape" , sha, Shape.valueOf("BOOT"));
		
		//RACECAR
		sha = Shape.RACECAR;
		Assert.assertEquals("Incorrect Shape" , sha, Shape.valueOf("RACECAR"));
	}
	
	@Test
	public void testToString()
	{
		//THIMBLE
		Assert.assertEquals("Shape toString incorrect", "thimble", Shape.THIMBLE.toString());
		
		//BOOT
		Assert.assertEquals("Shape toString incorrect", "boot", Shape.BOOT.toString());
		
		//RACECAR
		Assert.assertEquals("Shape toString incorrect", "racecar", Shape.RACECAR.toString());
	}
	
}
