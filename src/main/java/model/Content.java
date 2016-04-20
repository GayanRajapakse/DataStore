package model;

public class Content {

	private long time;
	private String title;
	private String content;

	public Content(long time, String title, String content) {
		this.time = time;
		this.title = title;
		this.content = content;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
