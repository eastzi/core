package hello.core.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;

@Component

public class OrderServiceImpl implements OrderService {
	
//	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final MemberRepository memberRepository;
	
//	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//	private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	private final DiscountPolicy discountPolicy; //인터페이스에 의존하도록 설계변경
	
	/*
	@Autowired
	public void setMemberRepository(MemberRepository memberRepository) {
		System.out.println("memberRepository = " + memberRepository);
		this.memberRepository = memberRepository;
	}
	
	@Autowired
	public void setDiscountPolicy(DiscountPolicy discountPolicy) {
		System.out.println("discountPolicy = " + discountPolicy);
		this.discountPolicy = discountPolicy;
	}
	*/
	/* @RequiredArgsConstructor 가 만들어주는 생성자(final 붙은 변수를)*/
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
		super();
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	//테스트용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
