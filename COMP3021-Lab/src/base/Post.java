/**
 * This is COMP3021 Lab1
 * 
 */

package base;
import java.util.Date;

public class Post {
	private Date date;
	private String content;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Post(Date date, String content) {
		super();
		this.date = date;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Post date is " + date + ", content is " + content + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		
		Post other = (Post) obj;
		
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		
		return true;
	}
	
	public boolean contains (String keyword){
		if (content.contains(keyword)){
			return true;
		}
		else
			return false;
	}
	
}
