package com.codewithme.repository;

import com.codewithme.entities.InventoryItem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InventoryItemRepository implements PanacheRepository<InventoryItem> {
}