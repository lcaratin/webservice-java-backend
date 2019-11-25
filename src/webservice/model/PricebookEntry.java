package webservice.model;

public class PricebookEntry {
	public Integer code;
	Product product;
	Pricebook pricebook;
	Double price;
	
	public PricebookEntry(Integer _code, Product _product, Pricebook _pricebook, Double _price) {
		this.code = _code;
		this.product = _product;
		this.pricebook = _pricebook;
		this.price = _price;
	}
}
