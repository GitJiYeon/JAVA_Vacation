package JFrame;

import javax.swing.JFrame;

	public class MyFrame extends JFrame {
	    public MyFrame() {
	        setTitle("300x300 스윙 프레임 만들기");
	        setSize(300,300); // 프레임 크기 300x300
	        setVisible(true); // 프레임 출력
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    public static void main(String[] args) {
	        MyFrame frame = new MyFrame();
	    }
	}