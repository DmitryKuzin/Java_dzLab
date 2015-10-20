import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Gataullin Kamil
 * 01.10.2015 23:44
 */
public class SimpleServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Test Java Web Application</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div align=\"center\">\n" +
                "    <h1>\n" +
                "        Test Java Web Application Simple Servlet\n" +
                "    </h1>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        response.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("POST request");
        response.getWriter().close();
    }

    @Override
    public void destroy() {
    }
}
