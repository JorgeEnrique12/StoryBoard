import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SaveStoryBoard extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        String slides = request.getParameter("slides");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head></head>");
        out.println("<body>");
        out.println("hola");
        out.println(slides);
        out.println("</body>");
        out.println("</html>");

	}
}
