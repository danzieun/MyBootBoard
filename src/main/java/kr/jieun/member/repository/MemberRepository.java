package kr.jieun.member.repository;

import org.springframework.data.repository.CrudRepository;

import kr.jieun.member.entity.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
