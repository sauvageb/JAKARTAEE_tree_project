package com.example.treeproject.dao;

import com.example.treeproject.web.model.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryTreeDAO implements TreeDAO {

    private static List<Tree> treeList = new ArrayList<Tree>() {{
        add(new Tree(1L, "Frêne", "Oléacées", "https://www.littlecitizensforclimate.org/wp-content/uploads/2020/05/13448104.jpg", false, 51.0000002, -109));
        add(new Tree(2L, "Bouleau", "Bétulacées", "https://teteamodeler.ouest-france.fr/media/cache/thumb_800/assets/featured/bouleau-explication-tte-modeler-du-mot-bouleau.png", false, 49.1956806, 5.9248356));
        add(new Tree(3L, "Châtaignier", "Fagacées", "https://www.sabaton.fr/PageID/1202/chataignier-ardeche.jpg", true, 36.5748441, 139.2394179));
    }};

    @Override
    public List<Tree> findAll() {
        return treeList;
    }

    @Override
    public boolean create(Tree tree) {
        tree.setId(treeList.size() + 1L);
        return treeList.add(tree);
    }

    @Override
    public boolean delete(long id) {
        if (treeList.stream().filter(t -> t.getId() == id).findFirst().isPresent()) {
            treeList = treeList.stream().filter(t -> t.getId() != id).collect(Collectors.toList());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean edit(long id, Tree tree) {
        treeList = treeList.stream()
                .map(t -> {
                    if (t.getId() == id) {
                        t.setName(tree.getName());
                        t.setFamily(tree.getFamily());
                        t.setPictureUrl(tree.getPictureUrl());
                        t.setEdible(tree.isEdible());
                    }
                    return t;
                })
                .collect(Collectors.toList());

        return true;
    }

    @Override
    public Optional<Tree> findById(long id) {
        return treeList.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }

}
