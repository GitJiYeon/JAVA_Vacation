package vacation;

import java.util.Scanner;

public class rate {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.원 > 달러\n2.원 > 엔화");
		if(sc.nextInt() == 1) {
			System.out.print("(원)입력 :");
			int koreanMoney = sc.nextInt();
			System.out.print("달러 환율 입력 :");
			double USAMoney = sc.nextInt();
			System.out.println(koreanMoney/(USAMoney*0.001)+"달러");
		}else {
			System.out.print("(원)입력 :");
			int koreanMoney = sc.nextInt();
			System.out.print("엔화 환율 입력 :");
			double USAMoney = sc.nextInt();
			System.out.println(koreanMoney/(USAMoney*0.001)+"엔");
		}
		

	}
}
