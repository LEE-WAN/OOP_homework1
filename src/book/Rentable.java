package book;

/**
 * UserManager에서 사용하는 인터페이스.
 * @author puppy
 *
 */
public interface Rentable {
	public int getRentalFee();
	public boolean isRented();
	public Boolean rentedBy(String username);
	public Boolean returnBy(String username);
}
