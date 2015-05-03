package net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadHandler implements Runnable{


	private Socket clientSocket;

	public ThreadHandler(Socket soc) {
		clientSocket = soc;
	}
	
	@Override
	public void run() {

		try{
			BufferedReader input = new BufferedReader( new InputStreamReader( clientSocket.getInputStream()));
			PrintWriter writer = new PrintWriter (clientSocket.getOutputStream());
			
			String result = input.readLine();
			if (result.equalsIgnoreCase("vistor") ){
				writer.println("You're the "+ MultiThreadServer.getVistorCounter() + "vistor today");
				writer.flush();
			}
			else if (result.equalsIgnoreCase("quit")){
				return;
			}
			else {
				writer.println("echo: "+result);
				writer.flush();
			}			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		/*
		finally{
			try{
				if (clientSocket != null){
					clientSocket.close();
					input.close();
					writer.close();
				}
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		*/
	}



}
