package es.unizar.sisinf.data.vo;

public class UsuarioVO {
	private String nickname;
	private String hashPasswd;
	private String email;

	public UsuarioVO (String nickname, String hashPasswd, String email) {
		this.nickname = nickname;
		this.hashPasswd = hashPasswd;
		this.email = email;
	}

	public String getNickname(){
		return this.nickname;
	}

	public String getPasswd(){
		return this.hashPasswd;
	}

	public String getEmail(){
		return this.email;
	}
}
