package com.example.treeproject.web;

import com.example.treeproject.dao.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete-tree")
public class DeleteTreeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idTree");

        long id = Long.parseLong(idStr);
        DaoFactory.getTreeDAO().delete(id);
        resp.sendRedirect(req.getContextPath() + HomeServlet.URL);
    }
}
