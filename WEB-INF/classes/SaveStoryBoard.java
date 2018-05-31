import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveStoryBoard extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        String slides = request.getParameter("slides");
        StringTokenizer tokens=new StringTokenizer(slides, "?");
        List<String> slidestosave = new ArrayList();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head></head>");
        out.println("<body>");
        int i = 0;
        while(tokens.hasMoreTokens()){
            String cadena = tokens.nextToken();
            if (i!=0){
                cadena = cadena.substring(1);
            }
            slidestosave.add(cadena);
            i++;
        }
        for ( i = 0; i < slidestosave.size(); i++) {
            out.println(slidestosave.get(i)+"<br/><br/><br/>");
        }
        out.println("</body>");
        out.println("</html>");

	}
}
