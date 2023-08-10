package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {

    //주문 생성 요청이 오면

    //회원 정보 조회 후
    private MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //할인 정책에 회원 넘기기, 이 코드는 추상(인터페이스)와 구체 클래스에 모두 의존하고 있어서 DIP 위반.
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    //위 고정 할인 시스템에서 비율 할인으로 바뀌면서 OrderServiceImple의 소스코드도 변경되었으므로 OCP 위반.
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //구현체를 없애고 인터페이스만 연결 ( DIP 위반 x ), but 연결된게 없어서 nullpointexception이 뜸, 그래서 생성자 할당(MemberServiceImpl과 같음)
    private DiscountPolicy discountPolicy;

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

/*
    //아래와 같이 생성자가 1개인 경우(public OrderServiceImpl이 하나) 에는 @Autowired를 생략해도 자동 주입 * 스프링 빈에만 해당
    //위에서 각자의 생성자를 생성해줌에 따라 아래 코드는 쓸모 없어짐
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //단일 체계 원칙 잘 지켜진 것

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
