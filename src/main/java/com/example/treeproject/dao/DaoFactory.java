package com.example.treeproject.dao;

public final class DaoFactory {

    public static TreeDAO getTreeDAO(){
        return new MemoryTreeDAO();
    }
}
