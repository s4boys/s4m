package server;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import client.IClient;

public class MasterMindServer implements IMasterMindServer {

	private static final long serialVersionUID = -7124562435146796934L;
	private List<IMasterMindGame> mActiveGames;

	public MasterMindServer() {
		mActiveGames = new ArrayList<IMasterMindGame>(); // Liste aller Sitzungen
	}

	public int createNewGame(IClient aClient) { // f�gt einen Spieler einer Sitzung hinzu
		MasterMindGame myGame = new MasterMindGame();// eine Sitzung
		myGame.addClient(aClient);
		myGame.setCreatingClient(aClient);
		mActiveGames.add(myGame); // f�gt Sitzung der Liste hinzu
		System.out.println("Game "+myGame.getGameID()+" created by "+aClient.getUsername());
		return myGame.getGameID();
	}

	@Override
	public boolean startGame(int aGameID) {
		for(IMasterMindGame vGame : mActiveGames) {
			if(vGame.getGameID() == aGameID) {
				return vGame.startGame();
			}
		}	
		return false;
	}

	public int[] checkNumbers(int aGameID, IClient aClient, int[] aGuessedDigits) {
		int[] vResult=new int[] {-1,-1};
		for(IMasterMindGame vGame : mActiveGames) {
			if(vGame.getGameID() == aGameID) {			
				if(vGame.getClients().contains(aClient) && vGame.isGameRunning()) {
					vResult=vGame.checkNumbers(aClient, aGuessedDigits);
				}
			}
		}	
		return vResult;
	}

	@Override
	public void deleteGame(int aGameID, IClient aCreatingClient) {
		IMasterMindGame vGame=null;
		Iterator<IMasterMindGame> vGameIterator=mActiveGames.iterator();
		//for each loop will cause concurrent modification exception when deleting
		for(; vGameIterator.hasNext();) {
			vGame=vGameIterator.next();
			if(vGame.getGameID() == aGameID) {
				if(vGame.getCreatingClient() == aCreatingClient){
					vGameIterator.remove();
				}
				else {
					throw new RuntimeException("Client not creator of the game!");
				}
			}
		}
	}

}
