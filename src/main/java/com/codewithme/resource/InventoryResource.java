package com.codewithme.resource;

import com.codewithme.entities.InventoryItem;
import com.codewithme.repository.InventoryItemRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/inventory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryResource {

    @Inject
    InventoryItemRepository inventoryRepository;

    @GET
    public List<InventoryItem> getAllItems() {
        return inventoryRepository.listAll();
    }

    @POST
    @Transactional
    public InventoryItem addItem(InventoryItem item) {
        inventoryRepository.persist(item);
        return item;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public InventoryItem updateItem(@PathParam("id") Long id, InventoryItem item) {
        InventoryItem existingItem = inventoryRepository.findById(id);
        existingItem.setName(item.getName());
        existingItem.setPrice(item.getPrice());
        existingItem.setQuantity(item.getQuantity());
        return existingItem;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteItem(@PathParam("id") Long id) {
        inventoryRepository.deleteById(id);
    }
}
