package jpabook.jpashop.service;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional  //기본적으로 데이터변경을 하는부분에서는 Transactional이 필요하다.
@RequiredArgsConstructor    //final 적용이 된 field 에 생성자를 만들어준다.
public class MemberService {

    //생성자 주입 방식을 채택하여 사용하자. 아님 Configuration 사용하든가. 생성자 하나일경우엔 @Autowired가 알아서 됨
    //RequiredArgsConstructor 채택
    private final MemberRepository memberRepository;

    /**
     * 회원 가입(회원 객체를 넣으면 회원가입한뒤 MemberID 반환)
     * @param member 회원 객체
     * @return = memberID 반환
     */
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 중복 회원이 있는지에 대해 조회하기 위한 메서드
     * @param member 회원 객체
     */
    private void validateDuplicateMember(Member member) {
        //중복 회원일시 예외처리
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     * @return 전체 회원을 List<Member> 형태로 반환
     */
    @Transactional(readOnly = true)         //조회 부분에서는 이러한 옵션이 성능면에서 좋다. 단 데이터변경 X
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 단일 회원 조회
     * @param memberId 단일 회원의 ID
     * @return  그 회원의 정보를 Member객체로서 반환.
     */
    @Transactional(readOnly = true)
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
