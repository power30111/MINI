package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("helloA");

            em.persist(member);

            tx.commit();

            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember = " + findMember.getName());
            System.out.println("findMember = " + findMember.getId());


            System.out.println("변경");
            findMember.setName("helloB");
            System.out.println("findMember = " + findMember.getName());

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
