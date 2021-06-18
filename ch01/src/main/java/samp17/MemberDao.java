package samp17;
import java.util.Collection;
public interface MemberDao {
	Member select(String id);
	int insert(Member member);
	Collection<Member> list();
	int update(Member member);
	int delete(String id);

}