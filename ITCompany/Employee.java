package TaskWorkHomework2.ITCompany;

public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private double salary;
    private Rating rating;
    Department department;

    public Employee(String name, int age, double salary, Rating rating, Department department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.rating = rating;
        this.department = department;
    }

    /**
     * comparator, which sorts by name, age and salary
     * @param employee the object to be compared.
     */
    @Override
    public int compareTo(Employee employee) {
        if (this.name.compareTo(employee.getName()) != 0) {
            return this.name.compareTo(employee.getName());
        }
        if (this.age - employee.getAge() != 0) {
            return this.age - employee.getAge();
        }
        return (int) (this.salary - employee.getSalary());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age +
                ", salary " + salary +
                ", department " + department +
                ", rating " + rating + "\n";
    }
}