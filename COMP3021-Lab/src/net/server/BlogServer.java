package net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BlogServer {
	public static final int PORT = 3021;

	
	public static void main(String [] args){
		ServerSocket svrSocket= null;
		Socket clientSocket= null;
		BufferedReader input= null;
		PrintWriter writer = null;
		try{
			svrSocket = new ServerSocket (PORT);
			clientSocket = svrSocket.accept();
			input = new BufferedReader( new InputStreamReader( clientSocket.getInputStream()));
			writer = new PrintWriter (clientSocket.getOutputStream());
			
			String result = input.readLine();
			System.out.println(result);
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
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
		
		
	}
}
