package es.unizar.sisinf.data.vo;

public class ComentarioVO {
	private String user;
	private Integer publiId;
	private String content;

	public ComentarioVO (String user, Integer publiId, String content) {
		this.user = user;
		this.publiId = publiId;
		this.content = content;
	}

	public String getUser(){
		return this.user;
	}

	public Integer getPublicationId(){
		return this.publiId;
	}

	public String getContent(){
		return this.content;
	}
}
