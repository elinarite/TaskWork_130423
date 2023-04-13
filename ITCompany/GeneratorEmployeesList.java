package TaskWorkHomework2.ITCompany;

import java.util.*;

public class GeneratorEmployeesList {
    /**
     * numberOfEmployer - entered by user via scanner
     */
    private static int numberOfEmployees;

    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    private static void setNumberOfEmployees(int numberOfEmployees) {
        GeneratorEmployeesList.numberOfEmployees = numberOfEmployees;
    }

    /**
     * method that reads through the scanner how many employees need to be created
     */
    private static void scanNumberOfEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter number of employee: ");
        GeneratorEmployeesList.setNumberOfEmployees(scanner.nextInt());
        scanner.close();
    }

    /**
     * adds generated employees to the list,
     * according to the specified number in the parameters
     *
     * @param numberOfEmployees - number of Employee
     * @return List with Employee
     */
    private static List<Employee> createEmployeeList(int numberOfEmployees) {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < numberOfEmployees; i++) {
            Employee employee = Generator.createRandomEmployee();
            employeeList.add(employee);
        }
        return employeeList;
    }

    /**
     * Sorts Employee by Name, Age and Salary,
     * on the basis of Comparable from the class Employee;
     */
    private static void sortEmployeesByPersonalData(List<Employee> employeeList) {
        Collections.sort(employeeList);
    }

    /**
     * method, which changes employee's wages based on rating
     */
    private static List<Employee> recalculateSalaries(List<Employee> employeeList) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getRating().getRatingScore() == 0) {
            } else {
                employee.setSalary(employee.getSalary() * employee.getRating().getRatingScore());
            }
        }
        return employeeList;
    }

    /**
     * sorts employees by rating
     */

    private static List<Employee> sortByRating(List<Employee> employeeList) {
        employeeList.sort(new ComparatorRating());
        return employeeList;
    }

    /**
     * Method for print:
     * params:  scanNumberOfEmployee() - method that reads through the scanner how many employees need to be created
     * params: employeeListBeforeSalaryBonus - create a temporary variable to which we add a list of generated employees,
     * params: sortEmployeesByPersonalData() - Sorts Employee by Name, Age and Salary,
     * params: System.out.println(employeeListBeforeSalaryBonus); - displays a list of employees
     * params: employeeListAfterSalaryBonus - create a temporary variable to which we add a list of generated employees,
     * params: which sorts by rating and adds a bonus to the salary.
     * params: System.out.println(employeeListAfterSalaryBonus) - displays a list of employees with new salary
     */
    public static void print() {
        scanNumberOfEmployee();
        List<Employee> employeeListBeforeSalaryBonus = createEmployeeList(getNumberOfEmployees());
        sortEmployeesByPersonalData(employeeListBeforeSalaryBonus);
        System.out.println("-----List of employees where sorts by name, age and salary------- ");
        System.out.println(employeeListBeforeSalaryBonus);
        System.out.println("-----List of employees where the salary was calculated based and sorts on the rating------- ");
        System.out.println();
        Object employeeListAfterSalaryBonus = recalculateSalaries(sortByRating(employeeListBeforeSalaryBonus));
        System.out.println(employeeListAfterSalaryBonus);
    }
}