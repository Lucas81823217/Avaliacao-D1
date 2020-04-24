package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Noticia;

public class Noticiadao {

private Connection conexao;
	
	public Noticiadao() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Noticia noticia) {
			
		String inserir = "INSERT INTO noticia "
				+ " (descricao, titulo, texto) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
		conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getTexto());
			
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Noticia noticia) {
		
		String inserir = "UPDATE noticia "
				+ "SET descricao = ?, titulo = ?, texto = ? "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getTexto());
			pst.setInt(4, noticia.getIdNoticia());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Noticia noticia) {
		
		String inserir = "DELETE FROM noticia "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, noticia.getIdNoticia());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticia.");
			ex.printStackTrace();
		}
	}
	
	public Noticia consultar(int matricula) {
		
		String inserir = "SELECT * FROM noticia "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, matricula);
			ResultSet resultado = pst.executeQuery();
			
			Noticia p = new Noticia();
			if (resultado.next()) {
				p.setIdNoticia(resultado.getInt("id"));
				p.setDescricao(resultado.getString("descricao"));
				p.setTitulo(resultado.getString("titulo"));
				p.setTexto(resultado.getString("texto"));
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Noticia> listarNoticia() {
		
		String inserir = "SELECT * FROM noticia";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Noticia> lista = new ArrayList<>();
			while (resultado.next()) {
				Noticia p = new Noticia();
				p.setIdNoticia(resultado.getInt("id"));
				p.setDescricao(resultado.getString("descricao"));
				p.setTitulo(resultado.getString("titulo"));
				p.setTexto(resultado.getString("texto"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
		}
	}
}
