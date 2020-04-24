package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;


@WebServlet("/Cadastrar.do")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Cadastrar() {
        super();
      
    }
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		String descricao = request.getParameter("descricao");
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		
		
		NoticiaService ns = new NoticiaService();
		Noticia n = new Noticia(descricao, titulo, texto);
		ns.cadastrar(n);
		saida.print("<p>Notícia cadastrada!</p>");
	}

}
