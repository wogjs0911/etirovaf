package com.etirovaf.backend;

import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.model.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BackendApplicationTests {

	@PersistenceContext
	EntityManager em;
	JPAQueryFactory queryFactory;

	@BeforeEach
	public void before() {
		queryFactory = new JPAQueryFactory(em);
		Member member1 = new Member(1L,"member1");
		em.persist(member1);
	}

	@Test
	public void fetchMember() {
		QMember m = new QMember("m");

		Member findMember = queryFactory
				.select(m)
				.from(m)
				.where(m.username.eq("member1"))
				.fetchOne();

		assertEquals(findMember.getUsername(), "member1");
	}
}
