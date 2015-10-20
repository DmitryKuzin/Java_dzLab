import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by kuzin on 10/7/2015.
 */
public class GetCookie {
    public Cookie getCookie(HttpServletRequest request,String name){
        Cookie c=null;
        Cookie[] cookies=request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("counterCookie")) {
                    c= cookie;
                }
            }
        }
        return c;
    }
}
