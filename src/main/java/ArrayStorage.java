import java.util.Arrays;

/**
 * Array based storage for Employees
 */
class ArrayStorage {
    private int counter = 0;
    private final Employee[] storage = new Employee[10000];


    public void clear() {
        Arrays.fill(storage, null);
        counter = 0;
    }

    public void save(Employee employee) {
        if ((employee == null) || (employee.getUuid() == null) || employee.getUuid().isEmpty()) {
            System.out.println("Unable to save NULL");
            return;
        }
        if (checkIfEmployIdIPresent(employee.getUuid())) {
            System.out.println("Unable to save. This UUID " + employee.getUuid() + " is already in use");
            return;
        }
        if (size() == storage.length) {
            System.out.println("Unable to save. The array is full");
            return;
        }
        counter++;
        storage[size() - 1] = employee;
        System.out.println("Employee " + employee.getUuid() + " saved");
    }

    public Employee get(String uuid) {
        for (int s = 0; s < size(); s++) {
            if (storage[s].getUuid().equals(uuid)) {
                return storage[s];
            }
        }
        System.out.println("UUID " + uuid + " is not found");
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size() - 1];
                storage[size() - 1] = null;
                counter--;
                System.out.println("Employee with UUID " + uuid + " deleted");
                return;
            }
        }
        System.out.println("Cant delete, UUID " + uuid + " not found");
    }

    /**
     * @return array, contains only Employees in storage (without null)
     */
    public Employee[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    public int size() {
        return counter;
    }

    private boolean checkIfEmployIdIPresent(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }
}
