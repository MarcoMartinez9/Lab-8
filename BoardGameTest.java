import java.util.ArrayList;

import java.util.HashSet;

import java.util.Set;


import org.junit.Assert;
import org.junit.Test;

public class BoardGameTest {
	
	
	
	@Test
	public void testAddPlayer()
	{
		BoardGame b = new BoardGame();
		String name = null;
		GamePiece a = null;
		Location loc = null;
		//Player Added
		name = "bob";
		a = GamePiece.RED_RACER;
		loc = Location.HALL;
		Assert.assertEquals("BoardGame addPlayer method is incorrect", true, b.addPlayer(name, a, loc));
		
		//Player not added due to GamePiece already being used
		String name2 = "John";
		Assert.assertEquals("BoardGame addPlayer method is incorrect", false, b.addPlayer(name2, a, loc));
		
	}
	
	@Test
	public void testGetPlayerGamePiece()
	{
		BoardGame boardGame = new BoardGame();
		String name = "bob";
		GamePiece gamePiece = GamePiece.RED_RACER;
		Location location = Location.HALL;
		boardGame.addPlayer(name, gamePiece, location);
		Assert.assertEquals("BoardGame getPlayerGamePiece method is incorrect", gamePiece,boardGame.getPlayerGamePiece(name));
	}
	
	@Test
	public void testGetPlayerWithGamePiece()
	{
		BoardGame boardGame = new BoardGame();
		String name = "bob";
		GamePiece gamePiece = GamePiece.RED_RACER;
		Location location = Location.HALL;
		boardGame.addPlayer(name, gamePiece, location);
		//Player exists
		Assert.assertEquals("BoardGame getPlayerWithGamePiece method is incorrect", name,boardGame.getPlayerWithGamePiece(gamePiece));
		
		//Player is not added
		name = "Same";
		gamePiece = GamePiece.BLUE_BOOT;
		location = Location.BALLROOM;
		Assert.assertEquals("BoardGame getPlayerWithGamePiece method is incorrect", null,boardGame.getPlayerWithGamePiece(gamePiece));
	}
	
	@Test
	public void testMovePlayer()
	{
		BoardGame boardGame = new BoardGame();
		String name = "bob";
		GamePiece gamePiece = GamePiece.RED_RACER;
		Location location = Location.HALL;
		
		boardGame.addPlayer(name, gamePiece, location);
		
		boardGame.movePlayer(name, Location.BALLROOM);
		
		Assert.assertEquals("BoardGame movePlayer is incorrect", Location.BALLROOM, boardGame.getPlayersLocation(name));
	}
	
	@Test
	public void testMoveTwoPlayers()
	{
		BoardGame boardGame = new BoardGame();
		boardGame.addPlayer("Bob", GamePiece.RED_RACER, Location.HALL);
		boardGame.addPlayer("Sam", GamePiece.BLUE_RACER, Location.BALLROOM);
		
		//playerNames[0] == Bob
		Location[] newLocations = new Location[2];
		newLocations[0] = Location.LIBRARY;
		newLocations[1] = Location.STUDY;
		
		String[] playerNames = new String[2];
		playerNames[0] = "Bob";
		playerNames[1] = "Sam";
		
		boardGame.moveTwoPlayers(playerNames, newLocations);
		
		Assert.assertEquals("Wrong", Location.LIBRARY,boardGame.getPlayersLocation("Bob"));
		Assert.assertEquals("Wrong", Location.STUDY,boardGame.getPlayersLocation("Sam"));
		
		//playernames[0] == Sam
		 newLocations = new Location[2];
		newLocations[0] = Location.LIBRARY;
		newLocations[1] = Location.STUDY;
		
		 playerNames = new String[2];
		playerNames[0] = "Sam";
		playerNames[1] = "Bob";
		
		boardGame.moveTwoPlayers(playerNames, newLocations);
		
		Assert.assertEquals("Wrong", Location.LIBRARY,boardGame.getPlayersLocation("Bob"));
		Assert.assertEquals("Wrong", Location.STUDY,boardGame.getPlayersLocation("Sam"));
		
	}
	
	@Test
	public void testGetPlayersAtLocation()
	{
		BoardGame boardGame = new BoardGame();
		boardGame.addPlayer("Bob", GamePiece.RED_RACER, Location.HALL);
		boardGame.addPlayer("Sam", GamePiece.BLUE_RACER, Location.HALL);
		ArrayList<String> list = new ArrayList<String>();
		list.add("Bob");
		list.add("Sam");
		Assert.assertEquals(list,boardGame.getPlayersAtLocation(Location.HALL));
	}
	
	@Test
	public void testGetGamePieceAtLocation()
	{
		BoardGame boardGame = new BoardGame();
		boardGame.addPlayer("Bob", GamePiece.RED_RACER, Location.HALL);
		boardGame.addPlayer("Sam", GamePiece.BLUE_RACER, Location.HALL);
		ArrayList<GamePiece> list = new ArrayList<GamePiece>();
		list.add(boardGame.getPlayerGamePiece("Bob"));
		list.add(boardGame.getPlayerGamePiece("Sam"));
		Assert.assertEquals(list,boardGame.getGamePiecesAtLocation(Location.HALL));
		
	}
	
	@Test
	public void tesGetPlayers()
	{
		BoardGame boardGame = new BoardGame();
		boardGame.addPlayer("Bob", GamePiece.RED_RACER, Location.HALL);
		boardGame.addPlayer("Sam", GamePiece.BLUE_RACER, Location.HALL);
		
		Set<String> expected = new HashSet<>();
		expected.add("Bob");
		expected.add("Sam");
		
		Assert.assertEquals(expected, boardGame.getPlayers());
		
	}
	
	@Test
	public void testGetPlayerLocations()
	{
		BoardGame boardGame = new BoardGame();
		boardGame.addPlayer("Bob", GamePiece.RED_RACER, Location.HALL);
		boardGame.addPlayer("Sam", GamePiece.BLUE_RACER, Location.LIBRARY);
		
		Set<Location> expected = new HashSet<>();
		expected.add(Location.HALL);
		expected.add(Location.LIBRARY);
		
		Assert.assertEquals(expected, boardGame.getPlayerLocations());
	}
	
	@Test
	public void testGetPlayerPieces()
	{
		BoardGame boardGame = new BoardGame();
		boardGame.addPlayer("Bob", GamePiece.RED_RACER, Location.HALL);
		boardGame.addPlayer("Sam", GamePiece.BLUE_RACER, Location.LIBRARY);
		
		Set<GamePiece> expected = new HashSet<>();
		expected.add(GamePiece.RED_RACER);
		expected.add(GamePiece.BLUE_RACER);
		
		Assert.assertEquals(expected, boardGame.getPlayerPieces());
	}
}
