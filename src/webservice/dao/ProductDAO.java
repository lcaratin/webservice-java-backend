package webservice.dao;

import java.util.List;

import webservice.database.Database;
import webservice.model.PricebookEntry;
import webservice.model.Product;

public class ProductDAO {
	public static List<Product> getAll() {
		return Database.products;
	}
	
	public static void insert (Product product) {
		Database.products.add(product);
		Database.code_product += 1;
	}
	
	public static void delete (Integer code) {
		Database.products.removeIf(item -> item.code == code);
	}
}
