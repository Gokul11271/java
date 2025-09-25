// Employee.java
public class Employee implements java.io.Serializable {
    // Private fields
    private String name;
    private int id;
    private double basicSalary;
    private double allowance;
    private double deduction;

    // Constructor
    public Employee() {
        // Default constructor
    }

    // Getter and Setter methods with validation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name. Name cannot be empty.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0) {
            this.id = id;
        } else {
            System.out.println("Invalid ID. ID must be positive.");
        }
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        if(basicSalary >= 0) {
            this.basicSalary = basicSalary;
        } else {
            System.out.println("Basic salary cannot be negative.");
        }
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        if(allowance >= 0) {
            this.allowance = allowance;
        } else {
            System.out.println("Allowance cannot be negative.");
        }
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        if(deduction >= 0) {
            this.deduction = deduction;
        } else {
            System.out.println("Deduction cannot be negative.");
        }
    }

    // Method to calculate net salary
    public double getNetSalary() {
        return basicSalary + allowance - deduction;
    }
}
