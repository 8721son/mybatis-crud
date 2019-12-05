package com.won.project.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.won.project.model.Board;

// 원래 방식은 @Repository가 필요하다.
// 그런데 DataAccessConfig에서 MapperScan을 할 때
// 메모리(스프링 컨테이너)에 로드된다.
// 싱글톤으로 관리된다.

@Repository
public interface BoardRepository {
	List<Board> findAll(); //전체보기
	int save(Board board); //글쓰기
	int update(Board board); //수정하기
	Board findById(int id); //상세보기
	int delete(int id); //삭제하기
}
