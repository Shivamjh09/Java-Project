
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    // Add more user profile information if needed

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters for user profile information
    // ...

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Question {
    private String question;
    private Map<Integer, String> options;
    private int correctOption;

    public Question(String question, Map<Integer, String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Getters and setters for question attributes
    // ...

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOption;
    }
}

class Examination {
    private Map<Integer, Question> questions;
    private int timer; // In seconds

    public Examination(Map<Integer, Question> questions, int timer) {
        this.questions = questions;
        this.timer = timer;
    }

    // Getters and setters for examination attributes
    // ...

    public int getTotalQuestions() {
        return questions.size();
    }

    public boolean isValidQuestionNumber(int questionNumber) {
        return questionNumber >= 1 && questionNumber <= questions.size();
    }

    public boolean isCorrectAnswer(int questionNumber, int selectedOption) {
        Question question = questions.get(questionNumber);
        if (question != null) {
            return question.isCorrect(selectedOption);
        }
        return false;
    }
}

public class OnlineExamination {
    private static Map<String, User> users = new HashMap<>();
    private static Examination examination;

    public static void main(String[] args) {
        // Sample user data
        users.put("user1", new User("user1", "password1"));

        // Sample questions data
        Map<Integer, String> options1 = new HashMap<>();
        options1.put(1, "Option A");
        options1.put(2, "Option B");
        options1.put(3, "Option C");
        options1.put(4, "Option D");
        Question question1 = new Question("What is 2 + 2?", options1, 3);

        // Add more questions as needed
        // ...

        Map<Integer, Question> questions = new HashMap<>();
        questions.put(1, question1);

        examination = new Examination(questions, 60); // 60 seconds timer for each question

        // Start the Online Examination
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Examination!");

        if (login(scanner)) {
            System.out.println("Login successful!");
            // Update Profile and Password
            // ...

            // Start the Examination
            startExamination(scanner);

            // Closing Session and Logout
            logout();
        } else {
            System.out.println("Invalid login credentials. Please try again.");
        }
        scanner.close();
    }

    private static boolean login(Scanner scanner) {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    private static void startExamination(Scanner scanner) {
        System.out.println("Starting the Examination...");

        for (int questionNumber = 1; questionNumber <= examination.getTotalQuestions(); questionNumber++) {
            if (!examination.isValidQuestionNumber(questionNumber)) {
                System.out.println("Invalid question number. Exiting the examination.");
                return;
            }

            Question question = examination.getQuestions().get(questionNumber);
            System.out.println("Question " + questionNumber + ": " + question.getQuestion());

            for (Map.Entry<Integer, String> entry : question.getOptions().entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }

            System.out.print("Select your answer (1-4): ");
            int selectedOption = scanner.nextInt();

            if (examination.isCorrectAnswer(questionNumber, selectedOption)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }

            // Timer delay (simulation of auto-submit after timer)
            try {
                Thread.sleep(examination.getTimer() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void logout() {
        System.out.println("Closing the session and logging out.");
        System.out.println("Thank you for participating in the Online Examination!");
    }
}