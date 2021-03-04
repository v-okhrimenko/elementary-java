/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    Employee[] storage = new Employee[10000];

    void clear() {
    }

    void save(Employee employee) {
    }

    Employee get(String uuid) {
        return null;
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Employees in storage (without null)
     */
    Employee[] getAll() {
        return new Employee[0];
    }

    int size() {
        return 0;
    }
}
