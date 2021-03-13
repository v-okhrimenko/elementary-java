public interface StorageMethods {

    void save(Employee employee);

    void delete(String uuid);

    Employee get(String uuid);

    Employee[] getAll();

    int size();

    void clear();
}
