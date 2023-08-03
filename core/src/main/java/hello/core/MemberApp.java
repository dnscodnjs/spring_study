package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        //appconfig를 생성하면서 바뀜
        //MemberService memberService = new MemberServiceImpl(memberRepository);

/*        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/

        //위에선 AppConfig 에서 직접 찾아왔지만, 아래는 스프링 컨테이너를 통해서 찾아온다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.Vip);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
