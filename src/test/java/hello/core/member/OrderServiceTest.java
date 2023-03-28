package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.discount.Order;
import hello.core.discount.OrderService;
import hello.core.discount.OrderServiceImpl;

public class OrderServiceTest {

	AppConfig appConfig = new AppConfig();
//	MemberService memberService = new MemberServiceImpl();
	MemberService memberService = appConfig.memberService();
//	OrderService orderService = new OrderServiceImpl();
	OrderService orderService = appConfig.orderService();
	
	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
	
}
