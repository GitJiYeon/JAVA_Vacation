package vacation;

import java.util.HashMap;
import java.util.Scanner;

class Info {
    String Id;
    String Pw;

    Info(String id, String pw) {
        this.Id = id;
        this.Pw = pw;
    }
}

public class LoginEx {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Info> Login = new HashMap<>();
        
        while (true) {
            System.out.print("1.로그인 2.회원가입 3.종료: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID : ");
                    String id = sc.nextLine();
                    
                    Info info = Login.get(id);
                    if (info == null) {
                        System.out.println(id + "라는 아이디는 존재하지 않습니다.");
                        break;
                    }
                    
                    System.out.print("PW : ");
                    String pw = sc.nextLine();
                    
                    if (info.Pw.equals(pw)) {
                        System.out.println("로그인 성공");
                    } else {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                    }
                    break;

                case 2:
                    System.out.print("회원가입 ID: ");
                    String newId = sc.nextLine();
                    
                    if (Login.containsKey(newId)) {
                        System.out.println("이미 ID가 존재합니다.");
                        break;
                    }
                    
                    System.out.print("회원가입 PW: ");
                    String newPw = sc.nextLine();
                    Login.put(newId, new Info(newId, newPw));
                    System.out.println("회원가입 되었습니다.");
                    break;

                case 3:
                    System.out.println("종료");
                    return;

                default:
                    System.out.println("?");
                    break;
            }
        }
    }
}
