// MainProgram.java
public class MainProgram {
    public static void main(String[] args) {
        // Create Employee object
        Employee emp = new Employee();

        // Set values using setters
        emp.setName("Gokul");
        emp.setId(101);
        emp.setBasicSalary(50000);
        emp.setAllowance(10000);
        emp.setDeduction(5000);

        // Display employee details and net salary
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Basic Salary: " + emp.getBasicSalary());
        System.out.println("Allowance: " + emp.getAllowance());
        System.out.println("Deduction: " + emp.getDeduction());
        System.out.println("Net Salary: " + emp.getNetSalary());
    }
}
