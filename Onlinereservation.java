import java.util.HashMap;
		import java.util.Map;
		import java.util.Scanner;


		

		class User {
		    private String loginId;
		    private String password;

		    public User(String loginId, String password) {
		        this.loginId = loginId;
		        this.password = password;
		    }

		    public String getLoginId() {
		        return loginId;
		    }

		    public String getPassword() {
		        return password;
		    }
		}

		class Reservation {
		    private String trainNumber;
		    private String trainName;
		    private String dateOfJourney;
		    private String source;
		    private String destination;

		    public Reservation(String trainNumber, String trainName, String dateOfJourney, String source, String destination) {
		        this.trainNumber = trainNumber;
		        this.trainName = trainName;
		        this.dateOfJourney = dateOfJourney;
		        this.source = source;
		        this.destination = destination;
		    }

		    // Getters and setters for Reservation attributes
		    // ...

		    @Override
		    public String toString() {
		        return "Train Number: " + trainNumber + "\n" +
		               "Train Name: " + trainName + "\n" +
		               "Date of Journey: " + dateOfJourney + "\n" +
		               "Source: " + source + "\n" +
		               "Destination: " + destination + "\n";
		    }
		}

		public class Onlinereservation {
		    private static Map<String, User> users = new HashMap<>();
		    private static Map<String, Reservation> reservations = new HashMap<>();

		    public static void main(String[] args) {
		        // Sample user and reservation data
		        users.put("user1", new User("user1", "password1"));
		        reservations.put("PNR123", new Reservation("123", "Sample Train", "2023-08-02", "Place A", "Place B"));

		        // Login Form
		        Scanner scanner = new Scanner(System.in);
		        System.out.print("Enter Login ID: ");
		        String loginId = scanner.nextLine();
		        System.out.print("Enter Password: ");
		        String password = scanner.nextLine();

		        if (login(loginId, password)) {
		            System.out.println("Login successful!");

		            // Reservation System
		            System.out.print("Enter Train Number: ");
		            String trainNumber = scanner.nextLine();
		            System.out.print("Enter Train Name: ");
		            String trainName = scanner.nextLine();
		            System.out.print("Enter Date of Journey: ");
		            String dateOfJourney = scanner.nextLine();
		            System.out.print("Enter Source: ");
		            String source = scanner.nextLine();
		            System.out.print("Enter Destination: ");
		            String destination = scanner.nextLine();

		            Reservation reservation = new Reservation(trainNumber, trainName, dateOfJourney, source, destination);
		            reservations.put("PNR" + (reservations.size() + 1), reservation);
		            System.out.println("Reservation successful! PNR number: PNR" + (reservations.size()));

		            // Cancellation Form
		            System.out.print("Enter PNR Number to Cancel: ");
		            String pnrNumber = scanner.nextLine();
		            Reservation cancelledReservation = reservations.remove(pnrNumber);
		            if (cancelledReservation != null) {
		                System.out.println("Reservation with PNR number " + pnrNumber + " has been cancelled.");
		            } else {
		                System.out.println("PNR number " + pnrNumber + " not found. Cancellation failed.");
		            }
		        } else {
		            System.out.println("Invalid login credentials. Please try again.");
		        }
		    }

		    private static boolean login(String loginId, String password) {
		        User user = users.get(loginId);
		        return user != null && user.getPassword().equals(password);
		    }
		

	}

