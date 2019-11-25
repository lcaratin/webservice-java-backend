package webservice.dao;

import java.util.List;

import webservice.database.Database;
import webservice.model.Pricebook;

public class PricebookDAO {
	public static List<Pricebook> getAll() {
		return Database.pricebooks;
	}
	
	public static void insert (Pricebook pricebook) {
		Database.pricebooks.add(pricebook);
		Database.code_pricebook += 1;
	}
	
	public static void delete (Integer code) {
		Database.pricebooks.removeIf(item -> item.code == code);
	}
}
