package vacation;

import java.util.Scanner;

public class diceGame2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===========게임 시작===========");

        int player1 = 0;
        int player2 = 0;

        int number = 1; 
        for (int count = 1; count <= 4; count++) { 
            System.out.println("player" + number + "이 굴리기 (아무거나 입력)");
            sc.nextLine();

            int temp = (int) ((Math.random() * 6) + 1);
            System.out.println(temp + "!");
            
            if (number == 1) {
                player1 += temp;
                number = 2;
            } else {
                player2 += temp;
                number = 1;
            }
        }

        System.out.println("===========================");
        System.out.println("player1 합계 : " + player1 + "\nplayer2 합계 : " + player2);
        System.out.println("===========================");
        if (player1 > player2) {
            System.out.println("player1 승!");
        } else if (player1 < player2) {
            System.out.println("player2 승!");
        } else {
            System.out.print("무승부!");
        }
    }
}
