package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Team;

import javax.persistence.*;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team team = new Team();
            team.setName("TEAMA");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);//단방향 연관관계 설정, 참조 저장
            em.persist(member);

            em.flush();
            em.clear();
//
//            Member findMember = em.find(Member.class,member.getId());
//            findMember.getTeam().

            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
