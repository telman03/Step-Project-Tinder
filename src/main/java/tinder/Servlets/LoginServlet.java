package tinder.Servlets;

import lombok.SneakyThrows;
import tinder.Entity.User;
import tinder.FreeMarkerTemplate;
import tinder.Service.LoginService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs){
        FreeMarkerTemplate freeMarker = new FreeMarkerTemplate();
        freeMarker.render("login.ftl", new HashMap<>(), rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        String mail = rq.getParameter("mail");
        String password = rq.getParameter("password");
        User user = loginService.getUser(mail, password);
        if(user != null) rs.sendRedirect("/users");
        else rs.sendRedirect("/login");
    }

}

