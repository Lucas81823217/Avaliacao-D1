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


@WebServlet("/AlterarNoticia.do")
public class AlterarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AlterarNoticia() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		int IdNoticia = Integer.parseInt(request.getParameter("IdNoticia"));
		
		String descricao = request.getParameter("descricao");
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		
		
		NoticiaService ns = new NoticiaService();
		Noticia n = new Noticia(IdNoticia, descricao, titulo, texto);
		ns.alterar(n);
		saida.print("<p>Notícia alterada!</p>");
	}

	
	

}
