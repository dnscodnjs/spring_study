package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //주문 생성 요청이 오면
    
    //회원 정보 조회 후
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    
    //할인 정책에 회원 넘기기
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //단일 체계 원칙 잘 지켜진 것

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
