package service;

import java.util.ArrayList;

import dao.Comentariodao;
import model.Comentario;

public class ComentarioService {

private Comentariodao comentariodao;
	
	public ComentarioService() {
		this.comentariodao = new Comentariodao();
	}
	
	public void cadastrar(Comentario produto) {
		this.comentariodao.cadastrar(produto);
	}
	
		public ArrayList<Comentario> listar(int IdNoticia) {
		return this.comentariodao.listarComentario(IdNoticia);
}}	

