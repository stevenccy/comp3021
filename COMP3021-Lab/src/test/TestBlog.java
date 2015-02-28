package test;

import java.io.*;
import java.util.Date;
import base.*;
import blog.*;

public class TestBlog {
	public String getInput(){
		String line = "";
		System.out.print("Enter the prompt");
		try{
			BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
			line = br.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return line;
	}
	
	public static void main (String[] args){
		TestBlog testBlog = new TestBlog();
		User user = new User (1,"COMP3021","COMP3021@cse.ust.hk");
		Blog myBlog = new Blog (user);
		String prompt = null;
	
		while ( !(prompt = testBlog.getInput()).equals("exit")){
			//String prompt has already stores the input, now deal with it
			
			if(prompt.startsWith("list")){
				myBlog.list();
			}
			else if ( prompt.startsWith("post")){
				//prompt.replaceFirst("post", "");
				prompt = prompt.substring(5);
				Post post = new Post (new Date(),prompt);
				myBlog.post(post);
				System.out.println(post);
			}
			else if ( prompt.startsWith("delete")){
				prompt = prompt.substring(6);
				prompt = prompt.replace(" ", "");
				int index = Integer.parseInt(prompt);
				myBlog.delete(index);
			}
		}
	}

}
