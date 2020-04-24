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


@WebServlet("/Visualizar_Noticia.do")
public class Visualizar_Noticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Visualizar_Noticia() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		int IdNoticia = Integer.parseInt(request.getParameter("IdNoticia"));
		PrintWriter saida = response.getWriter();	
		
		NoticiaService ns = new NoticiaService();
		Noticia Notice = ns.consultar(IdNoticia);
		
		saida.print("<p>"+Notice.getTitulo()+"</p>");
		saida.print("<p>"+Notice.getDescricao()+"</p>");
		saida.print("<p>"+Notice.getTexto()+"</p>");
		
		ComentarioService cs = new ComentarioService();
		ArrayList<Comentario> listaComentario = new ArrayList <> ();
		listaComentario = cs.listar(IdNoticia);
		if (listaComentario.size()>0) {
		listaComentario.forEach(
		Comentario ->  
		{
			saida.print("<p>"+Comentario.getNome()+"</p>");
			saida.print("<p>"+Comentario.getTexto()+"</p>");
		}  );
		}
		saida.print("<form method='post' action='Visualizar_Noticia.do'>");
		saida.print("Nome: <input type='text' name='nome'>");
		saida.print("Comentario: <input type='text' name='Comentario'>");
		saida.print("<input type='hidden' name='IdNoticia' value='" + IdNoticia + "' >");
		saida.print("<input type='submit' value='Enviar'>");
		saida.print("</form>");
	
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	
	PrintWriter saida = response.getWriter();
	
	String nome = request.getParameter("nome");
	String comentario = request.getParameter("Comentario");
	int idNoticia = Integer.parseInt(request.getParameter("IdNoticia"));
	
	
	ComentarioService cs = new ComentarioService();
	Comentario c = new Comentario(nome, comentario, idNoticia);
	cs.cadastrar(c);
	saida.print("Comentado");
	}
	}
