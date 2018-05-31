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
import java.io.FileOutputStream;  
import java.io.OutputStream;  
import java.io.InputStream;  
import java.io.File;
import javax.servlet.http.HttpSession;


public class UpdateXMLTexto extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String tipo = (String)session.getAttribute("tipo");
		String nombre = (String)session.getAttribute("nombre_story");
		String ruta = request.getSession().getServletContext().getRealPath("/Usuarios/"+user+"/base.xml");
		String texto = request.getParameter("texto");
		XMLtexto tex = new XMLtexto(ruta, nombre, texto, tipo);
		try {
			tex.start();
			tex.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("./MainStoryBoards");
    }
}