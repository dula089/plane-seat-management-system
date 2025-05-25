
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class _20231280_w2052016_Planemanagement {
    public static char[][] seats;
    public static Scanner scanner= new Scanner(System.in);
    public static Ticket[] tickets=new Ticket[52]; //Array to store sold tickets
    public static int ticketIndex = 0;//Index to keep track of the next available position in the ticket array
    public static void main (String [] args){
        System.out.println("Welcome to the Plane Management Application.");
        initialize_Seats();

        char option;
        do {
            System.out.println("*****************************************************");
            System.out.println("*                   MENU OPTIONS                    *");
            System.out.println("*****************************************************");
            System.out.println("         1) Buy a seat");
            System.out.println("         2) Cancel a seat");
            System.out.println("         3) Find first available seat");
            System.out.println("         4) Show seating plan");
            System.out.println("         5) Print tickets information and total sales");
            System.out.println("         6) Search ticket");
            System.out.println("         0) Exit");
            System.out.println("*****************************************************");
            System.out.print("Please select an option: ");
            option =scanner.next().charAt(0);
            scanner.nextLine(); //consume newline character

            //Switch statement to handle user-selected options in a menu
            switch (option){
                case'1':
                    buy_Seat();
                    break;
                case '2':
                    cancel_Seat();
                    break;
                case '3':
                    find_First_Available();
                    break;
                case '4':
                    show_Seating_Plan();
                    break;
                case '5':
                    print_Tickets_Information_and_Totalsales();
                    break;
                case '6':
                    search_Ticket();
                    break;
                case '0':
                    System.out.println("Exiting program....");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while (option!='0');

    }

    //initialize the seats
    public static void initialize_Seats(){
        seats= new char[][]{
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O'}
        };
    }

    //method buy_seat that asks the user to input a row letter and a seat number.
    public static void buy_Seat() {
        //ask to enter a row
        System.out.print("Enter row(A/B/C/D): ");
        char row = scanner.next().toUpperCase().charAt(0);

        //validate rows(if user input a number or character greater than D)
        if (row < 'A' || row > 'D') {
            System.out.println("Invalid row.Please try again.");
            return;
        }

        //ask to enter a seat number and validate
        int seat_number=0;
        boolean validSeatNUmber=false;
        while (!validSeatNUmber){
            try {
                System.out.print("Enter seat number: ");
                seat_number = scanner.nextInt();
                validSeatNUmber =true;
            }catch (InputMismatchException e){
                System.out.println("Invalid input.Please enter a valid number.");
                scanner.next();
            }
        }


        //validate seat number(if user input a letter or a number greater than seat count)
        if (seat_number < 1 || seat_number > seats[row - 'A'].length) {
            System.out.println("Invalid seat number.Enter a number between 1-14.Please try again.");
            return;
        }
        //check if the seat is available
        if (seats[row - 'A'][seat_number - 1] == 'X') {
            System.out.println("Seat is already booked.Please choose another seat.");
            return;
        }
        scanner.nextLine();


        String name;
        while (true){
            //validate name
            System.out.print("Enter your name: ");
            name = scanner.nextLine();

            //Enter passenger name
            if (name.isEmpty()) {
                System.out.println("Please enter your name.");
                continue;
            }
            break;

        }


        String surname;
        while (true){
            //Enter passenger surname
            System.out.print("Enter your surname: ");
            surname = scanner.nextLine();

            //validate surname
            if (surname.isEmpty()) {
                System.out.println("Please enter your surname.");
                continue;
            }
            break;

        }


        String email;
        while (true) {
            //Enter passenger email
            System.out.print("Enter your email: ");
            email = scanner.next();

            //validate email, if there is no '@' contains in input
            if (!email.contains("@")) {
                System.out.println("Invalid email.Enter a valid email.");
                continue;
            }
            //validate email, if there is no '.' contains in input
            if (!email.contains(".")) {
                System.out.println("Invalid.Check again.");
                continue;
            }
            break;

        }
        //record the seat as sold
        seats[row - 'A'][seat_number - 1] = 'X';

        //create a ticket and store it
        Person person = new Person(name, surname, email);
        double price = getPrice(seat_number);
        Ticket ticket = new Ticket(row, seat_number, price, person);
        tickets[ticketIndex++] = ticket;

        System.out.println("Seat successfully booked.");

        //to save the ticket information
        try {
            ticket.save();
        }catch (IOException e){
            System.out.println("Error saving ticket information to the file.");
        }
    }


    //calculate the price of the tickets
    public static double getPrice(int seat_number){
        if (seat_number >= 1 && seat_number <= 5){
            return 200.00;
        } else if (seat_number >= 6 && seat_number <= 9) {
            return 150.00;
        }
        else {
            return 180.00;
        }
    }

    //canceling a booked seat
    public static void cancel_Seat(){
        //Enter row
        System.out.print("Enter row(A/B/C/D): ");
        char row = scanner.next().toUpperCase().charAt(0);

        //validate rows
        if (row < 'A' || row > 'D'){
            System.out.println("Invalid row.");
            return;
        }
        //enter seat number and validate the seat number
        int seat_number=0;
        boolean validSeatNUmber=false;
        while (!validSeatNUmber){
            try {
                System.out.print("Enter seat number: ");
                seat_number = scanner.nextInt();
                if (seat_number >=1 && seat_number <= seats[row -'A'].length) {
                    validSeatNUmber = true;
                }else {
                    System.out.println("Invalid seat number. Please enter a valid number.");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input.Please enter a valid number.");
                scanner.next();
            }
        }

        //validate seat number
        if (seat_number > seats[row - 'A'].length){
            System.out.println("Invalid seat number.");
            return;
        }
        //check if the seat is already available
        if (seats[row - 'A'][seat_number -1] == '0'){
            System.out.println("Seat is already available.");
            return;
        }

        //mark the seat as available
        seats[row - 'A'][seat_number-1]='0';

        //remove ticket from array
        for (int i = 0; i < ticketIndex; i++){
            if (tickets[i].getRow()== row && tickets [i].getSeat() == seat_number){
                tickets[i] = null;
                break;
            }
        }
        //display the seat cancelled
        System.out.println("Seat successfully cancelled.");
    }

    //check firstly available seats
    public static void find_First_Available(){
        for (int i= 0; i< seats.length; i++){
            for(int j=0; j< seats[i].length; j++){
                if (seats[i][j]=='0'){
                    //display the available seat
                    System.out.println("First Available seat: " + (char)('A'+i)+(j+1));
                    return;
                }
            }
        }
        //if there is no seat available display as no available seats
        System.out.println("No available seats.");
    }

    //showing the seating plan
    public  static void show_Seating_Plan(){
        for (char[] seat : seats){
            int j = 0;
            while (j<seat.length){
                System.out.print(seat[j]+" ");
                j++;
            }
            System.out.println();
        }
    }

    //printing the ticket information and total sales of tickets
    public static void print_Tickets_Information_and_Totalsales(){
        double total_sales =0;
        //display as tickets information
        System.out.println("Tickets Information");
        for (int i = 0; i < ticketIndex; i++){
            tickets[i].print_Tickets_Information_and_Totalsales();
            total_sales += tickets[i].getPrice();
        }
        //calculate the total sales and display it
        System.out.println("Total Sales: £" + total_sales);

    }
    //method for search tickets
    public static void search_Ticket(){
        System.out.print("Enter row(A/B/C/D): ");//ask to enter a row
        char row = scanner.next().toUpperCase().charAt(0);

        //validate row
        if (row < 'A' || row > 'D'){
            System.out.println("Invalid row.");
            return;
        }

        //enter seat number and validate seat number
        int seat_number=0;
        boolean validSeatNUmber=false;
        while (!validSeatNUmber){
            try {
                System.out.print("Enter seat number: ");
                seat_number = scanner.nextInt();
                validSeatNUmber =true;
            }catch (InputMismatchException e){
                System.out.println("Invalid input.Please enter a valid number between 1-14.");
                scanner.next();
            }
        }

        //find a matching ticket by row and seat number
        boolean found= false;
        for (int i = 0; i< ticketIndex; i++){
            if (tickets[i] != null && tickets [i] .getRow() == row && tickets[i].getSeat() == seat_number){
                found = true;
                System.out.println("Ticket found:");
                tickets[i].print_Tickets_Information_and_Totalsales();
                break;
            }
        }
        //if there is no existing ticket found, display no ticket found
        if(!found){
            System.out.println("No ticket found for this seat.");
        }
    }
}