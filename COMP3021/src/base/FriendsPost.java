package base;

import java.util.Date;

public class FriendsPost extends Post {

	private User friend;
	
	public FriendsPost(Date date, String content,User user) {
		super(date, content);
		this.friend = user;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FriendsPost [friend=" + friend + "]";
	}
}
