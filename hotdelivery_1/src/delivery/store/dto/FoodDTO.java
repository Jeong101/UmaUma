package delivery.store.dto;

public class FoodDTO {
	int storeNo;
	int foodKind;
	String foodName;
	int price;
	String foodcode;
	int quantity;
	int sum;
	public FoodDTO() {
		super();
	}
	
	public String getFoodcode() {
		return foodcode;
	}

	public void setFoodcode(String foodcode) {
		this.foodcode = foodcode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public FoodDTO(String foodName, int price, int quantity, int sum) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.quantity = quantity;
		this.sum = sum;
	}

	public FoodDTO(String foodName) {
		super();
		this.foodName = foodName;
	}

	public FoodDTO(String foodName, int quantity) {
		super();
		this.foodName = foodName;
		this.quantity = quantity;
	}

	public FoodDTO(String foodName, int quantity,int price) {
		super();
		this.foodName = foodName;
		
		this.quantity = quantity;
		this.price = price;
	}

	public FoodDTO(int storeNo, int foodKind, String foodName, int price,String foodcode) {
		super();
		this.storeNo = storeNo;
		this.foodKind = foodKind;
		this.foodName = foodName;
		this.price = price;
		this.foodcode = foodcode;
	}
	
	public FoodDTO(int storeNo, int foodKind, String foodName, int price) {
		super();
		this.storeNo = storeNo;
		this.foodKind = foodKind;
		this.foodName = foodName;
		this.price = price;
	}
	
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public int getFoodKind() {
		return foodKind;
	}
	public void setFoodKind(int foodKind) {
		this.foodKind = foodKind;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getFoodCode() {
		return foodcode;
	}

	public void setFoodCode(String foodcode) {
		this.foodcode = foodcode;
	}

	@Override
	public String toString() {
		return "FoodDTO [storeNo=" + storeNo + ", foodKind=" + foodKind + ", foodName=" + foodName + ", price=" + price
				+ "]";
	}
	
	
}
