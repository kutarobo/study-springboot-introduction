package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // 찾는 값이 없을 경우를 대비해서 옵셔널 널러블로 감싸준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()  // 자바8의 람다방식
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() { // 자바 실무에서는 list를 많이 사용한다.
        return new ArrayList<>(store.values()); // values는 store에 있는 Member들이 반환이됨.
    }

    public void clearStore() {
        store.clear();
    }
}
