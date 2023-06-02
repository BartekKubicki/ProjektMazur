import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String FirstName = null;
        String LastName = null;
        String Position = null;
        int Pay = 0;
        int EmployeId = 0;
        Scanner scanner = new Scanner(System.in);
        int IdOfEmploye = 1;

        Employee employee1 = new Employee("John", "Doe", "Manager", IdOfEmploye++, 75000);
        Employee employee2 = new Employee("Jane", "Smith", "Accountant", IdOfEmploye++, 60000);
        Employee employee3 = new Employee("Michael", "Johnson", "Accountant", IdOfEmploye++, 55000);
        Employee employee4 = new Employee("Emily", "Jones", "Marketing Specialist", IdOfEmploye++, 50000);
        Employee employee5 = new Employee("David", "Brown", "Accountant", IdOfEmploye++, 45000);
        Employee employee6 = new Employee("Laura", "Taylor", "Human Resources Manager", IdOfEmploye++, 70000);
        Employee employee7 = new Employee("Kevin", "Wilson", "IT Specialist", IdOfEmploye++, 60000);
        Employee employee8 = new Employee("Samantha", "Davis", "Customer Service Representative", IdOfEmploye++, 40000);

        HashMap<Integer,Employee> employeeHashMap = new HashMap<>();
        EmployeeManager employeeManager = new EmployeeManager(employeeHashMap);
        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);
        employeeManager.addEmployee(employee3);
        employeeManager.addEmployee(employee4);
        employeeManager.addEmployee(employee5);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            System.out.println("1.Dodaj pracownika");
            System.out.println("2.Usuń pracownika");
            System.out.println("3.Zaktualizuj dane o pracowniku");
            System.out.println("5.Wyświetl liste wszystkich pracownikow");
            System.out.println("6.Wyszukaj pracownika po nazwisku");
            System.out.println("Inna wartosc zakonczy program");
            int input = Integer.parseInt(bufferedReader.readLine());
            switch (input){
                case 1:
                    System.out.println("Imie(Enter): ");
                    FirstName=scanner.nextLine();
                    System.out.println("Nazwisko(Enter): ");
                    LastName=scanner.nextLine();
                    System.out.println("Stanowisko(Enter): ");
                    Position=scanner.nextLine();
                    System.out.println("Wypłata(Enter): ");
                    Pay= Integer.parseInt(bufferedReader.readLine());
                    employeeManager.addEmployee(new Employee(FirstName, LastName, Position, EmployeId++, Pay));
                    break;
                case 2:
                {
                    int id = Integer.parseInt(bufferedReader.readLine());
                    employeeManager.removeEmployee(employeeManager.searchEmployeeByID(id));
                    break;
                }
                case 3:
                {
                    int id = Integer.parseInt(bufferedReader.readLine());
                    Employee employee = employeeManager.searchEmployeeByID(id);
                    if(employee != null){
                        System.out.println("Zmien pozycje(Enter): ");
                        String NewPosition = bufferedReader.readLine();
                        employee.setPosition(NewPosition);

                        System.out.println("Zmien wypłate(Enter): ");
                        int NewPay = Integer.parseInt(bufferedReader.readLine());
                        employee.setSalary(NewPay);

                    employeeManager.updateEmployee(id,employee);}
                    break;

                }
                case 5:
                {
                    employeeManager.listAllEmployees();
                    break;
                }
                case 6:
                {
                    String lastname = bufferedReader.readLine();
                    HashSet<Employee> employeeHashSet = employeeManager.searchEmployeesByLastName(lastname);
                    for (Employee employee: employeeHashSet
                         ) {
                        System.out.println(employee);
                    }
                    break;

                }
                default:
                    System.exit(0);
            }
        }
    }
}
