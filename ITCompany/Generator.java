package TaskWorkHomework2.ITCompany;

import java.util.Random;

public class Generator {

    static Random random = new Random();
    /**
     * method, which generates name of employee
     */
    public static StringBuilder nameGeneration() {
        String abc = "abcdefghijklmnoprstuvz";

        int generationEmployeeNameLength = (random.nextInt(10) + 3);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < generationEmployeeNameLength; i++) {
            stringBuilder.append(abc.charAt(random.nextInt(abc.length())));
        }
        return stringBuilder;
    }

    /**
     * method, which generates employees
     */
    public static Employee createRandomEmployee() {
        String name = String.valueOf(nameGeneration());
        int minAge = 18;
        int maxAge = 60;
        double minSalary = 2000;
        double maxSalary = 10000;
        int age = random.nextInt(maxAge) + minAge;
        double salary = random.nextDouble(maxSalary) + minSalary;
        Rating rating = Rating.values()[random.nextInt(Rating.values().length)];
        Department department = Department.values()[random.nextInt(Department.values().length)];
        return new Employee(name, age, salary, rating, department);
    }
}