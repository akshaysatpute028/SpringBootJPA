package com.cdac.springbootjpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdac.springbootjpa.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	/*Notes:
	 * 
	 * //findby introduction findBy=select from Name=column where
	 * condition(like)=parameter(name) public Product findByNameLike(String name);
	 * 
	 * public ArrayList<Product> findByName(String name); 
	 * // findByPriceLessThan(int p_price); 
	 * // findByPriceGreaterThanEqual(int p_price);
	 * 
	 * @Query( "select p from Product p where p.p_name=:n and p.p_type=:t") public
	 * ArrayList<Product> getProductByName(@Param("n")String p_name,@Param("p")String p_type);
	 */
}
