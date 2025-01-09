package vacation;

import java.util.Scanner;

public class GuessingGame {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("====숫자 맞추기=====");
		boolean gameEnd = false;
		int answer = (int) ((Math.random() * 100) + 1);
		int count = 0;
		do {
			System.out.print("1 ~ 100 입력 : ");
			int temp = sc.nextInt();
			if (temp > 100 || temp < 1) {
				System.out.println("올바른 범위의 수를 입력하세요");
				continue;
			}

			count++;
			if (temp > answer) {
				System.out.println("더 작은 수를 입력하세요");
			} else if (temp < answer) {
				System.out.println("더 큰 수를 입력하세요");
			} else {
				System.out.print("==============\n" + count + "번만에 정답!");
				System.out.print("\nRETRY?  1.yes 2.no : ");
				if (sc.nextInt() == 1) {
					answer = (int) ((Math.random() * 100) + 1);
					count = 0;
				} else {

					gameEnd = !gameEnd;
				}
			}
		} while (!gameEnd);
	}
}

