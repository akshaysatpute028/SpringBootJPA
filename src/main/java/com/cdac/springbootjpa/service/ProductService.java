package com.cdac.springbootjpa.service;

import com.cdac.springbootjpa.model.Product;


public interface ProductService {
	public Product save(Product user);
	public Iterable<Product> findAll();
	public Product findById(int id);
	public void deleteById(int id);
}
