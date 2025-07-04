
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ProcessingEmployees {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing")
        };

        System.out.printf("%nComplete Employee List:%n ");
        List<Employee> employeeList = Arrays.asList(employees);
        employeeList.stream().forEach(System.out::println);

        Predicate<Employee> fouroSixThousand = employee -> employee.getSalary() >= 4000 && employee.getSalary() <= 6000;

        System.out.println("Employees that earn between 4000 - 6000 thousand:");
        employeeList.
        stream()
        .filter(fouroSixThousand)
        .sorted(Comparator.comparing(Employee::getSalary))
        .forEach(System.out::println);

        System.out.println();
        System.out.println("Find first employee that earns between 4000 - 6000:");

        Optional<Employee> employee = Optional.of(employeeList
        .stream()
        .filter(fouroSixThousand)
        .findFirst()
        .get());

        employee.ifPresent(System.out::println);

       Function<Employee, String> byLastname = e -> e.getLastname(); //this works.
       Function<Employee, String> byFirstname = Employee::getFirstname; //this works too.

       //comparing employee by lastname, if both lastname are equal compare by firstname.
       Comparator<Employee> lastThenFirst = Comparator.comparing(byLastname).thenComparing(byFirstname);

       System.out.println("Comparing Employee by lastname then firstname (ascending):");
       employeeList
       .stream()
       .sorted(lastThenFirst)
       .forEach(System.out::println);

       System.out.println("Comparing Employee by lastname then firstname (descending):");
       employeeList
       .stream()
       .sorted(lastThenFirst.reversed())
       .forEach(System.out::println);

       System.out.println("Unique lastnames:");
       employeeList
       .stream()
       .map(Employee::getLastname)
       .distinct()
       .sorted()
       .forEach(System.out::println);

       System.out.println();

       System.out.println("Order by lastname then firstname:");
       employeeList
       .stream()
       .sorted(lastThenFirst)
       .map(Employee::getName)
       .forEach(System.out::println);

       Map<String, List<Employee>> groupByDepartment = employeeList
       .stream()
       .collect(Collectors.groupingBy(Employee::getDepartment));
        
       System.out.println();

        groupByDepartment
        .forEach((key,value)-> {
            int padding = "department".length() + 2; //the int 2 represent a space and a colon;
            int departmentCharacterCount = key.length() + padding;

            String divider = "";
            for(int i =0; i < departmentCharacterCount; i++){
                divider += "-";
            }

            System.out.printf("Department: %s%n", key);
            System.out.println(divider);
            value.forEach(System.out::println);
            System.out.println();
        });

        System.out.println("Return the number of employees in a department:");
        Map<String, Long> noOfEmployeesInADepartment = employeeList
        .stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        noOfEmployeesInADepartment.forEach((deparment, noOfEmployee)-> {
            System.out.printf("%n We have %d %s in %s department.%n", noOfEmployee, noOfEmployee > 1 ? "employees": "employee", deparment);
        });
        System.out.println();

        System.out.println("Calculating sum and average of employee Salaries:");
        double employeeTotalSalary = employeeList
        .stream()
        .mapToDouble(Employee::getSalary)
        .sum();

        System.out.println();
        System.out.printf("%-9s%n", "EMPLOYEE TOTAL SALARIES");
        System.out.println(generateDividerLine("EMPLOYEE TOTAL SALARIES"));
        System.out.printf("%s%-9.2f%n%n", "$",employeeTotalSalary );

        double averageEmployeeSalary = employeeList
        .stream()
        .mapToDouble(Employee::getSalary)
        .average()
        .getAsDouble();

        System.out.println();
        System.out.printf("%-9s%n", "EMPLOYEE AVERAGE SALARY");
        System.out.println(generateDividerLine("EMPLOYEE AVERAGE SALARY"));
        System.out.printf("%s%-9.2f%n%n", "$", averageEmployeeSalary);

        SecureRandom random = new SecureRandom();

        Map<Integer, Long> faceFrequency = random.ints(6_000_000, 1, 7)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println();
        System.out.printf("%-9s%-9s%n", "FACE", "FREQUENCY");
        System.out.println(generateDividerLine("FACE     FREQUENCY"));
        faceFrequency.forEach((face, frequency)-> {
            System.out.printf("%-9d%-9d%n", face, frequency);
        });
        System.out.println();

    }

    public static String generateDividerLine(String text){
        String divider = "";
        int wordLength = text.length();
        for(int i = 0; i < wordLength; i++){
           divider += "-";
        }
        return divider;
    }
}