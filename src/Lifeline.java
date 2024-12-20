class Lifeline {
    boolean fiftyFiftyUsed = false;
    boolean skipUsed = false;

    void useFiftyFifty(Question question) {
        if (!fiftyFiftyUsed) {
            fiftyFiftyUsed = true;
            System.out.println("50-50 Lifeline used!");
            // Logic to remove 2 wrong options
        } else {
            System.out.println("50-50 Lifeline already used.");
        }
    }

    void useSkip() {
        if (!skipUsed) {
            skipUsed = true;
            System.out.println("Skip Question Lifeline used!");
            // Logic to skip question
        } else {
            System.out.println("Skip Question Lifeline already used.");
        }
    }
}