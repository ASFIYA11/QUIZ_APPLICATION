import java.util.Scanner;

class QuizGame {
    public static void main(String[] args) {
        Player player = new Player();
        player.setPlayerDetails();

        Quiz quiz = new Quiz();
        quiz.displayRules();

        // Define questions
        Question[] questions = {
            new Question(
                "What is the capital of France?",
                new String[] {"Berlin", "Madrid", "Paris", "Rome"},
                3 // Correct answer is "Paris"
            ),
            new Question(
                "What is the capital of India?",
                new String[] {"Delhi", "Chennai", "Pondicherry", "Bangalore"},
                1 // Correct answer is "Delhi"
            ),
            new Question(
                "Which planet is known as the Red Planet?",
                new String[] {"Earth", "Mars", "Jupiter", "Saturn"},
                2 // Correct answer is "Mars"
            ),
            new Question(
                "Who wrote 'Romeo and Juliet'?",
                new String[] {"William Wordsworth", "Charles Dickens", "William Shakespeare", "Mark Twain"},
                3 // Correct answer is "William Shakespeare"
            ),
            new Question(
                "What is the boiling point of water (in Celsius)?",
                new String[] {"90", "80", "100", "120"},
                3 // Correct answer is "100"
            ),
            new Question(
                "Which country is known as the Land of Rising Sun?",
                new String[] {"China", "Japan", "Thailand", "South Korea"},
                2 // Correct answer is "Japan"
            ),
            new Question(
                "Which is the smallest prime number?",
                new String[] {"1", "2", "3", "5"},
                2 // Correct answer is "2"
            ),
            new Question(
                "Who painted the Mona Lisa?",
                new String[] {"Vincent van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Claude Monet"},
                2 // Correct answer is "Leonardo da Vinci"
            ),
            new Question(
                "Which gas do plants absorb from the atmosphere?",
                new String[] {"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"},
                2 // Correct answer is "Carbon Dioxide"
            ),
            new Question(
                "What is the largest mammal in the world?",
                new String[] {"Elephant", "Blue Whale", "Giraffe", "Hippopotamus"},
                2 // Correct answer is "Blue Whale"
            )
        };

        Lifeline lifeline = new Lifeline();
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            question.displayQuestion();
            System.out.print("Enter your answer (1-4) or use lifeline (5): ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                lifeline.useFiftyFifty(question);
                System.out.print("Enter your answer (1-4): ");
                choice = scanner.nextInt();
            }

            if (choice == question.correctAnswer) {
                System.out.println("Correct! You win 10 points.");
                player.score += 10;
            } else {
                System.out.println("Wrong answer. Game over!");
                System.exit(0);
            }
        }

        player.displayPlayerDetails();
    }
}

class Player {
    String name;
    int score;

    void setPlayerDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        score = 0;
    }

    void displayPlayerDetails() {
        System.out.println("Player: " + name);
        System.out.println("Score: " + score);
    }
}

class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}

class Lifeline {
    boolean isFiftyFiftyUsed = false;

    void useFiftyFifty(Question question) {
        if (isFiftyFiftyUsed) {
            System.out.println("Fifty-Fifty lifeline has already been used.");
            return;
        }

        isFiftyFiftyUsed = true;

        System.out.println("Fifty-Fifty Lifeline used. Two options:");
        System.out.println(question.options[question.correctAnswer - 1]);
        for (int i = 0; i < question.options.length; i++) {
            if (i != question.correctAnswer - 1) {
                System.out.println(question.options[i]);
                break;
            }
        }
    }
}

