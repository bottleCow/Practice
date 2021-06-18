package samp17;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired //setter 필요없음
	private MemberDao md;
	/*
	 * public void setMd(MemberDao md) { this.md = md; }
	 */
	public int insert(Member member) {
		int result = 0;
		// mem으로 한 이유는 member와 이름이 다르게하기 위해서
		Member mem = md.select(member.getId());
		if (mem == null) { // 같은 아이디가 없으므로 입력 가능
			result = md.insert(member);
		} else System.out.println("이미 있는 아이디 입니다");
		return result;
	}
	public Member select(String id) {
		return md.select(id);
	}
	public Collection<Member> list() {
		return md.list();
	}
	public int update(Member member) {
		int result = 0;
		Member mem = md.select(member.getId());
		if (mem == null) { 
			System.out.println("없는 데이터는 수정 못합니다");
		} else result = md.update(member);
		return result;
	}
	public int delete(String id) {
		int result = 0;
		Member mem = md.select(id);
		if (mem == null) { 
			System.out.println("없는 데이터는 삭제 못합니다");
		} else result = md.delete(id);
		return result;
	}
	
}