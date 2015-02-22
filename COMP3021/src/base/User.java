package base;

import java.util.ArrayList;
import java.util.Date;

public class User {
	private int id;
	private String userName;
	private String email;
	private ArrayList<Post>  listOfPost = new ArrayList<Post> ();
	
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
