package hello.core.singleton;

public class SingletonService {

	private static final SingletonService instance = new SingletonService();
	
	public static SingletonService getInstance() {
		return instance;
	}
	
	private SingletonService() {
		// TODO Auto-generated constructor stub
	}
	
	public void logic() {
		System.out.println("싱글톤 객체 로직 호출");
	}
}
