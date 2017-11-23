package kr.or.kosta.semicolon.gpurchase.domain;

public class CategorySales {
	private int price;
	private int category;
	
	public CategorySales() { }
	
	public CategorySales(int price, int category) {
		super();
		this.price = price;
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategorySales [price=" + price + ", category=" + category + "]";
	}
	
}
