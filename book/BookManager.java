package book;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class BookInfo {
    private String name;
    private String autor;
    private boolean borrow;

    BookInfo(String name, String autor) {
        this.name = name;
        this.autor = autor;
        this.borrow = false;
    }

    String getName() { return name; }
    String getAutor() { return autor; }
    boolean borrow() { return borrow; }

    void setAutor(String autor) {
        this.autor = autor;
    }

    void loanBook() {
    	borrow = true;
    }

    void returnBook() {
    	borrow = false;
    }
}

class BookManeger {
    ArrayList<BookInfo> books = new ArrayList<>();

    String addBook(BookInfo book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(book.getName())) {
                return "이미 있는 도서입니다.\n===============";
            }
        }
        books.add(book);
        return "등록 완료\n===============";
    }

    String delBook(String name) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                books.remove(i);
                return "삭제되었습니다.\n===============";
            }
        }
        return "없는 도서입니다.\n===============";
    }

    String showList() {
        if (books.isEmpty()) {
            return "등록된 도서가 없습니다.\n===============";
        }
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < books.size(); i++) {
            list.append(i + 1).append(". ")
                .append(books.get(i).getName() + ", 작가 : " + books.get(i).getAutor());
            if(books.get(i).borrow()) {
            	list.append(", 대출 불가X\n");
            }
            else {
            	list.append(", 대출 가능O\n");
            }
        }
        list.append("===============");
        return list.toString();
    }

    String upDate(String name, String newAutor) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                books.get(i).setAutor(newAutor);
                return "수정되었습니다.\n===============";
            }
        }
        return "없는 도서입니다.\n===============";
    }

    String loanBook(String name) {
    	for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                if (books.get(i).borrow()) {
                    return "이미 대출된 도서입니다.\n===============";
                } else {
                    books.get(i).loanBook();
                    return "대출 완료\n===============";
                }
            }
        }
        return "없는 도서입니다.\n===============";
    }

    String returnBook(String name) {
    	for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                if (!books.get(i).borrow()) {
                    return "대출되지 않은 도서입니다.\n===============";
                } else {
                    books.get(i).returnBook();
                    return "반납 완료\n===============";
                }
            }
        }
        return "없는 도서입니다.\n===============";
    }
}

public class BookManager {
    public static void main(String[] args) {
        BookManeger BM = new BookManeger();
        JFrame bookFrame = new JFrame("도서 관리");
        bookFrame.setSize(700, 600);
        bookFrame.setLayout(new BorderLayout());
        bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JTextField textBox = new JTextField(30);
        JTextArea logBox = new JTextArea(20, 50);
        logBox.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logBox);

        JButton addButton = new JButton("등록");
        JButton deleteButton = new JButton("삭제");
        JButton listButton = new JButton("목록");
        JButton updateButton = new JButton("수정");
        JButton borrowButton = new JButton("대출");
        JButton returnButton = new JButton("반납");
        JButton confirmButton = new JButton("확인");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(borrowButton);
        buttonPanel.add(returnButton);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(textBox, BorderLayout.CENTER);
        bookFrame.add(scrollPane, BorderLayout.CENTER);
        inputPanel.add(confirmButton, BorderLayout.EAST);

        bookFrame.add(buttonPanel, BorderLayout.NORTH);
        bookFrame.add(inputPanel, BorderLayout.SOUTH);
        
        Font font = new Font("맑은 고딕", Font.PLAIN, 20);
        textBox.setFont(font);
        logBox.setFont(font);
        

        StringBuilder currentAction = new StringBuilder();

        addButton.addActionListener(e -> {
            currentAction.setLength(0);
            currentAction.append("add");
            logBox.append("등록하려면 책 이름,저자 형식으로 입력하세요.\n");
        });
        deleteButton.addActionListener(e -> {
            currentAction.setLength(0);
            currentAction.append("delete");
            logBox.append("삭제하려면 책 이름을 입력하세요.\n");
        });
        listButton.addActionListener(e -> {
            logBox.append(BM.showList() + "\n");
        });
        updateButton.addActionListener(e -> {
            currentAction.setLength(0);
            currentAction.append("update");
            logBox.append("수정하려면 책 이름,새 저자 형식으로 입력하세요.\n");
        });
        borrowButton.addActionListener(e -> {
            currentAction.setLength(0);
            currentAction.append("borrow");
            logBox.append("대출하려면 책 이름을 입력하세요.\n");
        });
        returnButton.addActionListener(e -> {
            currentAction.setLength(0);
            currentAction.append("return");
            logBox.append("반납하려면 책 이름을 입력하세요.\n");
        });

        confirmButton.addActionListener(e -> {
            String input = textBox.getText().trim();

            switch (currentAction.toString()) {
                case "add":
                    String[] parts = input.split(",");
                    if (parts.length == 2) {
                        String name = parts[0].trim();
                        String autor = parts[1].trim();
                        logBox.append(BM.addBook(new BookInfo(name, autor)) + "\n");
                    } else {
                        logBox.append("책이름,저자 형식으로 입력하세요.\n");
                    }
                    break;
                case "delete":
                    logBox.append(BM.delBook(input) + "\n");
                    break;
                case "update":
                    String[] partsUpdate = input.split(",");
                    if (partsUpdate.length == 2) {
                        String name = partsUpdate[0].trim();
                        String newAutor = partsUpdate[1].trim();
                        logBox.append(BM.upDate(name, newAutor) + "\n");
                    } else {
                        logBox.append("책이름,새저자 형식으로 입력하세요.\n");
                    }
                    break;
                case "borrow":
                    logBox.append(BM.loanBook(input) + "\n");
                    break;
                case "return":
                    logBox.append(BM.returnBook(input) + "\n");
                    break;
                default:
                    logBox.append("시스템 버튼을 선택하세요.\n");
                    break;
            }
            textBox.setText("");
        });

        bookFrame.setVisible(true);
    }
}
