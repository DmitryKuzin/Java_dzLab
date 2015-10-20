import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Лия on 08.10.2015.
 */
@WebServlet(name = "Liya", urlPatterns = "/test") //конфиг
public class ServletLiya extends javax.servlet.http.HttpServlet {

    List<String> list;

    @Override
    public void init() throws ServletException {
        list = new ArrayList<String>();
        super.init();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String req = request.getParameter("Name");

        list.remove(request.getAttribute("delete"));
        if (req != null && !req.equals("")){
            list.add(req);
        }else{
            request.setAttribute("Error", "Value can't be empty, stupid!");
        }

        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/main.jsp"); //сервлет коннект к jsp
        requestDispatcher.include(request, response);
    }
}
