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
import java.util.Optional;

@WebServlet("/tree/edit")
public class UpdateIslandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");

        TreeDAO dao = DaoFactory.getTreeDAO();
        Optional<Tree> treeOptional = dao.findById(Long.valueOf(idStr));
        if (treeOptional.isPresent()) {
            request.setAttribute("tree", treeOptional.get());
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateTreeForm.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + HomeServlet.URL);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String family = req.getParameter("family");
        String pictureUrl = req.getParameter("pictureUrl");
        boolean isEdible = Boolean.valueOf(req.getParameter("isEdible"));
        double latitude = Double.valueOf(req.getParameter("latitude"));
        double longitude = Double.valueOf(req.getParameter("longitude"));

        TreeDAO dao = DaoFactory.getTreeDAO();
        dao.edit(Long.valueOf(idStr), new Tree(name, family, pictureUrl, isEdible, latitude, longitude));

        resp.sendRedirect(req.getContextPath() + HomeServlet.URL);
    }
}
