package net.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
	private static int vistorCounter = 0;
	
	public static  int getVistorCounter() {
		return vistorCounter;
	}
	
	public static void incrementVistor(){
		vistorCounter++;
	}

	public static final int PORT = 3021;

	public static void main(String [] args) throws IOException{
		ServerSocket svrSocket = new ServerSocket(PORT); // run the server;
		 
        Socket clientSocket = null;
        while (true) {             
            // block until TCP connection is established
            clientSocket = svrSocket.accept();
            incrementVistor();
            // handle the rest by thread worker
            Runnable runnable = new ThreadHandler (clientSocket);
            Thread worker = new Thread(runnable);
            worker.start(); 
        }
		
	}

}
