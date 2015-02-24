package base;

import java.util.ArrayList;
import java.util.Date;

public class User {
	private int id;
	private String userName;
	private String email;
	private ArrayList<Post>  listOfPost = new ArrayList<Post> ();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(int id, String userName, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;		
	}
	
	public void DeletePost(String content){
		for (Post post: listOfPost){
			if( content.equalsIgnoreCase(post.getContent())){
				listOfPost.remove(post);
			}
		}
	}
	
	public void ListPost (){
		for (Post post : listOfPost){
			post.toString();
		}
	}
	
}
