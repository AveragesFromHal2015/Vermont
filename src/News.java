import java.util.Date;


public class News {
	
	private String id;
	private String title;
	private String time;
	private String detail;
	
	public News(String id,String title,String time,String detail) {
		setId(id);
		setTitle(title);
		setTime(time);
		setDetail(detail);		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	
}
