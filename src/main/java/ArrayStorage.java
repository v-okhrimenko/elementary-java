import java.util.Arrays;

/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    private int counter = 0;
    Employee[] storage = new Employee[10000];

    void clear() {
        Arrays.fill(storage, null);
        counter = 0;
    }

    void save(Employee employee) {
        if (size() == storage.length) {
            System.out.println("Unable to save. The array is full");
            return;
        }
        if (employee == null) {
            System.out.println("Unable to save NULL");
            return;
        }
        counter++;
        storage[size() - 1] = employee;
    }

    Employee get(String uuid) {
        for (int s = 0; s < size(); s++) {
            if (storage[s].uuid.equals(uuid)) {
                return storage[s];
            }
        }
        System.out.println("Uuid " + uuid + " is not found");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size() - 1];
                storage[size() - 1] = null;
                counter--;
                return;
            }
        }
        System.out.println("Cant delete, uuid " + uuid + " not found");
    }

    /**
     * @return array, contains only Employees in storage (without null)
     */
    Employee[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    int size() {
        return counter;
    }
}
