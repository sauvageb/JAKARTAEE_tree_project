package com.example.treeproject.dao;

import com.example.treeproject.web.model.Tree;

import java.util.List;
import java.util.Optional;

public interface TreeDAO {
    List<Tree> findAll();

    boolean create(Tree tree);

    boolean delete(long id);

    boolean edit(long id, Tree tree);

    Optional<Tree> findById(long id);
}
