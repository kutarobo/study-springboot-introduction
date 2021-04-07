package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // DI. dependency Injection. 의존성 주입방식 으로 처리하는 예시.
    // MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    // 위와 같은 코드방식은 service에 있는것도 new 이고 여기도 new로 생성하면 서로다른 instance 이기때문에 권장하지않는 방식이다.
    // 아래와같이 service의 생성자에서 외부의 repository를 받도록 한 후 (service는 이제 DI가 적용됨)
    // BeforeEach에서 처리하도록 해준다. (테스트 실행하기 이전에 실행되는 어노테이션)
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); // 각 테스트를 실행하기전에 같은 메모리 멤버리파지토리를 사용하도록 하게 한다
    }





    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }


    // 테스트명은 한글로 바꿔도 된다.
    // production 코드와 다르게 직관적으로 알아보기 쉽기때문에..일하는 사람의 취향과 룰에 따르자.
    @Test
    void 회원가입() {
        /*
            테스트의 given, when, then 문법
            given 상황이 주어졌을 때
            when 실행했을때
            then 이런 결과가 나와야한다.
         */
        // given
        Member member = new Member();
        member.setName("spring1");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        // try..catch 대신 assertThrows 를 이용한다. member2를 join 하면 해당 join의 예외가 터져야한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.1");
        }
*/
        // then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}