package blog;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import base.*;

public class Blog implements Serializable {
	private User user;
	private ArrayList<Post>  allPosts ;

	public Blog (User user){
		this.user = user;
		allPosts = new ArrayList<Post> ();

	}

	@Override
	public String toString() {

		String tobeReturned = "";
		int index = 1;
		tobeReturned= tobeReturned + "Current post(s): "+'\n';
		for (Post post : allPosts){
			tobeReturned= tobeReturned + "Post[" + index + "]: " +'\n';
			tobeReturned= tobeReturned + post.toString() + '\n';
			index++;
		}
		return tobeReturned;
	}



	public ArrayList<Post> getListOfPost() {
		return allPosts;
	}

	public void setPosts(ArrayList<Post> listOfPost) {
		this.allPosts = listOfPost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((allPosts == null) ? 0 : allPosts.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (allPosts == null) {
			if (other.allPosts != null)
				return false;
		} else if (!allPosts.equals(other.allPosts))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public void list (){
		System.out.print(this.toString());
	}


	public void post (Post post){
		this.allPosts.add(post);
		System.out.println("Successfully added a new post: ");

	}

	public void delete (int index){
		index--;
		if (index <0 || index > allPosts.size()){
			System.out.println("Error! The index are illegal!");
			return;
		}
		else
		{
			allPosts.remove(index);
		}
	}

	public void search (int month, String someone){

		if (month<1 || month>12){
			return;
		}

		Calendar cal = Calendar.getInstance();

		// search from all posts
		for (Post p : allPosts){
			//get the current post's month ( note that Calendar.Month starts with 0 not 1
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);

			if ((month-1) == postMonth){
				if (p.getContent().contains('@'+someone)){
					System.out.println(p.toString());
					return;
				}
			}
		}
	}

	public void save (String filepath) {
		try{
			ObjectOutputStream oos = new ObjectOutputStream (new BufferedOutputStream ( new FileOutputStream (filepath)));

			oos.writeObject (this);
			//oos.writeObject(user);
			//oos.writeObject(allPosts);
			oos.flush();
			oos.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void load (String filepath)  {
		try{
			ObjectInputStream ois = new ObjectInputStream (new BufferedInputStream ( new FileInputStream (filepath)));
			
			try{
				Blog blog =  (Blog) ois.readObject();
				this.user = blog.user;
				this.allPosts= blog.allPosts;
			}
			catch (ClassNotFoundException e){
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e){
			System.out.println("Wait! There is something wrong. I cannot find the file..");
		}
		catch (IOException e){
			System.out.println("Wait! There is something wrong. I cannot find the file..");
		}
		
	}

}
