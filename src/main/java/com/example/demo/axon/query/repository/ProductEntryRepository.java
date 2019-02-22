package com.example.demo.axon.query.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.axon.query.entries.ProductEntry;

/**
 * Remember to add {@code EnableJpaRepositories} in the start Application
 * <br>
 * Created by Edison Xu on 2017/3/14.
 */
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductEntryRepository extends PagingAndSortingRepository<ProductEntry, String> {

}
