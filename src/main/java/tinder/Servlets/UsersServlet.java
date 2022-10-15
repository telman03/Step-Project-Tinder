package tinder.Servlets;

import lombok.SneakyThrows;
import tinder.Entity.Like;
import tinder.Entity.User;
import tinder.FreeMarkerTemplate;
import tinder.Service.LikeService;
import tinder.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersServlet extends HttpServlet {
    UserService userService = new UserService();
    LikeService likeService = new LikeService();
    private static int counter = 0;

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs){
        List<User> users = userService.getAllUsers();
        if(counter == users.size()) rs.sendRedirect("/liked");

        User user = users.get(counter);
        FreeMarkerTemplate freeMarker = new FreeMarkerTemplate();
        Map<String, Object> mapper = new HashMap<>();
        mapper.put("image", user.getPhotoLink());
        mapper.put("name", user.getName());
        mapper.put("surname", user.getSurname());
        counter++;

        freeMarker.render("like-page.ftl", mapper, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String button = rq.getParameter("button");
        int thisUser = 1;
        Like like = new Like(thisUser, userService.getAllUsers().get(counter - 1).getId());
        if(button.equalsIgnoreCase("like") && !likeService.getAllLikes().contains(like)){
            likeService.insertLike(like);
        }
        else if(button.equalsIgnoreCase("dislike") && likeService.getAllLikes().contains(like)){
            likeService.removeLike(like);
        }
        rs.sendRedirect("/users");
    }
}
