package cn.edu.swu.servlet;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.OutputStream;

public class AuthCodeServlet extends HttpServlet {

    public final static String AUTH_CODE = "AUTH_CODE";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(110, 55, 4, 30);

        HttpSession session = request.getSession(true);
        session.setAttribute(AUTH_CODE, captcha.getCode());

        response.setContentType("image/jpeg");
        try ( OutputStream outputStream = response.getOutputStream() ) {
            captcha.write(outputStream);
        }

    }
}
