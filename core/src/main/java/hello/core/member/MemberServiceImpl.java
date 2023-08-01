package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //MemberServiceImpl 은 추상화와 구현체 둘다 의존하고 있어서 DIP 위반.
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
