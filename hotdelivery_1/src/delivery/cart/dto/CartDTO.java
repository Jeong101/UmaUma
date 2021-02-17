package delivery.cart.dto;

public class CartDTO {
	private String id;
	private String foodName;
	private int quantity;
	private String address;
	
	private int summoney;

	public CartDTO(String id, String foodName, int quantity, String address, int summoney) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.quantity = quantity;
		this.address = address;
		this.summoney = summoney;
	}

	public CartDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSummoney() {
		return summoney;
	}

	public void setSummoney(int summoney) {
		this.summoney = summoney;
	}

	@Override
	public String toString() {
		return "CartDTO [id=" + id + ", foodName=" + foodName + ", quantity=" + quantity + ", address=" + address
				+ ", summoney=" + summoney + "]";
	}
	
	
}