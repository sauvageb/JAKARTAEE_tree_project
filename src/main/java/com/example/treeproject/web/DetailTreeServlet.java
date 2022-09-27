package com.example.treeproject.web;

import com.example.treeproject.dao.DaoFactory;
import com.example.treeproject.web.model.Tree;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(DetailTreeServlet.URL)
public class DetailTreeServlet extends HttpServlet {

    public static final String URL = "/tree/details";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        long id = Long.parseLong(idStr);
        Optional<Tree> treeOptional = DaoFactory.getTreeDAO().findById(id);
        req.setAttribute("tree", treeOptional.get());
        req.getRequestDispatcher("/WEB-INF/detailTree.jsp").forward(req, resp);
    }
}
