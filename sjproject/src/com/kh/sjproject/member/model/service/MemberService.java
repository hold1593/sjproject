package com.kh.sjproject.member.model.service;

import static com.kh.sjproject.common.JDBCTemplate.commit;
import static com.kh.sjproject.common.JDBCTemplate.getConnection;
import static com.kh.sjproject.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.sjproject.member.model.dao.MemberDao;
import com.kh.sjproject.member.model.vo.Member;

public class MemberService {

	/**
	 * 로그인용 Service
	 * 
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Member member) throws Exception {
		Connection conn = getConnection();

		Member loginMember = new MemberDao().loginMember(conn, member);

		return loginMember;
	}

	/**
	 * 아이디 중복 확인용 Service
	 * 
	 * @param id
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String id) throws Exception {
		Connection conn = getConnection();
		return new MemberDao().inDupCheck(conn, id);
	}

	public int signUp(Member member) throws Exception {

		Connection conn = getConnection();

		int result = new MemberDao().signUp(conn, member);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}

	/**
	 * 회원 정보 조회용 서비스
	 * 
	 * @param memberId
	 * @return selectmember
	 */
	public Member selectMember(String memberId) throws Exception {

		Connection conn = getConnection();

		return new MemberDao().selectMember(conn, memberId);
	}

	public int upDate(Member member) throws Exception {

		Connection conn = getConnection();

		int result = new MemberDao().upDate(conn, member);

		// 트랜잭션 처리 (DML은 트랜잭션처리가 필요함. 성공시 commit 실패시 rollback)
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;

	}

	/**
	 * 비밀번호 수정용 서비스
	 * 
	 * @param loginMember
	 * @param newPwd
	 * @return result
	 * @throws Exception
	 */
	public int updatePwd(Member loginMember, String newPwd) throws Exception {

		Connection conn = getConnection();
		MemberDao memberDao = new MemberDao();
		// 현재 비밀번호 일치 여부 확인
		// SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID=? AND MEMBER_PWD=?

		int result = memberDao.checkPwd(conn, loginMember);

		if (result > 0) { // 현재 비밀번호가 일치할 경우
			// 비밀번호 변경
			loginMember.setMemberPwd(newPwd);
			result = memberDao.updatePwd(conn, loginMember);

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

			return result;

		} else {
			// 현재 비밀번호가 다를 경우
			return -1;
		}

	}

	/** 회원 탈퇴용 서비스
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int deleteMember(Member loginMember) throws Exception {

		Connection conn = getConnection();
		MemberDao memberDao = new MemberDao();

		int result = memberDao.checkPwd(conn, loginMember);

		if (result > 0) { //현재 비밀번호 일치
			
			// 회원탈퇴진행
			result = memberDao.deleteMember(conn, loginMember.getMemberId());

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

			return result;
		} else { // 현재 비밀번호 불일치
			return -1;
		}
	}

}
