package base;

import java.util.Date;

public class FriendsPost extends Post {

	private User friend;
	
	public FriendsPost(Date date, String content,User user) {
		super(date, content);
		this.friend = user;
	}

	@Override
	public String toString() {
		return "This is a friendpost for user " + friend.toString() +". "+ super.toString();
	}
}
