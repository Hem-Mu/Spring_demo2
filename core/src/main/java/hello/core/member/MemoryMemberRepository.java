package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 동시작업을 위해 실제로는 ConcurrentHashMap권장

    @Override

    public void save(Member member) {
        store.put(member.getId(), member); // 저장
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); // ID 조회
    }
}
