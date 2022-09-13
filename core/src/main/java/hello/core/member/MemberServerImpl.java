package hello.core.member;

public class MemberServerImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository(); //null이면 안됨

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
