
public class Employee {
    private String firstname;
    private String lastname;
    private double salary;
    private String department;

    public Employee(String firstname, String lastname, double salary, String department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return String.format("%s %s", firstname, lastname);
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }


    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    @Override
    public String toString(){
        return String.format("%-11s%-11s%-11.2f %11s%n", firstname, lastname, salary, department);
    }

}