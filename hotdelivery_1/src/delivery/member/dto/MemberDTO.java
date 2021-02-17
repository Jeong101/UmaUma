package delivery.member.dto;
/**
 * id varchar2(20),
	pwd varchar2(15),
	name varchar2(10),
	kind number(2),
	address varchar2(50)
	email varchar2(10);
 * */

public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String address;
	private int money;
	private String kind;
	private String StoreAddress;
	public MemberDTO() {
		super();
	}

	public MemberDTO(String id, String name, String email, String address, int money, String kind) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.money = money;
		this.kind = kind;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getStoreAddress() {
		return StoreAddress;
	}

	public void setStoreAddress(String storeAddress) {
		StoreAddress = storeAddress;
	}

	public MemberDTO(String id) {
		super();
		this.id = id;
	}

	public MemberDTO(String id, String pwd, String name, String email, String address, String kind) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.address = address;
		this.kind = kind;
	}

	public MemberDTO(String id, String pwd, String name, String email, String address, int money, String kind,
			String storeAddress) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.address = address;
		this.money = money;
		this.kind = kind;
		this.StoreAddress = storeAddress;
	}

	public MemberDTO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public MemberDTO(String id, String pwd, String name, String email, String address, int money, String kind) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.address = address;
		this.money = money;
		this.kind = kind;
	}

	public MemberDTO(String id, String pwd, String email, String address) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", money=" + money + ", kind=" + kind + ", StoreAddress=" + StoreAddress + "]";
	}

	
	
	
}
