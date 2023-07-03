package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

//    @PersistenceContext         //JPA 의 EntityManager을 스프링에 주입해주기 위한 어노테이션
//    private EntityManager em;
//    //Spring이 EntityManager를 생성한뒤 의존성 주입.
//
//    public MemberRepository(EntityManager em) {
//        this.em = em;
//    }
//    SpringBoot에서는 EntityManager에 @Autowired를 적용할수있게끔하므로. Lombok 적용이가능하다.

    public void save(Member member){    //회원 저장
        em.persist(member);
    }

    public Member findOne(Long id){     //회원 찾기(단건 조회)
        return em.find(Member.class, id);
    }
    public List<Member> findAll(){  //JPQL을 사용해야한다. createQuery(JPQL,반환타입)
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();   //결과값을 List로 변환
    }

    public List<Member> findByName(String name){    //JPQL은 :변수명 과 .setParameter를 통해 변수를 넣어줄수있다.
        return em.createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name",name)
                .getResultList();
    }
}
