import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String name;
    private String employeeId;
    private String department;
    private String position;

    public Employee(String name, String employeeId, String department, String position) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }
}

class HRMS {
    private List<Employee> employees;

    public HRMS() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String employeeId, String department, String position) {
        Employee employee = new Employee(name, employeeId, department, position);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void viewEmployee(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                System.out.println("Employee Details:");
                System.out.println("Name: " + employee.getName());
                System.out.println("Employee ID: " + employee.getEmployeeId());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("Position: " + employee.getPosition());
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void updateEmployee(String employeeId, String name, String department, String position) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                employee.name = name;
                employee.department = department;
                employee.position = position;
                System.out.println("Employee details updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId().equals(employeeId)) {
                employees.remove(i);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }
}

public class HRMSConsoleApp {
    public static void main(String[] args) {
        HRMS hrms = new HRMS();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("==== HRMS Console App ====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee ID: ");
                    String employeeId = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    hrms.addEmployee(name, employeeId, department, position);
                    break;

                case 2:
                    System.out.print("Enter employee ID: ");
                    employeeId = scanner.nextLine();
                    hrms.viewEmployee(employeeId);
                    break;

                case 3:
                    System.out.print("Enter employee ID: ");
                    employeeId = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new department: ");
                    department = scanner.nextLine();
                    System.out.print("Enter new position: ");
                    position = scanner.nextLine();
                    hrms.updateEmployee(employeeId, name, department, position);
                    break;

                case 4:
                    System.out.print("Enter employee ID: ");
                    employeeId = scanner.nextLine();
                    hrms.deleteEmployee(employeeId);
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
