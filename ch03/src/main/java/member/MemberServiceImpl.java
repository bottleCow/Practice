package member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao md;

	public int insert(Member member) {
		int result = 0;
		//member2 는 11줄의 member와 구분하기 위해서 2를 붙임
		//member2는 조회한 멤버, member는 입력한 회원으로 구분
		//입력하려는 데이터가 있는지 확인하여 중복체크
		Member member2 = md.select(member.getId());
		if (member2 == null) {
			result = md.insert(member);
		} else System.out.println("이미 존재하는 데이터 입니다");
		return result;
	}

	public void select(String id) {
		Member member = md.select(id);
		if (member == null) System.out.println("없는 아이디 입니다");
		else print(member);
	}
	
	// 위에 select메서드 에서 사용되는 print메서드 정의
	private void print(Member member) {
		System.out.println("======회원 정보======");
		System.out.println("아이디 : "+member.getId());
		System.out.println("이름 : "+member.getName());
		System.out.println("이메일 : "+member.getEmail());
		System.out.println("등록일 : "+member.getRegdate());
	}

	public void list() {
		List<Member> list = md.list();
		if (list == null || list.size()==0)
			System.out.println("데이터가 없습니다");
		else
			for(Member member:list) {
				print(member);
			}
	
	}

	public int update(Member member) {
		int result = 0;
		Member member2 = md.select(member.getId());
		if (member2 != null) {
			result = md.update(member);
		} else System.out.println("없는 데이터는 수정할 수 없습니다");
		return result;
	}

	public int delete(String id) {
		int result = 0;
		Member member2 = md.select(id);
		if (member2 != null) {
			result = md.delete(id);
		} else System.out.println("없는 데이터는 삭제할 수 없습니다");
		return result;
	}
}
