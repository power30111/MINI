package hellojpa;

import hellojpa.jpabook.MemberV2;
import hellojpa.jpabook.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            //저장
            Team team = new Team();
            team.setName("TEAM_A");
            em.persist(team);

            MemberV2 memberV2 = new MemberV2();
            memberV2.setUsername("member2");
            memberV2.setTeam(team);
            em.persist(memberV2);

            MemberV2 findMember = em.find(MemberV2.class, memberV2.getId());
            List<MemberV2> members = findMember.getTeam().getMembers();

            for (MemberV2 member : members) {
                System.out.println("member = " + member.getUsername());
            }


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
