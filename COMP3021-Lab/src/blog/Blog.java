package blog;

import java.util.ArrayList;

import base.*;

public class Blog {
	private User user;
	private ArrayList<Post>  listOfPost ;

	public Blog (User user){
		this.user = user;
		listOfPost = new ArrayList<Post> ();
		
	}
	
	public void post (Post post){
		this.listOfPost.add(post);
		System.out.println("Successfully added a new post: ");
		
	}
	
	public void delete (int index){
		index--;
		if (index <0 || index > listOfPost.size()){
			System.out.println("Error! The index are illegal!");
			return;
		}
		else
		{
			listOfPost.remove(index);
		}
	}
	
	@Override
	public String toString() {
		return "Blog User: " + user + ", List of Post: " + listOfPost + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((listOfPost == null) ? 0 : listOfPost.hashCode());
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
		if (listOfPost == null) {
			if (other.listOfPost != null)
				return false;
		} else if (!listOfPost.equals(other.listOfPost))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public void list (){
		int index = 1;
		System.out.println("Current post(s): ");
		for (Post post : listOfPost){
			System.out.println("Post[" + index + "]: " );
			System.out.println(post.toString());
			System.out.println("");
			index++;
		}
	}
	
	
}
