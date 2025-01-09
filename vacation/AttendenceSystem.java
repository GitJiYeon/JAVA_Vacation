package vacation;

import java.util.ArrayList;
import java.util.Scanner;

// 학생 클래스
class Student {
	private String name;
	private boolean isPresent;

	public Student(String name) {
		this.name = name;
		this.isPresent = false; // 초기상태 결석
	}

	public String getName() {
		return name;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void markPresent() {
		this.isPresent = true;
	}

	public void markAbsent() {
		this.isPresent = false;
	}
}

class AttendanceManager {
	private ArrayList<Student> students;

	public AttendanceManager() {
		students = new ArrayList<>();
	}

	void addStudent(String name) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(name)) {
				System.out.println("이미 등록되어있는 학생입니다");
				return;
			}
		}
		students.add(new Student(name));
		System.out.println(name + " 학생 등록 완료");
	}

	void StudentList() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println(i + 1 + ". " + students.get(i).getName());
		}
	}

	void Present(String name) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(name)) {
				if (students.get(i).isPresent()) {
					students.get(i).markAbsent();
					System.out.println("결석처리 되었습니다.");
				} else {
					students.get(i).markPresent();
					System.out.println("출석처리 되었습니다.");
				}
			}
		}

	}

	void presentList() {
		for (int i = 0; i < students.size(); i++) {
			System.out.print(i + 1 + ". " + students.get(i).getName() + " ");
			if (students.get(i).isPresent()) {
				System.out.println("출석");
			} else {
				System.out.println("결석");
			}

		}
	}
}

public class AttendenceSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AttendanceManager manager = new AttendanceManager();
		while (true) {
			System.out.println("======== 출석 관리 프로그램 ========");
			System.out.println("1.등록 2.목록 3.출결처리 4.출석현황 5.종료");
			System.out.print("선택: ");

			switch (sc.nextInt()) {

			case 1:
				sc.nextLine();
				System.out.print("등록할 학생 : ");
				String name1 = sc.nextLine();
				manager.addStudent(name1);
				break;
			case 2:
				manager.StudentList();
				break;
			case 3:
				sc.nextLine();
				System.out.print("학생 : ");
				String name3 = sc.nextLine();
				manager.Present(name3);
				break;
			case 4:
				manager.presentList();
				break;
			case 5:
				System.out.println("종료");

				return;
			default:
				System.out.println("올바른 번호 입력");
			}
		}
	}
}
