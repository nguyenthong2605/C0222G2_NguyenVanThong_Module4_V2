package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery(
                        "select p from Product p", Product.class
                );
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction =
                BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();

    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction entityTransaction =
                BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction =
                BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(id);
        entityTransaction.commit();
    }
}
