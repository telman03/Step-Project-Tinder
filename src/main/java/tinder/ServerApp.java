package tinder;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import tinder.Servlets.*;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8000);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(UsersServlet.class, "/users");
        handler.addServlet(LikedServlet.class, "/liked");
        handler.addServlet(MessageServlet.class, "/message/*");
        handler.addServlet(LoginServlet.class, "/login");
        handler.addServlet(StaticServlet.class, "/*");
        handler.addServlet(StaticServlet.class, "/message/css/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}