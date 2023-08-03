package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정 정보(구성 정보)
public class AppConfig {

    //각 메서드에 @Bean을 적어주면 스프링 컨테이너에 등록된다.
    //@Bean이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다. ex) memberService, orderService
    @Bean
    public MemberService memberService() {
        //생성자를 통해 생성한 객체(new 인스턴스 생성된것)이 들어간 것 : 용어로 생성자 주입이라고 한다.
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
