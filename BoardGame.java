
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class BoardGame 
{
	protected LinkedHashMap<String, GamePiece> playerPieces;
	protected LinkedHashMap<String, Location> playerLocations;
	
	public BoardGame()
	{
		playerPieces = new LinkedHashMap<String, GamePiece>();
		playerLocations = new LinkedHashMap<String, Location>();
	}
	
	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initalLocation)
	{
		if(playerPieces.containsValue(gamePiece))
		{
			return false;
		}
		else
		{
			playerPieces.put(playerName, gamePiece);
			playerLocations.put(playerName, initalLocation);
			return true;
		}
	}
	
	public GamePiece getPlayerGamePiece(String playerName)
	{
		return playerPieces.get(playerName);
	}
	
	public String getPlayerWithGamePiece(GamePiece gamePiece)
	{
		if(playerPieces.containsValue(gamePiece))
		{
			for(String playerName : playerPieces.keySet())
			{
				GamePiece piece = playerPieces.get(playerName);
				if(piece.equals(gamePiece))
				{
					return playerName;
				}
			}
			
		}
		return null;
	}
	
	public void movePlayer(String playerName, Location newLocation)
	{
		playerLocations.put(playerName, newLocation);
	}
	
	public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations)
	{
		String[] properOrder = new String[2];
		
		GamePiece player1 = getPlayerGamePiece(playerNames[0]);
		GamePiece player2 = getPlayerGamePiece(playerNames[1]);
		
		GamePiece first = GamePiece.movesFirst(player1, player2);
		
		if(first.equals(player1))
		{
			playerLocations.put(playerNames[0], newLocations[0]);
			playerLocations.put(playerNames[1], newLocations[1]);
			
			properOrder[0] = playerNames[0];
			properOrder[1] = playerNames[1];
			
		}
		else
		{
			playerLocations.put(playerNames[1], newLocations[0]);
			playerLocations.put(playerNames[0], newLocations[1]);
			
			properOrder[0] = playerNames[1];
			properOrder[1] = playerNames[0];
		}
		return properOrder;
	}
	
	public Location getPlayersLocation(String player)
	{
		return playerLocations.get(player);
	}
	
	public ArrayList<String> getPlayersAtLocation(Location loc)
	{
		ArrayList<String> list = new ArrayList<String>();
		playerLocations.forEach(
				(key, value) -> {
					if(value.equals(loc))
					{
						list.add(key);
					}
				}
				);
		return list;
	}
	
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc)
	{
		ArrayList<GamePiece> list = new ArrayList<GamePiece>();
		playerLocations.forEach(
				(key, value) -> {
					if(value.equals(loc))
					{
						list.add(getPlayerGamePiece(key));
					}
				}
				);
		return list;
	}
	
	public Set<String> getPlayers()
	{
		return playerPieces.keySet();
	}
	
	public Set<Location> getPlayerLocations()
	{
		Set<Location> location = new HashSet<>();
		location.addAll(playerLocations.values());
		return location;
	}
	
	public Set<GamePiece> getPlayerPieces()
	{
		Set<GamePiece> gamePiece = new HashSet<>();
		gamePiece.addAll(playerPieces.values());
		return gamePiece;
	}
}
