package com.example.treeproject.web;

import com.example.treeproject.dao.DaoFactory;
import com.example.treeproject.dao.TreeDAO;
import com.example.treeproject.web.model.Tree;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tree/add")
public class CreateIslandServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/createTreeForm.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String family = req.getParameter("family");
        String pictureUrl = req.getParameter("pictureUrl");
        boolean isEdible = Boolean.valueOf(req.getParameter("isEdible"));
        double latitude = Double.valueOf(req.getParameter("latitude"));
        double longitude = Double.valueOf(req.getParameter("longitude"));

        TreeDAO dao = DaoFactory.getTreeDAO();
        dao.create(new Tree(name, family, pictureUrl, isEdible, latitude, longitude));

        resp.sendRedirect(req.getContextPath() + HomeServlet.URL);

    }
}
