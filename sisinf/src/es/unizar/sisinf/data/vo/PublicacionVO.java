package es.unizar.sisinf.data.vo;

public class PublicacionVO {
	private Integer id;
	private String title;
	private String content;
	private Boolean type;
	private String author;

	public PublicacionVO (Integer id, String title, String content, Boolean type, String author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.type = type;
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

	public boolean is_a_Post(){
		return this.type;
	}

	public String getAuthor(){
		return this.author;
	}
}
