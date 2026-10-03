package com.portfolio;

import com.portfolio.servlet.AboutServlet;
import com.portfolio.servlet.CertificatesServlet;
import com.portfolio.servlet.HomeServlet;
import com.portfolio.servlet.ProjectsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Application entry point.
 * Boots an embedded Jetty server -- no external Tomcat install needed.
 * Run with: mvn compile exec:java
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8081"));
        Server server = new Server(port);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new HomeServlet()), "/");
        context.addServlet(new ServletHolder(new AboutServlet()), "/about");
        context.addServlet(new ServletHolder(new ProjectsServlet()), "/projects");
        context.addServlet(new ServletHolder(new CertificatesServlet()), "/certificates");

        server.start();
        System.out.println("Portfolio running at http://localhost:" + port);
        server.join();
    }
}
