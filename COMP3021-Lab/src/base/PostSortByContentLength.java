package base;
import java.util.Comparator;

public class PostSortByContentLength implements Comparator<Post> {
	
	@Override
	public int compare (Post p1, Post p2){
		return(p1.getContent().compareTo(p2.getContent()));
	}
}
