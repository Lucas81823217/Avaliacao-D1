package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;


@WebServlet("/Listar_Noticias.do")
public class Listar_Noticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Listar_Noticias() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		
		NoticiaService cs = new NoticiaService();
		ArrayList<Noticia> lista = new ArrayList <> ();
		lista = cs.listar();
		lista.forEach(
		Noticia ->  
		{
			saida.print("<a href='Visualizar_Noticia.do?IdNoticia=" + Noticia.getIdNoticia() + "'>" + Noticia.getTitulo() + "</a>");
			saida.print("<p>"+Noticia.getDescricao()+"</p>");
			saida.print("<p>"+Noticia.getTexto()+"</p>");
		}  );
		
	}
	}


