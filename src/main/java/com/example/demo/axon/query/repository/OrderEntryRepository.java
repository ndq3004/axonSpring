package com.example.demo.axon.query.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.axon.query.entries.OrderEntry;

/**
 * Created by Edison Xu on 2017/3/15.
 */
@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderEntryRepository extends PagingAndSortingRepository<OrderEntry, String> {
}
