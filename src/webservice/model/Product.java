package webservice.model;

public class Product {
	public Integer code;
	public String name;
	public String desc;
	
	public Product(Integer _code, String _name, String _desc) {
		this.code = _code;
		this.name = _name;
		this.desc = _desc;
	}
}
