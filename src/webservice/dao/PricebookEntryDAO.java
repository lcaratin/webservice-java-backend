package webservice.dao;

import java.util.List;

import webservice.database.Database;
import webservice.model.Pricebook;
import webservice.model.PricebookEntry;

public class PricebookEntryDAO {
	public static List<PricebookEntry> getAll() {
		return Database.pricebookEntries;
	}
	
	public static void insert (PricebookEntry pricebookEntry) {
		Database.pricebookEntries.add(pricebookEntry);
		Database.code_pricebookEntry += 1;
	}
	
	public static void delete (Integer code) {
		Database.pricebookEntries.removeIf(item -> item.code == code);
	}
}
