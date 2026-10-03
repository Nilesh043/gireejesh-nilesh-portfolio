package com.portfolio.servlet;

import com.portfolio.components.Certificates;
import com.portfolio.components.Layout;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CertificatesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String body = new Certificates().render();
        String page = Layout.wrap("Certifications & Achievements | Portfolio", body);

        try (PrintWriter out = resp.getWriter()) {
            out.write(page);
        }
    }
}
