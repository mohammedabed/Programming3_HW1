package Employee;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


        Employee employees[] = new Employee[2];


        readByJOptionPane(employees);
        showByJOptionPane(employees);
        addBonus(employees, 20);
        showByCommandLine(employees);

        // showByCommandLine(employees);
        // sortBySalary(employees);
        // showByCommandLine(employees);
        // sortByName(employees);
        // showByCommandLine(employees);
        // readByScanner(employees);
        // showByCommandLine(employees);
    }

    private static void sortBySalary(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                if (employees[j].getSalary() > employees[i].getSalary()) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }

    private static void sortByName(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                int compare = employees[j].getName().compareTo(employees[i].getName());
                if (compare < 0) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }

    private static void showByCommandLine(Employee[] employees) {
        System.out.println("==================");
        System.out.printf("%-9s%-15s%-13s\n", "Name", "Department", "Salary");
        for (Employee employee : employees) {
            System.out.printf("%-9s%-15s%-10.2f\n",
                    employee.getName(),
                    employee.getDepartment(),
                    employee.getSalary());
        }
        System.out.println("Number Of Employee is : " + Employee.count);
    }

    private static void showByJOptionPane(Employee[] employees) {
        String output = "";
        int count = 0;
        for (Employee employee : employees) {
            count++;
            output += "Employee" + count + " : \n";
            output += "     Name : " + employee.getName() + "     \n";
            output += "     Department : " + employee.getDepartment() + "     \n";
            output += "     Salary : " + employee.getSalary() + "     \n";
            output += "----------\n";
        }
        output += "Number Of Employee is : " + Employee.count;
        JOptionPane.showMessageDialog(null, output);
    }

    private static void readByScanner(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter ...");
            Employee emp = new Employee();

            //name input
            System.out.print("Enter the name : ");
            emp.setName(in.nextLine());
            //departnment input
            System.out.print("Enter the Department : ");
            emp.setDepartment(in.nextLine());
            //salary input
            System.out.print("Enter  salary : ");
            emp.setSalary(Integer.parseInt(in.nextLine()));

            employees[i] = emp;
        }
    }

    private static void readByJOptionPane(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter ...");

            Employee emp = new Employee();
            //name input
            emp.setName(JOptionPane.
                    showInputDialog(null, "Name", "Employee", JOptionPane.INFORMATION_MESSAGE));
            //departnment input
            emp.setDepartment(JOptionPane.
                    showInputDialog(null, "Department", "Employee", JOptionPane.INFORMATION_MESSAGE));
            //salary input
            emp.setSalary(Integer.parseInt(JOptionPane.
                    showInputDialog(null, "Salary", "Employee", JOptionPane.INFORMATION_MESSAGE)));

            employees[i] = emp;
        }
    }

    private static void addBonus(Employee[] employees, double bonus) {
        for (int i = 0; i < employees.length; i++) {
            double salary = employees[i].getSalary();
            employees[i].setSalary(salary, bonus);
        }
    }
}


