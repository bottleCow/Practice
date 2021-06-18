package samp17;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
public class Ex01 {
	// 전역변수(여러 메서드에서 같이사용), static 클래스 변수, 객체를 생성하지 않고 바로 사용
	private static MemberService ms = null;
	private static Scanner sc = null;
	public static void main(String[] args) {
		AbstractApplicationContext ac = 
			new AnnotationConfigApplicationContext(JavaConfig.class);
		ms = ac.getBean(MemberService.class);
		sc = new Scanner(System.in);
		while(true) {
			System.out.println("명령어를 입력하세요");
			String command = sc.nextLine();
			if (command.equals("1")) break;
			else if (command.equals("2")) 	insert(); 
			else if (command.equals("3"))	update();
			else if (command.equals("4")) 	delete();
			else if (command.equals("5"))	select();
			else if (command.equals("6"))	list();
			else help();
		}
		System.out.println("프로그램 종료");
		sc.close();  ac.close();
	}
	private static void delete() {
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		int result = ms.delete(id);
		if (result > 0) System.out.println("삭제 됐네 대박 !!!");
	}
	private static void update() {
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("암호를 입력하세요");
		String pass = sc.nextLine();
		System.out.println("암호확인을 입력하세요");
		String confirmPass = sc.nextLine();
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("이메일을 입력하세요");
		String email = sc.nextLine();
		if (!pass.equals(confirmPass)) {
			System.out.println("암호와 암호 확인이 다릅니다");
			return;
		}
		Member member = new Member(id,pass, name, email, new Date());
		int result = ms.update(member);
		if (result > 0) System.out.println("수정 성공 ㅋㅋ");
	}
	private static void list() {
		Collection<Member> list = ms.list();
		if (list == null || list.size()==0)
			System.out.println("데이터가 없습니다");
		else
			for(Member member: list)
				System.out.println(member);
	}
	private static void select() {
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		Member member = ms.select(id);
		if (member == null) System.out.println("없는 데이터 입니다");
		else System.out.println(member);
	}
	private static void insert() {
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("암호를 입력하세요");
		String pass = sc.nextLine();
		System.out.println("암호확인을 입력하세요");
		String confirmPass = sc.nextLine();
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("이메일을 입력하세요");
		String email = sc.nextLine();
		if (!pass.equals(confirmPass)) {
			System.out.println("암호와 암호 확인이 다릅니다");
			return;
		}
		Member member = new Member(id,pass, name, email, new Date());
		int result = ms.insert(member);
		if (result > 0) System.out.println("입력 성공 ㅋㅋ");
	}
	private static void help() {
		System.out.println("명령어를 선택하세요");
		System.out.println("1. 종료");
		System.out.println("2. 입력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 조회");
		System.out.println("6. 전체 목록");
		
	}
}