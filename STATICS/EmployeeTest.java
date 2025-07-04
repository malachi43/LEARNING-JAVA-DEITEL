
public class EmployeeTest{
    public static void main(String[] args){
        System.out.println("Employees before instantiation: "+  Employee2.getCount());
        Employee2 malachi = new Employee2("Chibuike", "Uko");
        Employee2 mikey = new Employee2("Chinemerem", "Uko");
        Employee2 sarah = new Employee2("Chika", "Uko");
        System.out.println("Employees after instantiation: "+  Employee2.getCount());
    }
}