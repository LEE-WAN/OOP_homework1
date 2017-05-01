package book;

public interface Rentable {
	public int getRentalFee();
	public boolean isRented();
	public Boolean rentedBy(String username);
	public Boolean returnBy(String username);
}
