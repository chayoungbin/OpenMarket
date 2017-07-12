package product;

import java.sql.Timestamp;

public class proDTO {

	int productnumber;
	String nickname;
	int categorynumber;
	String title;
	String productinformation;
	String location;
	String productstate;
	int rentprice;
	int rentmaxdate;
	int rentdeposite;
	String img;
	Timestamp curtime;
	String kakaotalkid;
	String phone;

	public proDTO(int productnumber,String nickname,int categorynumber,String title, String location,String productinformation,String productstate,int rentprice,int rentmaxdate,int rentdeposite,String img,Timestamp curtime,String kakaotalkid,String phone){
		this.productnumber = productnumber;
		this.nickname = nickname;
		this.categorynumber = categorynumber;
		this.title = title;
		this.productinformation = productinformation;
		this.location = location;
		this.productstate = productstate;
		this.rentprice = rentprice;
		this.rentmaxdate = rentmaxdate;
		this.rentdeposite = rentdeposite;
		this.img = img;
		this.curtime = curtime;
		this.kakaotalkid = kakaotalkid;
		this.phone = phone;
	}

	public String getKakaotalkid() {
		return kakaotalkid;
	}

	public void setKakaotalkid(String kakaotalkid) {
		this.kakaotalkid = kakaotalkid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getProductnumber() {
		return productnumber;
	}

	public void setProductnumber(int productnumber) {
		this.productnumber = productnumber;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCategorynumber() {
		return categorynumber;
	}

	public void setCategorynumber(int categorynumber) {
		this.categorynumber = categorynumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProductinformation() {
		return productinformation;
	}

	public void setProductinformation(String productinformation) {
		this.productinformation = productinformation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProductstate() {
		return productstate;
	}

	public void setProductstate(String productstate) {
		this.productstate = productstate;
	}

	public int getRentprice() {
		return rentprice;
	}

	public void setRentprice(int rentprice) {
		this.rentprice = rentprice;
	}

	public int getRentmaxdate() {
		return rentmaxdate;
	}

	public void setRentmaxdate(int rentmaxdate) {
		this.rentmaxdate = rentmaxdate;
	}

	public int getRentdeposite() {
		return rentdeposite;
	}

	public void setRentdeposite(int rentdeposite) {
		this.rentdeposite = rentdeposite;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Timestamp getCurtime() {
		return curtime;
	}

	public void setCurtime(Timestamp curtime) {
		this.curtime = curtime;
	}
	

	
}
