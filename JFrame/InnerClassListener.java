package JFrame;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InnerClassListener extends JFrame {
    public InnerClassListener() {
        setTitle("Action 이벤트 리스너 예제:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener()); // Action 리스너 달기
        c.add(btn);

        setSize(350, 150);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if (b.getText().equals("Action"))
                b.setText("액션");
            else
                b.setText("Action");

            // InnerClassListener의 멤버나 JFrame의 멤버를 호출할 수 있음
            InnerClassListener.this.setTitle(b.getText() + " 버튼의 작업을 출력한다.");
        }
    }

    public static void main(String[] args) {
        new InnerClassListener();
    }
}
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//public class AnonymousClassListener extends JFrame {
//    public AnonymousClassListener() {
//        setTitle("Action 이벤트 리스너 작성");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Container c = getContentPane();
//        c.setLayout(new FlowLayout());
//        JButton btn = new JButton("Action");
//        c.add(btn);
//
//        btn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                JButton b = (JButton)e.getSource();
//                if (b.getText().equals("Action"))
//                    b.setText("액션");
//                else
//                    b.setText("Action");
//                setTitle(b.getText());
//            }
//        });
//
//        setSize(350, 150);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new AnonymousClassListener();
//    }
//}
//
