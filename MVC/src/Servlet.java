import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuzin on 10/9/2015.
 */
@WebServlet(name="MyServlet", urlPatterns = "/test")
public class Servlet extends javax.servlet.http.HttpServlet {
    List<String> list;

    @Override
    public void init() throws ServletException {
        list=new ArrayList<>();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String param=request.getParameter("Name");

        if(param !=null && !param.isEmpty()) {
            list.add(param);
        }else{
            request.setAttribute("error","value cannot be empty");
        }
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("Names",list);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/Main.jsp");
        requestDispatcher.include(request,response);

    }
}
