import java.io.FileWriter;
import java.io.IOException;
public class Ticket {
    public char row;
    public int seat;
    public double price;
    public Person person;

    public Ticket(char row, int seat, double price, Person person){
        this.row = row;
        this.seat =seat;
        this.price= price;
        this.person = person;
    }

    //Getters and Setters
    public char getRow() {
        return row;
    }
    public void setRow(char row){
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat){
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person){
        this.person = person;
    }

    public void print_Tickets_Information_and_Totalsales(){
        System.out.println("Row: "+row);
        System.out.println("Seat: "+seat);
        System.out.println("Price: "+price);
        System.out.println("Ticket Holder Information");
        person.print_info();
    }
    public void save() throws IOException{
        String file_Name = row + String.valueOf(seat) + ".txt";
        try {
            FileWriter writer = new FileWriter(file_Name);
            writer.write("Ticket Information\n");
            writer.write("Row: "+ row +"\n");
            writer.write("Seat: "+seat+"\n");
            writer.write("Price: "+ price +"\n");
            writer.write("Ticket Holder Information \n");
            writer.write("Name: " + person.getName() + "\n");
            writer.write("Surname: " +person.getSurname() + "\n");
            writer.write("Email: "+ person.getEmail() + "\n");
            writer.close();
            System.out.println("Ticket information saved to file: " + file_Name);
        }catch (IOException e){
            System.out.println("An error occurred while saving ticket information to file.");
            e.printStackTrace();
        }
    }
}
