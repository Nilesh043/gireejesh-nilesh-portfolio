package com.portfolio.servlet;

import com.portfolio.components.Carousel;
import com.portfolio.components.Hero;
import com.portfolio.components.IntroVideoModal;
import com.portfolio.components.Layout;
import com.portfolio.components.Navbar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Root servlet for "/" -- assembles the home page from its components
 * (Navbar, Hero, Carousel).
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String navbar = new Navbar().render();
        String heroSection = new Hero().render();
        String cardsSection = new Carousel().render();
        String introModal = new IntroVideoModal().render();

        String body = navbar + heroSection + cardsSection + introModal;
        String page = Layout.wrap("Portfolio", body);

        try (PrintWriter out = resp.getWriter()) {
            out.write(page);
        }
    }
}
