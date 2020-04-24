package service;

import java.util.ArrayList;

import dao.Noticiadao;
import model.Noticia;

public class NoticiaService {

private Noticiadao noticiadao;
	
	public NoticiaService() {
		this.noticiadao = new Noticiadao();
	}
	
	public void cadastrar(Noticia produto) {
		this.noticiadao.cadastrar(produto);
	}
	
	public void alterar(Noticia produto) {
		this.noticiadao.alterar(produto);
	}
	
	public void excluir(Noticia produto) {
		this.noticiadao.excluir(produto);
	}
	
	public Noticia consultar(int codigo) {
		return this.noticiadao.consultar(codigo);
	}
	
	public ArrayList<Noticia> listar() {
		return this.noticiadao.listarNoticia ();
}}
