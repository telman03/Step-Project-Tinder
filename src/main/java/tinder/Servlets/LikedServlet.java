package tinder.Servlets;

import lombok.SneakyThrows;

import tinder.Service.LikeService;
import tinder.Entity.User;
import tinder.FreeMarkerTemplate;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LikedServlet extends HttpServlet {
    LikeService likeService = new LikeService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs){
        int loggedUser = 1;
        FreeMarkerTemplate freeMarker = new FreeMarkerTemplate();
        Map<String, Object> mapper = new HashMap<>();
        List<User> users = likeService.getAllLikedUsers(loggedUser);

        mapper.put("users", users);
        freeMarker.render("people-list.ftl", mapper, rs);
    }
}