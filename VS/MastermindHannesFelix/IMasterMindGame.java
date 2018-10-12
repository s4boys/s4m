package server;

import java.util.List;

import client.IClient;

public interface IMasterMindGame {

	public List<IClient> getClients();
	
	public void addClient(IClient aClient);
	
	public void removeClient(IClient aClient);
	
	public IClient getCreatingClient();
	
	public int[] checkNumbers(IClient aClient, int[] aGuessedDigits);
	
	public int getGameID();
	
	public boolean startGame();
	
	public boolean isGameRunning();
}
