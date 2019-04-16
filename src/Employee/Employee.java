package Employee;
public class Employee {

    private String name;
    private String department;
    private double salary;

    public static int count = 0;

    public Employee() {
        count++;
    }

    public Employee(String name, String department, double salary) {
        this();
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSalary(double salary, double bonus) {
        this.salary = salary * bonus;
    }

}