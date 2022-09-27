package com.example.treeproject.api;

import com.example.treeproject.api.dto.CreateUpdateTree;
import com.example.treeproject.api.dto.TreeDTO;
import com.example.treeproject.dao.DaoFactory;
import com.example.treeproject.web.model.Tree;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/tree")
public class TreeController {

    // GET /api/tree -> renvoie tous les arbres de votre liste
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTree() {
        List<Tree> treeList = DaoFactory.getTreeDAO().findAll();
        List<TreeDTO> treeDTOS = treeList.stream().map(t -> t.toDTO()).collect(Collectors.toList());
        return Response.ok(treeDTOS).build();
    }

    // GET /api/tree/12 -> renvoie l'arbre ayant pour identifiant 12
    @GET
    @Path("/{treeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTreeById(@PathParam("treeId") long idParam) {
        List<Tree> treeList = DaoFactory.getTreeDAO().findAll();
        Optional<Tree> optionalTree = treeList.stream().filter(tree -> tree.getId() == idParam).findFirst();

        System.out.println(idParam);
        if (optionalTree.isPresent()) {
            Tree foundTree = optionalTree.get();
            TreeDTO treeDTO = foundTree.toDTO();
            return Response.ok(treeDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    // POST /api/tree/ -> ajoute un arbre dans la liste
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTree(CreateUpdateTree createDTO, @Context UriInfo uriInfo) {
        Tree createdTree = createDTO.toTree();

        List<Tree> treeList = DaoFactory.getTreeDAO().findAll();
        treeList.add(createdTree);

        URI location = uriInfo
                .getRequestUriBuilder()
                .path(String.valueOf(createdTree.getId()))
                .build();

        return Response.created(location).entity(createdTree.toDTO()).build();
    }


    // PUT /api/tree/8 -> met a jour l'arbre ayant pour identifiant 8
    @PUT
    @Path("/{treeId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTree(@PathParam("treeId") long idParam, CreateUpdateTree treeDTO) {

        List<Tree> treeList = DaoFactory.getTreeDAO().findAll();
        Optional<Tree> foundTree = treeList.stream().filter(t -> t.getId() == idParam).findFirst();

        if (foundTree.isPresent()) {
            Tree treeUpdate = foundTree.get();
            treeUpdate.setName(treeDTO.getName());
            treeUpdate.setFamily(treeDTO.getFamily());
            treeUpdate.setEdible(treeDTO.isEdible());
            treeUpdate.setLatitude(treeDTO.getLatitude());
            treeUpdate.setLongitude(treeDTO.getLongitude());
            return Response.ok(treeUpdate.toDTO()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    // DELETE /api/tree/10 -> supprime l'arbre ayant pour identifiant 10
    @DELETE
    @Path("/{treeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTreeById(@PathParam("treeId") long idParam) {

        List<Tree> treeList = DaoFactory.getTreeDAO().findAll();
        Optional<Tree> foundTree = treeList.stream().filter(t -> t.getId() == idParam).findFirst();
        if (foundTree.isPresent()) {
            Tree treeRemove = foundTree.get();
            treeList.remove(treeRemove);
            return getAllTree();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
