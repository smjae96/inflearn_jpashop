package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jySim
 * @since 2025. 4. 17.
 */
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member); // persist 시 영속성 컨텍스트에 Member 객체를 넣고, commit 시점에 DB에 반영(insert)
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id); // JPA의 find 메소드 - 단건 조회(pk)
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList(); // from의 대상이 테이블이 아니라 Member 엔티티 객체임!
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class) // 파라미터 바인딩을 통해 특정 이름의 member만 조회
                .setParameter("name", name)
                .getResultList();
    }
}
