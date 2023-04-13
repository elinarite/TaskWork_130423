package TaskWorkHomework2.ITCompany;

import java.util.Comparator;

public class ComparatorRating implements Comparator <Employee> {
    /**
     * comparator, which sorts by rating
     * @param employee1 the first object to be compared.
     * @param employee2 the second object to be compared.
     */
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getRating().compareTo(employee2.getRating());
    }
}