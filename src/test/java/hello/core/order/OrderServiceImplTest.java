package hello.core.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.Order;
import hello.core.discount.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImplTest {

	@Test
	void createOrder() {
		MemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.save(new Member(1L, "name", Grade.VIP));
		
		OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
		
		Order order = orderService.createOrder(1L, "itemA", 10000);
		
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}
