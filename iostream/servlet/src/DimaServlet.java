import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kuzin on 10/5/2015.
 */
public class DimaServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>My Web app</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div align=\"center\">\n" +
                "    <h1>\n" +
                "        My own siteee!!\n" +
                "    </h1>\n" +
                "</div>\n" +
                "<form method=\"post\" action=\"/webmodule/dima\">\n" +
                "        <input type=\"text\" name=\"plusOneParam\">\n" +
                "        <input type=\"submit\" name=\"submit\" value=\"do +1\">\n" +
                "    </form>"+
                "</body>\n" +
                "</html>");
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("plusOneParam");
        Integer val;
        try{
            val=new Integer(value);
            val++;
            value=val.toString();

        }catch (NumberFormatException e){
            value="This is not a number!";
        }
        resp.setContentType("text/html");
        resp.getWriter().print(value);
        resp.getWriter().close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
