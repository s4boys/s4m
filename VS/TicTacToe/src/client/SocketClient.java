package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) {
		Socket vSocket = null;
		
		try {
			vSocket = new Socket("localhost", 3141);
			
			OutputStream vOutput = vSocket.getOutputStream();
			PrintStream vOutputPrinter = new PrintStream(vOutput, true);
			vOutputPrinter.println("Hello World!");
			
			InputStream vInput = vSocket.getInputStream();
			//System.out.println("Bytes to retrieve: " + vInput.available());
			BufferedReader vInputReader = new BufferedReader(new InputStreamReader(vInput));
			
			while (true) {
				while (vInputReader.ready()) {
					System.out.println("Bytes to retrieve: " + vInput.available());
					System.out.println(vInputReader.readLine());

				}
			}
		} catch (UnknownHostException e) {
			System.out.println("Error: Unknown Host");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: IO");
			e.printStackTrace();
		} finally {
			if (vSocket != null)
				try {
					vSocket.close();
					System.out.println("Socket closed");
				} catch (Exception e2) {
					System.out.println("Error: Socket not closable");
					e2.printStackTrace();
				}
		}
	}
	
	
}
