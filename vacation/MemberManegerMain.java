package vacation;

import java.util.ArrayList;
import java.util.Scanner;

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
				System.out.println("==============\n"+"회원 등록");
				System.out.print("이름: ");
				String name = sc.nextLine();
				System.out.print("성별: ");
				String gender = sc.nextLine();
				int age = 0;
				while (true) {
					try {
						System.out.print("나이: ");
						age = Integer.parseInt(sc.nextLine());
						break;
					} catch (NumberFormatException e) {
						System.out.println("숫자를 입력하세요");
					}
				}
				System.out.print("전화번호: ");
				String tel = sc.nextLine();
				System.out.print("주소: ");
				String address = sc.nextLine();
				System.out.print("비고: ");
				String somthing = sc.nextLine();
				MemberInfo member = new MemberInfo(name, gender, age, tel, address, somthing);
				manager.addMember(member);
				break;

			case 2:
				System.out.println("==============\n"+"회원 정보 수정");
				System.out.print("수정할 회원 이름: ");
				manager.setMemberInfo(sc.nextLine());
				break;

			case 3:
				System.out.println("==============\n회원 삭제");
				System.out.print("삭제할 회원 이름: ");
				manager.deleteMember(sc.nextLine());
				break;

			case 4:
				System.out.println("==============\n이름으로 회원 정보 검색");
				System.out.print("검색할 회원 이름: ");
				manager.findMember(sc.nextLine());
				break;

			case 5:
				manager.nameListPrint();
				break;

			case 6:
				System.out.println("프로그램 종료");
				sc.close();
				return;

			default:
				System.out.println("잘못된 선택입니다.");
			}
		}
	}
}

class MemberInfo {
	private String name;
	private String gender;
	private int age;
	private String tel;
	private String address;
	private String somthing;

	MemberInfo(String name, String gender, int age, String tel, String address, String somthing) {
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
	String getSomthing() { return somthing; }
	
	void setName(String name) { this.name = name; }
	void setGender(String gender) { this.gender = gender; }
	void setAge(int age) { this.age = age; }
	void setTel(String tel) { this.tel = tel; }
	void setAddress(String address) { this.address = address; }
	void setSomthing(String somthing) { this.somthing = somthing; }
}

class MemberManegement {
	Scanner sc = new Scanner(System.in);
	ArrayList<MemberInfo> members = new ArrayList<>();

	void addMember(MemberInfo member) {
		members.add(member);
		System.out.println("등록 완료\n==============");
	}

	void deleteMember(String name) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(name)) {
				members.remove(i);
				System.out.println("삭제 완료\n==============");
				return;
			}
		}
		System.out.println("없는 회원입니다.\n==============");
	}

	void findMember(String name) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(name)) {
				System.out.println("회원 정보");
				System.out.println("이름: " + members.get(i).getName());
				System.out.println("성별: " + members.get(i).getGender());
				System.out.println("나이: " + members.get(i).getAge());
				System.out.println("전화번호: " + members.get(i).getTel());
				System.out.println("주소: " + members.get(i).getAddress());
				System.out.println("비고: " + members.get(i).getSomthing()+"\n==============");
				return;
			}
		}
		System.out.println("없는 회원입니다.\n==============");
	}

	void nameListPrint() {
		System.out.println("==============\n회원 목록");
		for (int i = 0; i < members.size(); i++) {
			System.out.println(i+1 +". "+members.get(i).getName());
		}
		System.out.println("==============");
	}

	void setMemberInfo(String name) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(name)) {

				System.out.println("==============\n"+"어떤 정보를 수정하시겠습니까?\n1.이름 2.성별 3.나이 4.전화번호 5.주소 6.비고 7.취소");
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
					while (true) {
						System.out.println("새 나이 : ");
						try {
							members.get(i).setAge(Integer.valueOf(sc.nextLine()));
							break;
						} catch (NumberFormatException e) {
							System.out.println("숫자를 입력하세요.");
						}
					}
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
				case 7:
					return;
				default:
					System.out.println("잘못된 선택입니다."+"\n==============");
					return;
				}

				System.out.println("수정 완료!"+"\n==============");
				return;
			}
		}
		System.out.println("없는 회원입니다."+"\n==============");
	}
}

