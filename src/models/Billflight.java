package models;

public class Billflight {
	private int billflight_id ;
	private int flight_id ;
	private int user_id ;
	private String fullName ;
	private int passport ;
	private double pricefrais ;
	private String category ;
	private String SeatType ;
	private int numSeat ;
	
	
	public Billflight(int billflight_id, int flight_id, int user_id, String fullName, int passport, double pricefrais,
			String category, String seatType, int numSeat) {
		super();
		this.billflight_id = billflight_id;
		this.flight_id = flight_id;
		this.user_id = user_id;
		this.fullName = fullName;
		this.passport = passport;
		this.pricefrais = pricefrais;
		this.category = category;
		SeatType = seatType;
		this.numSeat = numSeat;
	}


	public Billflight(int flight_id, int user_id, String fullName, int passport, double pricefrais, String category,
			String seatType, int numSeat) {
		super();
		this.flight_id = flight_id;
		this.user_id = user_id;
		this.fullName = fullName;
		this.passport = passport;
		this.pricefrais = pricefrais;
		this.category = category;
		SeatType = seatType;
		this.numSeat = numSeat;
	}


	public Billflight() {
		super();
	}


	public int getBillflight_id() {
		return billflight_id;
	}


	public void setBillflight_id(int billflight_id) {
		this.billflight_id = billflight_id;
	}


	public int getFlight_id() {
		return flight_id;
	}


	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public int getPassport() {
		return passport;
	}


	public void setPassport(int passport) {
		this.passport = passport;
	}


	public double getPricefrais() {
		return pricefrais;
	}


	public void setPricefrais(double pricefrais) {
		this.pricefrais = pricefrais;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getSeatType() {
		return SeatType;
	}


	public void setSeatType(String seatType) {
		SeatType = seatType;
	}


	public int getNumSeat() {
		return numSeat;
	}


	public void setNumSeat(int numSeat) {
		this.numSeat = numSeat;
	}


	@Override
	public String toString() {
		return "Billflight [billflight_id=" + billflight_id + ", flight_id=" + flight_id + ", user_id=" + user_id
				+ ", fullName=" + fullName + ", passport=" + passport + ", pricefrais=" + pricefrais + ", category="
				+ category + ", SeatType=" + SeatType + ", numSeat=" + numSeat + "]";
	}
	
	
	
	
	

}
