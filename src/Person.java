public class Person {
    public String name;
    public String surname;
    public String email;
    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname(){
        return  surname;
    }
    public  void setSurname(String surname){
        this.surname = surname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void print_info(){
        System.out.println("Name: " + name);
        System.out.println("Surname: "+ surname);
        System.out.println("Email: "+ email);
    }
}
