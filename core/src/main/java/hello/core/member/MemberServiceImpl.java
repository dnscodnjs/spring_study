package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //MemberServiceImpl 은 추상화와 구현체 둘다 의존하고 있어서 DIP 위반.
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 구현체를 삭제함으로 DIP를 지키게 됨. 이렇게 하고 밑에 생성자 만든후에 AppConfig(환경구성 기획자 느낌으로 하는 것) 에서 구현체를 생성
    //이렇게 해서 MemberServiceImple은 MemoryMemberRepository를 의존하지 않는다.
    private final MemberRepository memberRepository;

    //이 생성자를 통해서 어떤 구현 객체를 주입할지는 AppConfig 에서만 결정된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
