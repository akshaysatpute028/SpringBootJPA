package com.cdac.springbootjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Controller;

@Controller
@Entity
public class Product {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int p_id;
	@Column
	private String p_name;
	private String p_type;
	private int p_price;
	private String p_description;
	public Product() {}
	public Product(int p_id, String p_name, String p_description, String p_type, int p_price) {
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_description = p_description;
		this.p_type = p_type;
		this.p_price = p_price;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_description() {
		return p_description;
	}
	public void setP_description(String p_description) {
		this.p_description = p_description;
	}
	public String getP_type() {
		return p_type;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_description=" + p_description + ", p_type="
				+ p_type + ", p_price=" + p_price + "]";
	}
	
	
}
