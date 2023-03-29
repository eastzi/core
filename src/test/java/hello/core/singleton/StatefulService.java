package hello.core.singleton;

public class StatefulService {

	private int price;
	
	public int order(String name, int price) {
		System.out.println("name = " + name + " price = " + price);
		//this.price = price; //문제 발생 지점
		return price;
	}
	
	public int getPrice() {
		return price;
	}
}
