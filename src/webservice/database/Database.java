package webservice.database;

import java.util.ArrayList;
import java.util.List;

import webservice.model.Pricebook;
import webservice.model.PricebookEntry;
import webservice.model.Product;

public class Database {
	public static Integer code_product = 1;
	public static Integer code_pricebook = 1;
	public static Integer code_pricebookEntry = 1;
	
	public static List<Product> products = new ArrayList<Product>() {
		{
			add(new Product(0, "Bicicleta", "Bicicleta com marcha V2"));
		}
	};
	public static List<Pricebook> pricebooks = new ArrayList<Pricebook>() {
		{
			add(new Pricebook(0, "Catalogo de Verao - 2019", "Valores referentes a verao de 2019"));
		}
	};
	public static List<PricebookEntry> pricebookEntries= new ArrayList<PricebookEntry>() {
		{
			add(new PricebookEntry(0, products.get(0), pricebooks.get(0), 1999.30));
		}
	};
}
