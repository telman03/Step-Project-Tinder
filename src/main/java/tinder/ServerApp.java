package tinder;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import tinder.Servlets.LikedServlet;
import tinder.Servlets.UsersServlet;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new UsersServlet()), "/users");
        handler.addServlet(new ServletHolder(new LikedServlet()), "/liked");


        server.setHandler(handler);
        server.start();
        server.join();
    }
}
