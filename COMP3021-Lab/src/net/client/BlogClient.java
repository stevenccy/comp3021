package net.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Target;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.imageio.IIOException;

public class BlogClient {

	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String [] args)  {
		Socket target = null;
		try{
			target = new Socket(IP,PORT);
			
			DataInputStream input = new DataInputStream( target.getInputStream());
			PrintWriter writer = new PrintWriter (target.getOutputStream());
			Scanner sc = new Scanner(System.in);
			String temp = sc.next();
			if (temp.equalsIgnoreCase("quit")){
				writer.println("quit");
				writer.flush();
			}
			writer.println(temp);
			writer.flush();
			System.out.println(input.readLine());
			writer.close();
			sc.close();
		}
		
		catch(UnknownHostException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(target != null)
					target.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}	
	}
}
