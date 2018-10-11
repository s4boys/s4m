package client;

import java.util.Scanner;

import server.MasterMindServer;

public class Client implements IClient {

	@Override
	public boolean isReady() {
		return true;
//		Scanner sc = new Scanner(System.in);
//		String input = sc.next();
//		System.out.println("Ready? y/n");
//		if (input == "y") {
//			return true;
//		} else {
//			return false;
//		}
	}

	@Override
	public String getUsername() {
		return "User1";
//		Scanner sc = new Scanner(System.in);
//		String input = sc.next();
//		System.out.println("Username:");
//		return input;
	}

	@Override
	public void playGame() {
		System.out.println("Round starts");
	}

	@Override
	public void endGame(String message) {
		System.out.println(message);
	}
	
	public int[] run() {
		System.out.println("entering run");
		Scanner sc = new Scanner(System.in);
		int inputs[] = new int [4];
		for(int i = 0; i < 4;i++) {
			System.out.println("loopiteration: " + i);
			inputs[i] = sc.nextInt();
		}
		return inputs;

		
	}


	public static void main(String[] args) {
		//locally: create a server
		Client client = new Client();
		int result[] = new int[2];
		MasterMindServer server = new MasterMindServer();
		int id = server.createNewGame(client);
		while(true) {
			if (server.startGame(id)) {
				result = server.checkNumbers(id, client, client.run());
			}		
			if (result[0]==4) {
				break;
			}
		}
		
		//while the user wishes
			//create a game
			//start the game
		//ask for a possible next game
	}

}
