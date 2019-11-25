package webservice.model;

public class PricebookEntryWrapper {
	Integer product;
	Integer pricebook;
	Double price;
	
	public PricebookEntryWrapper(Integer _product, Integer _pricebook, Double _price) {
		this.product = _product;
		this.pricebook = _pricebook;
		this.price = _price;
	}
}
