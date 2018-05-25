import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.*;
import java.util.List;
import org.jdom.output.XMLOutputter;
import java.io.PrintWriter;
import java.io.FileWriter;
import org.jdom.input.SAXBuilder;
import org.jdom.input.DOMBuilder;
import java.io.FileInputStream;  
import java.io.File;

public class Registro extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		request.setCharacterEncoding("UTF-8");
		String ruta = request.getSession().getServletContext().getRealPath("/xml/Usuarios.xml");
		XML handler = new XML(ruta,request.getParameter("nombre"),request.getParameter("correo"),request.getParameter("user"),request.getParameter("contrasena1"),request.getParameter("tipo"));
		handler.start();
		response.sendRedirect("./AltasBajasCambios");
	}
}
