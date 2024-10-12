import java.util.*;

public class App {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO DEMO APPLICATION FOR JDBC");
        System.out.println("Enter your database URL");

        String url = sc.nextLine().trim();

        System.out.println("Enter Username");
        String username = sc.nextLine().trim();

        System.out.println("Enter Password");
        String pass = sc.nextLine().trim();

        JDBCController controller = new JDBCController(url, username, pass);

        System.out.println("This is a Java application which communicates with Database");

        char ch;
        do {
            System.out.println("Select your option");
            System.out.println("1.Show Employees");
            System.out.println("2.Delete Employee");
            System.out.println("3.Update Employee");
            System.out.println("4.Insert Employee");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    controller.displayEmployees();
                    break;
                case 2: {
                    System.out.println("Enter id of Employee you want to delete");
                    // sc.next();
                    int id = sc.nextInt();
                    if (controller.deleteEmployee(id)) {
                        System.out.println("Successfully deleted Employee");
                    } else {
                        System.out.println("Employee doesnt exist");
                    }
                }
                    break;

                case 3: {
                    System.out.println("Enter id of employee you want to update");
                    // sc.next();
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter salary : ");
                    int sal = sc.nextInt();
                    System.out.println("Enter dept :");
                    // sc.next();
                    String dept = sc.next();

                    Employee emp = new Employee(id, name, sal, dept);
                    if (controller.updateEmployee(emp)) {
                        System.out.println("Successfully updated employee data");
                    } else {
                        System.out.println("Invalid id of employee");
                    }

                }
                    break;
                case 4: {
                    sc.nextLine();
                    System.out.println("Enter name of Employee");
                    String name = sc.nextLine();
                    System.out.println("Enter Salaray : ");
                    int sal = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Dept");
                    String dept = sc.nextLine();

                    Employee emp = new Employee(0, name, sal, dept); // Id as 0 because auto increment and database will
                                                                     // handel
                    if (controller.insertEmployee(emp)) {
                        System.out.println("Successfully inserted Data");
                    } else {
                        System.out.println("Couldnt insert Employee");
                    }
                }
                    break;

                default:
                    break;
            }

            System.out.println("Do you want to continue (y/n)");
            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');

        sc.close();
    }
}