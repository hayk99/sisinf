package es.unizar.sisinf.data.vo;

public class PublicacionVO {
	private Integer id;
	private String title;
	private String content;
	private String author;

	public PublicacionVO (Integer id, String title, String content,String author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public Integer getId(){
		return this.id;
	}

	public String getTitle(){
		return this.title;
	}

	public String getContent(){
		return this.content;
	}

	public String getAuthor(){
		return this.author;
	}
}
