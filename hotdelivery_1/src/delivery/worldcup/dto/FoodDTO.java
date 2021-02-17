package delivery.worldcup.dto;

public class FoodDTO {
	private String foodKind;
	private int foodNo;// 기준으로 random 돌리기 위한 숫자
	private String imgUrl;
	private String foodcode;
	
	public FoodDTO(String foodKind, int foodNo, String imgUrl) {
		super();
		this.foodKind = foodKind;
		this.foodNo = foodNo;
		this.imgUrl = imgUrl;
	}
	
	public FoodDTO(String foodKind, int foodNo, String imgUrl,String foodcode) {
		super();
		this.foodKind = foodKind;
		this.foodNo = foodNo;
		this.imgUrl = imgUrl;
		this.foodcode = foodcode;
	}
	
	public FoodDTO() {
		super();
	}
	public String getFoodKind() {
		return foodKind;
	}
	public void setFoodKind(String foodKind) {
		this.foodKind = foodKind;
	}
	public int getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getFoodCode() {
		return foodcode;
	}

	public void setFoodCode(String foodcode) {
		this.foodcode = foodcode;
	}
	
	
	
	
}
