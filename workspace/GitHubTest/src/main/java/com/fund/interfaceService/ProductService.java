package com.fund.interfaceService;


import java.util.List;

import com.fund.model.Product;

public interface ProductService {
	public void setAddProduct(Product product) ;
	

	public void setDeletProduct(Product product) ;
	
	public List<Product> getProductService();
}