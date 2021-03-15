/**
 * Initial employee class
 */
public class Employee {

    // Unique identifier
    private String uuid;

    public Employee() {
    }

    public Employee(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
