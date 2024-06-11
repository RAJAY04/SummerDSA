package StreamApi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Arrays.stream;

public class Main {
    //Streams operate using lazy evaluation, meaning that intermediate operations (like filter, map, etc.)
    // are not executed until a terminal operation (like collect, forEach, etc.) is invoked.
    static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(
                new Employee("Ajay","Prabhu",100000.0,List.of("Mental health","portfolio"))
        );
        employees.add(
                new Employee("vijay","Prabhu",50000.0,List.of("Mental","port"))
        );
        employees.add(
                new Employee("sujay","Prabhu",60000.0,List.of("health","folio"))
        );
    }
    public static void main(String[] args) {
        //employees.stream(). we are changing our collection object to stream, it provides us abstraction to work on
        //so after converting all operations we do will be on the stream and after the end we can get our data back in whatever format we need

        //forEach is a terminal operation , which means once we write forEach we cant do other operation after that
        employees.stream().
                forEach(employee -> System.out.println(employee));

        //map
        //collect
        List<Employee> increasedSalary = employees.stream()
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .collect(Collectors.toList());//if we end the operation here without collect () its just gonna return us stream.
        System.out.println(increasedSalary);


        //we can get set too or any other datatype
        Set<Employee> increasedSalarySet = employees.stream()
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .collect(Collectors.toSet());
        System.out.println(increasedSalarySet);

        //filter operation (like if else)
        //increase saslary of employee whole salary is greater than 50k


        //what is an intermediate operation? any method that returns stream itself.
        List<Employee> filteredEmployee = employees.stream()
                .filter(employee -> employee.getSalary() > 50000)
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .collect(Collectors.toList());

        System.out.println(filteredEmployee);

        //findFirst
        //finding the first employee in the stream with some condition
        Employee firstEmployee = employees.stream()
                .filter(employee -> employee.getSalary() > 500000)
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .findFirst()//this returns a optional return type, which means may or may not have value, so need to hadle it
                .orElse(null);

        System.out.println(firstEmployee);

        //flattenMap
        //say we have List<String> flattenMap returns String, or List<List<String>> returns List<String>
        String projects = employees.stream()//after this line we will be having stream of list of employees
                .map(employee -> employee.getProjects())//after this line we ll be having stream of list of projects
                .flatMap(strings -> strings.stream())
                .collect(Collectors.joining(","));
        System.out.println(projects);

        //short circuit operations
        List<Employee> shortCircuit = employees.stream()
                .skip(1)//skips first
                .limit(1)//after skipping 1, take just 1
                .collect(Collectors.toUnmodifiableList());
        System.out.println(shortCircuit);
        //say we are skipping and then apply limit, or filter, the filter will only work on the skipped,
        //i mean every line transforms data



        //limit can also be used to convert from infinite to finite data
        Stream.generate(Math::random)//generating random number
                .limit(5)
                .forEach(value -> System.out.println(value));



        //now sorting
        //we need to use comparators or comparable while sorting
        List<Employee> sortedEmployee = employees.stream()
                .sorted((o1,o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()))
                .collect(Collectors.toList());

        System.out.println(sortedEmployee);


        //getting min or max data
        employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);//can use min also



        //reduce, its used to accumulate everything. say accumulating salaries to sum variable
        Double sum = employees.stream()
                .map(employee -> employee.getSalary())
                .reduce(0.0,Double::sum);

        System.out.println(sum);

        //we can use parallelStream() too but make sure methods are threadsafe


        //read doccumentaions and implement on the go. stream api is hard initially but easy eventually

    }
}