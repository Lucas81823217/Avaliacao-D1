package model;

public class Comentario implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	
	private int idComentario;
	private String Nome;
	private String Texto;
	private int idNoticia;
	public Comentario(int idComentario, String nome, String texto, int idNoticia) {
		super();
		this.idComentario = idComentario;
		Nome = nome;
		Texto = texto;
		this.idNoticia = idNoticia;
	}
	
	public Comentario(String nome, String texto, int idNoticia) {
		super();
		Nome = nome;
		Texto = texto;
		this.idNoticia = idNoticia;
	}
	
	public Comentario() {
		
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
}
