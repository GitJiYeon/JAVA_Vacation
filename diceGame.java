package vacation;

import java.util.Scanner;

class infomation {
    private int life;
    private int score;
    private String playerName;

    infomation(String name) {
        this.life = 10;
        this.score = 0;
        this.playerName = name;
        print();
    }

    public void print() {
        System.out.println("Life : " + life + "\tScore : " + score + "\n====================");
    }

    int getLife() {
        return this.life;
    }

    int getScore() {
        return this.score;
    }

    String getName() {
        return this.playerName;
    }

    void setLife() {
        this.life--;
    }

    void setScore() {
        this.score += 10;
    }
}

class dice {
    private int computer;
    private int player;
    private infomation Info;

    public dice(infomation info) {
        this.Info = info;
        rollDice();
        print();
    }

    private void rollDice() {
        this.computer = (int) ((Math.random() * 6) + 1);
        this.player = (int) ((Math.random() * 6) + 1);
    }

    void print() {
        System.out.println("\ncomputer : " + computer + "\n" + Info.getName() + " : " + player + "\n");
        result();
    }

    void result() {
        if (player > computer) {
            System.out.println(Info.getName() + "승!\tScore +10\n====================");
            Info.setScore();
        } else if (player == computer) {
            System.out.println("비겼습니다\n====================");
        } else {
            System.out.println("computer승!\tLife -1\n====================");
            Info.setLife();
        }
        Info.print();
    }

    int End() {
        if (Info.getLife() < 1) {
            return 0;
        } else if (Info.getScore() > 99) {
            return 1;
        }
        return 2;
    }
}

public class diceGame {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("닉네임 입력 : ");
        String name = sc.nextLine();
        infomation Info = new infomation(name);
        System.out.println("=======게임 시작=======");
        int still = 0;
        while (still == 0) {
            dice Dice = new dice(Info);
            switch (Dice.End()) {
                case 0:
                    System.out.println("패배, 게임 종료");
                    still++;
                    break;
                case 1:
                    System.out.println("승리, 게임 종료");
                    still++;
                    break;
                case 2:
                    System.out.println("다시 하시겠습니까? y / n");
                    if (sc.nextLine().equals("n")) {
                        still++;
                        break;
                    }
            }
            
        }
    }
}
