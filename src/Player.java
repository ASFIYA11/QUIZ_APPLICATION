import java.util.Scanner;

class Player {
    String name;
    int score = 0;

    void setPlayerDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age=scanner.nextInt();
        System.out.println("Enter the mailid");
        String mail=scanner.nextLine();
    }

    void displayPlayerDetails() {
        System.out.println("Player Name: " + name);
        System.out.println("Score: " + score);
    }
}