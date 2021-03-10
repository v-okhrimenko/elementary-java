/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    Employee[] storage = new Employee[10000];

    void clear() {
        for (int i = size() - 1; i >= 0; i--) {
            storage[i] = null;
        }
    }

    void save(Employee employee) {
        storage[size()] = employee;
    }

    Employee get(String uuid) {
        Employee e = null;
        for (int i = 0; i <= size() - 1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                e = storage[i];
            }
        }
        return e;
    }

    void delete(String uuid) {
        int uuidIndex = 0;
        for (int i = 0; i <= size() - 1; i++) {
            Employee e = storage[i];
            if (e.uuid.equals(uuid)) {
                storage[i] = null;
                uuidIndex = i;
            }
        }
        for (int i = uuidIndex; i <= size() - 1; i++) {
            storage[i] = storage[i + 1];
        }
    }

    /**
     * @return array, contains only Employees in storage (without null)
     */
    Employee[] getAll() {
        Employee[] arrEmployee = new Employee[size()];
        for (int i = 0; i <= size() - 1; i++) {
            arrEmployee[i] = storage[i];
        }
        return arrEmployee;
    }

    int size() {
        int realSize = 0;
        for (Employee e : storage) {
            if (e != null) {
                realSize++;
            }
        }
        return realSize;
    }
}
