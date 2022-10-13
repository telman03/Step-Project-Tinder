package tinder.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// http://localhost:8080/liked
public class LikedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String fileName = getClass().getClassLoader().getResource("like-page.html").getFile();

        List<String> lines = Files.readAllLines(Path.of(fileName.substring(1)));
        try(PrintWriter w = rs.getWriter()){
            for (String line: lines){
                w.println(line);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try (PrintWriter w = rs.getWriter()){
            String like = rq.getParameter("like");
            String dislike = rq.getParameter("dislike");
            w.printf("You %s %s this people", like, dislike);
        }
    }
}
