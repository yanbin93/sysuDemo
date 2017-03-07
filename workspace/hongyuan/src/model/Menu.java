package model;
public class Menu {
	private Integer id;
	private String name;
	private String url;
	private String description;
	private Double price;
	private int num;                   //表示该书的库存
	private int shoppingNum=1; 

	public int getShoppingNum() {
		return shoppingNum;
	}
	public void setShoppingNum(int shoppingNum) {
		this.shoppingNum = shoppingNum;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName(){
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
