import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Gataullin Kamil
 * 18.10.2014 18:39:33
 */
public class TestServlet extends HttpServlet {
    private int fieldCounter;

    @Override
    public void init() throws ServletException {
        fieldCounter = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "TestGet";
        }
        if (action.equals("TestGet")) {
            testGet(response);
        } else if (action.equals("TestField")) {
            testField(response);
        } else if (action.equals("TestInitParam")) {
            testInitParam(response);
        } else if (action.equals("TestSession")) {
            testSession(request, response);
        } else if (action.equals("TestForward")) {
            testForward(request, response);
        } else if (action.equals("TestRedirect")) {
            testRedirect(request, response);
        } else if (action.equals("TestCookie")) {
            testCookie(request, response);
        }
    }

    private void testRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("http://yandex.ru");
    }

    private void testForward(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("forward.html");
        requestDispatcher.forward(request, response);
    }

    private void testSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Integer sessionCounter = (Integer) session.getAttribute("sessionCounter");
        if (sessionCounter == null) {
            sessionCounter = 0;
        }
        sessionCounter++;
        session.setAttribute("sessionCounter", sessionCounter);

        response.setContentType("text/html");
        response.getWriter().print(sessionCounter);
        response.getWriter().close();
    }

    private void testInitParam(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().print(getInitParameter("MyInitParam"));
        response.getWriter().close();
    }

    private void testField(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().print(++fieldCounter);
        response.getWriter().close();
    }

    private void testGet(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().print("GET");
        response.getWriter().close();
    }

    private void testCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int counter = 0;
        Cookie counterCookie = new GetCookie().getCookie(request,"counterCookie");
        //Cookie[] cookies = request.getCookies();


//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("counterCookie")) {
//                    counterCookie = cookie;
//                    break;
//                }
//            }
//        }
        if (counterCookie == null) {
            counterCookie = new Cookie("counterCookie", "" + counter);
            counterCookie.setMaxAge(60 * 60 * 24 * 14);
        } else {
            counter = Integer.parseInt(counterCookie.getValue());
            counter++;
            counterCookie.setValue("" + counter);
            counterCookie.setMaxAge(60 * 60 * 24 * 14);
        }

        response.addCookie(counterCookie);

        response.setContentType("text/html");
        response.getWriter().print(counter);
        response.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("MyRequestParam");
        response.setContentType("text/html");
        response.getWriter().print(value);
        response.getWriter().close();
    }


}