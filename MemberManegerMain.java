package vacation;

import java.util.ArrayList;
import java.util.Scanner;

class Member {
	private String name;
	private String gender;
	private int age;
	private String tel;
	private String address;
	private String somthing;

	public Member(String name, String gender, int age, String tel, String address, String somthing) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.tel = tel;
		this.address = address;
		this.somthing = somthing;
	}

	String getName() { return name; }
	String getGender() { return gender; }
	int getAge() { return age; }
	String getTel() { return tel; }
	String getAddress() { return address; }
	String getSomthing() { return somthing;}
	
	void setName(String name) { this.name = name; }
	void setGender(String gender) { this.gender = gender; }
	void setAge(int age) { this.age = age; }
	void setTel(String tel) { this.tel = tel; }
	void setAddress(String address) { this.address = address; }
	void setSomthing(String somthing) { this.somthing = somthing; }
}

class MemberManegement {
	Scanner sc = new Scanner(System.in);
	ArrayList<Member> members = new ArrayList<>();

	void addMember(Member member) {
		members.add(member);
		System.out.println("등록 완료");
	}

	void setMemberInfo(String name) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(name)) {

				System.out.println("어떤 정보를 수정하시겠습니까?\n1.이름 2.성별 3.나이 4.전화번호 5.주소 6.비고 7.취소");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.println("새 이름 : ");
					members.get(i).setName(sc.nextLine());
					break;
				case 2:
					System.out.println("새 성별 : ");
					members.get(i).setGender(sc.nextLine());
					break;
				case 3:
					System.out.println("새 나이 : ");
					members.get(i).setAge(sc.nextInt());
					sc.nextLine();
					break;
				case 4:
					System.out.println("새 번호 : ");
					members.get(i).setTel(sc.nextLine());
					break;
				case 5:
					System.out.println("새 주소 : ");
					members.get(i).setAddress(sc.nextLine());
					break;
				case 6:
					System.out.println("비고 : ");
					members.get(i).setSomthing(sc.nextLine());
					break;
				}

				System.out.println("수정 완료!");
				return;
			}
		}
		System.out.println("없는 회원입니다.");
	}

}

public class MemberManegerMain {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		MemberManegement manager = new MemberManegement();
		while (true) {
			System.out.println("1. 등록 2. 수정 3. 삭제 4. 이름으로 정보 검색 5. 회원 목록 6. 종료");
			System.out.print("선택: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("회원 등록");
				System.out.print("이름: ");
				String name = sc.nextLine();
				System.out.print("성별: ");
				String gender = sc.nextLine();
				System.out.print("나이: ");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.print("전화번호: ");
				String tel = sc.nextLine();
				System.out.print("주소: ");
				String address = sc.nextLine();
				System.out.print("비고: ");
				String somthing = sc.nextLine();
				Member member = new Member(name, gender, age, tel, address, somthing);
				break;

			case 2:
				System.out.println("회원 정보 수정");
				System.out.print("수정할 회원 이름: ");
				String nameToUpdate = sc.nextLine();
				manager.setMemberInfo(nameToUpdate);
				break;

			case 3:
				System.out.println("회원 삭제");
				System.out.print("삭제할 회원 이름: ");
				String nameToDelete = sc.nextLine();
				break;

			case 4:
				System.out.println("이름으로 회원 정보 검색");
				System.out.print("검색할 회원 이름: ");
				String nameToSearch = sc.nextLine();
				break;

			case 5:
				System.out.println("회원 목록");
				break;

			case 6:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;

			default:
				System.out.println("잘못된 선택입니다. 다시 시도하세요.");
			}
		}
	}

}
