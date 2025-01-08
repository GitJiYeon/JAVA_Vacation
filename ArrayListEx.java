package vacation;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> StringList= new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			System.out.print("이름 입력 : ");
			StringList.add(sc.nextLine());
		}
		int maxLengthIndex = 0;
		for(int i = 0; i < StringList.size(); i++) {
			for(int j = i+1; j < StringList.size(); j++) {
				if(StringList.get(i).length() > StringList.get(j).length()) {
					maxLengthIndex = i;
				}
			}
		}
		System.out.println("가장 긴 이름 : " + StringList.get(maxLengthIndex));
	}
}
