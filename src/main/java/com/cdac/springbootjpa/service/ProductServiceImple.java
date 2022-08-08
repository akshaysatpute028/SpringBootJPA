package com.cdac.springbootjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.springbootjpa.dao.ProductRepository;
import com.cdac.springbootjpa.model.Product;

@Service
public class ProductServiceImple implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(int p_id) {
		Optional<Product> product=productRepository.findById(p_id);
		return product.get();
	}

	@Override
	public void deleteById(int p_id) {
		productRepository.deleteById(p_id);
	}


}
