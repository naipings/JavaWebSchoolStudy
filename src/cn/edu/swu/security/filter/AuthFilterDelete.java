package cn.edu.swu.security.filter;

import cn.edu.swu.common.style.AuthStatus;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthFilterDelete extends HttpFilter {

    public final static String Delete_SUCCESS = "Delete_SUCCESS";
    private String[] ignoreUrls = new String[]{};

    public void init(FilterConfig config) {
        String urls = config.getInitParameter("ignoreUrls");
        if ( ignoreUrls != null ) {
            this.ignoreUrls = urls.split(";"); //用“;”进行分割，因为我们在web.xml里面也是用分号分割的
        }
    }

    public void doFilter (HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        String uri = request.getRequestURI();
        for ( String url : ignoreUrls ) {
            if ( uri.endsWith(url) ) {
                chain.doFilter(request, response);
                return;
            }
        }

        AuthStatus status2 = (AuthStatus) session.getAttribute(Delete_SUCCESS);
        // 如果session里的标记为注册成功，就放行，访问下一个Filter
        if ( status2 != null && status2.equals(AuthStatus.Delete_SUCCESS) ) {
            chain.doFilter(request, response);
        } else { //注销失败
            response.sendRedirect("./delete.html");
        }

    }

}