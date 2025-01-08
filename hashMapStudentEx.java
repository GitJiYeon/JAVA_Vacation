package vacation;

import java.util.*;

class StudentId {
    int id;
    String tel;

    public StudentId(int id, String tel) {
        this.id = id;
        this.tel = tel;
    }
}

public class hashMapStudentEx {
    public static void main(String[] args) {
        // 학생 이름과 StudentId 객체를 쌍으로 저장하는 HashMap 컬렉션 생성
        HashMap<String, StudentId> map = new HashMap<String, StudentId>();

        // 3명의 학생 저장
        map.put("황기태", new StudentId(1, "010-111-1111"));
        map.put("이재문", new StudentId(2, "010-222-2222"));
        map.put("김남윤", new StudentId(3, "010-333-3333"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("검색할 이름? ");
            String name = scanner.nextLine(); // 사용자로부터 이름 입력
            if (name.equals("종료")) {
                System.out.println("프로그램을 종료합니다...");
                break; // while 문을 벗어나 프로그램 종료
            }

            StudentId studentId = map.get(name); // 이름에 해당하는 StudentId 객체 검색
            if (studentId == null) {
                System.out.println(name + "은 없는 사람입니다.");
            } else {
                System.out.println("id: " + studentId.id + ", 전화: " + studentId.tel);
            }
        }
        scanner.close();
    }
}
