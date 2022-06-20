package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(123, "Áo", 40.2, "Còn", "Việt Nam"));
        products.put(2, new Product(231, "Quần", 23.1, "Hết", "Trung Quốc"));
        products.put(3, new Product(213, "Giày", 15.6, "Còn", "Pháp"));
        products.put(4, new Product(940, "Dép", 20.6, "Còn", "Việt Nam"));
        products.put(5, new Product(245, "Mũ", 52.2, "Hết", "Mỹ"));
        products.put(6, new Product(142, "Nhẫn", 30.0, "Còn", "Quảng Nam"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        for (Map.Entry<Integer, Product> entry: products.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void update(Integer id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        for (Map.Entry<Integer, Product> entry: products.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                products.remove(entry.getKey());
                break;
            }
        }
    }
}
