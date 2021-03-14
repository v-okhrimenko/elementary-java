import java.util.Scanner;

public class MainArray {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
    static String command;
    static String uuid;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String scTxt;
        boolean noExit = true;

        while (noExit) {
            System.out.print("\nВведите одну из команд - (list | save uuid | delete uuid | get uuid | size | clear | exit): ");
            scTxt = scanner.nextLine();
            checkScanner(scTxt);

            switch (command) {
                case "list":
                    printAll();
                    break;
                case "save":
                    ARRAY_STORAGE.save(new Employee(uuid));
                    printAll();
                    break;
                case "delete":
                    ARRAY_STORAGE.delete(uuid);
                    printAll();
                    break;
                case "get":
                    System.out.println("Get employee: " + ARRAY_STORAGE.get(uuid));
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
                    noExit = false;
                    break;
                case "no uuid":
                    System.out.println("You need add UUID");
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

    private static void checkScanner(String sc) {
        String[] temp = sc.split(" ");

        switch (temp[0]) {
            case "list":
                command = (temp.length > 1) ? "err" : "list";
                break;
            case "size":
                command = (temp.length > 1) ? "err" : "size";
                break;
            case "clear":
                command = (temp.length > 1) ? "err" : "clear";
                break;
            case "exit":
                command = (temp.length > 1) ? "err" : "exit";
                break;

            case "save":
            case "delete":
            case "get":
                if (temp.length == 1) {
                    command = "no uuid";
                } else if (temp.length == 2) {
                    command = temp[0];
                    uuid = temp[1];
                } else {
                    command = "err";
                }
                break;
            default:
                command = "err";
                break;
        }
    }
}
