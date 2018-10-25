package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer  {
	
	private final ServerSocket vServer;
	public SocketServer(int aPort) throws IOException {
		vServer = new ServerSocket(aPort);
	}
	
	private void listen() {
		while(true) {
			Socket vSocket = null;
			try {
				vSocket = vServer.accept();
				doIO(vSocket);
			} 
			catch (IOException e){
				e.printStackTrace();
			} 
			finally {
				if (vSocket != null) {
					try {
						vSocket.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}
	}

	private void doIO(Socket aSocket) throws IOException {
		BufferedReader vInputReader = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
		PrintStream vOutputPrinter = new PrintStream(aSocket.getOutputStream());
		while(vInputReader.ready()) {
			String s = vInputReader.readLine();
			vOutputPrinter.println(s);
		}
	}
	
	public static void main(String[] args) throws IOException {
		SocketServer server = new SocketServer(3141);
		server.listen();
	}

}
