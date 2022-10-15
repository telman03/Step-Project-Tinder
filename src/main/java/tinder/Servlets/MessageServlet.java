package tinder.Servlets;

import javax.servlet.http.HttpServlet;

import lombok.SneakyThrows;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tinder.Entity.Message;
import tinder.Entity.User;

import lombok.SneakyThrows;
import tinder.FreeMarkerTemplate;
import tinder.Service.LoginService;
import tinder.Service.MessageService;
import tinder.Service.UserService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MessageServlet extends HttpServlet {
    MessageService messageService = new MessageService();
    UserService userService = new UserService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        int loggedUser = 1;
        HashMap<String, Object> data = new HashMap<>();
        int receiverId = Integer.parseInt(rq.getPathInfo().substring(1));
        FreeMarkerTemplate freeMarker = new FreeMarkerTemplate();
        List<Message> messages = messageService.getAllMessages(loggedUser, receiverId);
        data.put("messages", messages);
        data.put("sender", loggedUser);
        data.put("receiver", userService.getUser(receiverId));
        freeMarker.render("chat.ftl", data, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int loggedUser = 1;
        int receiverId = Integer.parseInt(rq.getPathInfo().substring(1));
        String message = rq.getParameter("message");
        if(!message.isEmpty()) messageService.insertMessage(new Message(loggedUser, receiverId, message));
        rs.sendRedirect("/message/" + receiverId);
    }
}