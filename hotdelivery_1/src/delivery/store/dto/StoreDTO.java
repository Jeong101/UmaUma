package delivery.store.dto;

public class StoreDTO {
	int storeNo;
	String storeName;
	String storePhone;
	String address;
	double latitude;
	double longitude;
	String imgUrl;
	String foodcode;
	

	public StoreDTO() {
		super();
	}
	
	
	public StoreDTO(int storeNo) {
		super();
		this.storeNo = storeNo;
	}


	public StoreDTO(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public StoreDTO(int storeNo, double latitude, double longitude) {
		super();
		this.storeNo = storeNo;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	


	
	public StoreDTO(int storeNo, String storeName, String storePhone, String address, double latitude,
			double longitude) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public StoreDTO(int storeNo, String storeName, String storePhone, String address, double latitude, double longitude,
			String imgUrl) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.imgUrl = imgUrl;
	}
	
	public StoreDTO(int storeNo, String storeName, String storePhone, String address, double latitude, double longitude,
			String imgUrl,String foodcode) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.imgUrl = imgUrl;
		this.foodcode = foodcode;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getFoodCode() {
		return foodcode;
	}


	public void setFoodCode(String foodcode) {
		this.foodcode = foodcode;
	}


	@Override
	public String toString() {
		return "StoreDTO [storeNo=" + storeNo + ", storeName=" + storeName + ", storePhone=" + storePhone + ", address="
				+ address + ", latitude=" + latitude + ", longitude=" + longitude + ", imgUrl=" + imgUrl + "]";
	}
	
	
	
	
	
}
