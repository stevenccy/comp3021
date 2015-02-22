package test;
import java.util.Date;

import base.User;
import base.FriendsPost;

public class TestObject {
	User user = new User (1,"COMP3021","COMP3021@cse.ust.hk");
	Date date = new Date();
	String content = "This is my first post";
	FriendsPost postFromFriend = new FriendsPost ( date, content, user);
	

}
