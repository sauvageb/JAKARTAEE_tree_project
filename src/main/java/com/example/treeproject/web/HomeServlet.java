package com.example.treeproject.web;

import com.example.treeproject.dao.DaoFactory;
import com.example.treeproject.web.model.Tree;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(HomeServlet.URL)
public class HomeServlet extends HttpServlet {

    public static final String URL = "/tree-list";
    private static final String JSP_PATH = "/WEB-INF/treelist.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tree> treeList = DaoFactory.getTreeDAO().findAll();
        req.setAttribute("treeList", treeList);

        req.setAttribute("isMenu", true);
        req.getRequestDispatcher(JSP_PATH).forward(req, resp);
    }
}
