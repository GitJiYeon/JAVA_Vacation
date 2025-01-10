package book;

import java.util.ArrayList;
import java.util.Scanner;

class BookInfo {
    private String name;
    private String autor;

    BookInfo(String name, String autor) {
        this.name = name;
        this.autor = autor;
    }

    String getName() { return name; }
    String getAutor() { return autor; }

    void setAutor(String autor) {
        this.autor = autor;
    }
}

class BookManeger {
    ArrayList<BookInfo> books = new ArrayList<>();
    
    void addBook(BookInfo book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(book.getName())) {
                System.out.println("이미 있는 도서입니다.");
                return;
            }
        }
        books.add(book);
        System.out.println("등록 완료");
    }

    void delBook(String name) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                books.remove(i);
                System.out.println("삭제되었습니다.");
                return;
            }
        }
        System.out.println("없는 도서입니다.");
    }

    void showList() {
        if (books.isEmpty()) {
            System.out.println("등록된 도서가 없습니다.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + 1 + ". " + books.get(i).getName() + " (저자: " + books.get(i).getAutor() + ")");
        }
    }

    void upDate(String name, String newAutor) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                books.get(i).setAutor(newAutor);
                System.out.println("수정되었습니다.");
                return;
            }
        }
        System.out.println("없는 도서입니다.");
    }
}

public class bookMain {
    public static void main(String args[]) {
        BookManeger BM = new BookManeger();
        Scanner sc = new Scanner(System.in);
        System.out.println("=======도서 관리=======");
        while (true) {
            System.out.println("1.등록, 2.삭제 3.목록 4.수정 5.종료");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("====================");
                    System.out.print("책 이름 : ");
                    String name = sc.nextLine();
                    System.out.print("저자 : ");
                    String autor = sc.nextLine();
                    BM.addBook(new BookInfo(name, autor));
                    break;
                case 2:
                    System.out.println("====================");
                    System.out.print("책 이름 : ");
                    BM.delBook(sc.nextLine());
                    break;
                case 3:
                    System.out.println("====================");
                    BM.showList();
                    break;
                case 4:
                    System.out.println("====================");
                    System.out.print("수정할 책 이름 : ");
                    String bookName = sc.nextLine();
                    System.out.print("새 저자 : ");
                    String newAutor = sc.nextLine();
                    BM.upDate(bookName, newAutor);
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
