import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		
		Color col = Color.RED;
		System.out.println(col);
		
		Shape sha = Shape.RACECAR;
		System.out.println(sha);
		
		GamePieceAppearance gpa = new GamePieceAppearance(col, sha);
		System.out.println(gpa.getColor());
		System.out.println(gpa.getShape());
		
		GamePiece gp = GamePiece.RED_RACER;
		System.out.println(gp);
		
		Location loc = Location.STUDY;
		System.out.println(loc);
		
		BoardGame boardGame = new BoardGame();
		boardGame.addPlayer("Bob", GamePiece.RED_RACER, Location.HALL);
		boardGame.addPlayer("Sam", GamePiece.BLUE_RACER, Location.LIBRARY);
		
		System.out.println(boardGame.getPlayerGamePiece("Bob"));
		
		System.out.println(boardGame.getPlayerWithGamePiece(GamePiece.RED_RACER));
		
		System.out.println(boardGame.getPlayerWithGamePiece(GamePiece.BLUE_BOOT));
		
		boardGame.movePlayer("Bob", Location.BALLROOM);
		System.out.println(boardGame.getPlayersLocation("Bob"));
		
		Location[] newLocations = new Location[2];
		newLocations[0] = Location.KITCHEN;
		newLocations[1] = Location.KITCHEN;
		String[] playerNames = new String[2];
		playerNames[0] = "Bob";
		playerNames[1] = "Sam";
		boardGame.moveTwoPlayers(playerNames, newLocations);
		System.out.println(boardGame.getPlayersLocation("Bob"));
		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Bob");
		list.add("Sam");
		System.out.println(boardGame.getPlayersAtLocation(Location.KITCHEN));
		
		ArrayList<GamePiece> list2 = new ArrayList<GamePiece>();
		list2.add(boardGame.getPlayerGamePiece("Bob"));
		list2.add(boardGame.getPlayerGamePiece("Sam"));
		System.out.println(boardGame.getGamePiecesAtLocation(Location.KITCHEN));
		
		System.out.println(boardGame.getPlayers());
		System.out.println(boardGame.getPlayerLocations());
		System.out.println(boardGame.getPlayerPieces());
		
		
		
		
		
	}

}
