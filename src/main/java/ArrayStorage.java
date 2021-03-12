import java.util.Arrays;

/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    private static int COUNT = 0;
    Employee[] storage = new Employee[10000];

    void clear() {
        Arrays.fill(storage, null);
        COUNT = 0;
    }

    void save(Employee employee) {

        if (size() == storage.length) {
            System.out.println("Unable to save. The array is full");
        } else if (employee == null) {
            System.out.println("Unable to save NULL");
        } else {
            COUNT++;
            storage[size() - 1] = employee;
        }
    }

    Employee get(String uuid) {
        int index = 0;
        try {
            while (!storage[index].uuid.equals(uuid)) {
                if (index == storage.length - 1 || storage[index] == null) {
                    return null;
                }
                index++;
            }
        } catch (NullPointerException e) {
            return null;
        }
        return storage[index];
    }

    void delete(String uuid) {
        Employee[] newArray = new Employee[storage.length];
        for (int i = 0; i < size(); i++) {
            Employee e = storage[i];
            if (e.uuid.equals(uuid)) {
                storage[i] = null;

                System.arraycopy(storage, i + 1, newArray, 0, storage.length - 1 - i);
                System.arraycopy(newArray, 0, storage, i, storage.length - 1 - i);

                COUNT--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Employees in storage (without null)
     */
    Employee[] getAll() {
        Employee[] arrEmployee = new Employee[size()];
        System.arraycopy(storage, 0, arrEmployee, 0, size());
        return arrEmployee;
    }

    int size() {
        return COUNT;
    }
}
