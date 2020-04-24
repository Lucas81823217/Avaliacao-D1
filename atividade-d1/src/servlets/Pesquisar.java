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


@WebServlet("/Pesquisar.do")
public class Pesquisar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Pesquisar() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
									
				int IdNoticia = Integer.parseInt(request.getParameter("IdNoticia"));
				NoticiaService ns = new NoticiaService();
				Noticia N = ns.consultar(IdNoticia);
				saida.print("<p>"+N.getTitulo()+"</p>");
				saida.print("<p>"+N.getDescricao()+"</p>");
				saida.print("<p>"+N.getTexto()+"</p>");
	}

}
