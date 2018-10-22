package server;


import client.IClient;

public interface IMasterMindServer{
	
	//Maximum digit used in generated secret numbers
	public static int MAX_DIGIT = 9;   
	//number of digits to guess
	public static int BOARD_WIDTH = 4; 
	
	/**
	 * creates a new game on the server. The given client is memorized as the game initiator and automatically joins the game.
	 * @param the client to initially join the new game
	 * @return the ID of the newly created game
	 */
	public int createNewGame(IClient aClient);
	
	/**
	 * starts the game. from that point, joining the game is impossible.
	 * @param gameID the identifier of the game.
	 * @return flag indicating the start success
	 */
	public boolean startGame(int gameID);
	
	/**
	 * checks the numbers provided by a client against the hidden solution (sequence of digits)
	 * @param aClient the client
	 * @param aGuessedDigits the digits guessed by the client in order of array indices
	 * @return the number of exact matches and the number of digits appearing
	 *         anywhere in the solution as an integer-array of length 2
	 */
	public int[] checkNumbers(int gameID, IClient aClient, int[] aGuessedDigits);
	
	/**
	 * deletes a game from the server. must be issued by the creating client if the game is deleted before its end.
	 * @param gameID the identifier of the game
	 * @param aCreatingClient the client having created the game
	 */
	public void deleteGame(int gameID, IClient aCreatingClient); 
	
}
