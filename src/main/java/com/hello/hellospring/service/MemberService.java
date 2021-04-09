package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * 외부에서 memberRepository를 주입받도록 생성자를 설계함.
     * @param memberRepository
     */
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * @param member
     * @return
     */
     public Long join(Member member) {
         // 예시조건: 이름이 중복되는 회원이 있으면 안된다.
         validateDuplicateMember(member);   // 중복회원 검증
         memberRepository.save(member);
         return member.getId();
     }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
           .ifPresent(m -> {    // 만약 m(member)가 있으면 exception 처리
                throw new IllegalStateException("이미 존재하는 회원입니다.");
           });
    }

    /**
     * 회원 전체조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById((memberId));
    }
}
