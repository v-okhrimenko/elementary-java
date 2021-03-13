import java.util.Scanner;

public class MainArray {
    static final StorageMethods ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {

        ARRAY_STORAGE.save(new Employee("uuid1"));
        ARRAY_STORAGE.save(new Employee("uuid2"));
        ARRAY_STORAGE.save(new Employee("uuid2"));  // повторяющийся uuid
        ARRAY_STORAGE.save(new Employee("uuid3"));
        ARRAY_STORAGE.save(new Employee(null));     // null
        ARRAY_STORAGE.save(new Employee());               // null
        ARRAY_STORAGE.save(new Employee("uuid4"));

        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!command.equals("exit")) {

            System.out.print("\nВведите одну из команд - (list | save uuid | delete uuid | get uuid | size | clear | exit): ");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "list":
                    printAll();
                    break;

                case "save uuid":
                    System.out.print("Enter employee UUID for save: ");
                    ARRAY_STORAGE.save(new Employee(scanner.nextLine()));
                    printAll();
                    break;

                case "delete uuid":
                    System.out.print("Enter employee UUID for delete: ");
                    ARRAY_STORAGE.delete(scanner.nextLine());
                    printAll();
                    break;

                case "get uuid":
                    System.out.print("Enter employee UUID: ");
                    System.out.println("Get employee: " + ARRAY_STORAGE.get(scanner.nextLine()));
                    break;

                case "size":
                    System.out.println("Storage size: " + ARRAY_STORAGE.size());
                    break;

                case "clear":
                    ARRAY_STORAGE.clear();
                    System.out.println("Storage cleared");
                    printAll();
                    break;

                case "exit":
                    break;

                default:
                    System.out.println("Enter correct command");
            }
        }
    }

    private static void printAll() {
        System.out.println("\nList of employers:");
        if (ARRAY_STORAGE.size() == 0) {
            System.out.println("No employers in storage");
        } else {
            for (Employee employee : ARRAY_STORAGE.getAll()) {
                System.out.println(employee);
            }
        }
    }
}
