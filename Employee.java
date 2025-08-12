public class Employee {


    private String name;
    private double baseSalary;
    private int employeeID;
    private Employee manager;
    private double bonus;
    private static int idCounter = 1;

    // Constructor to initialize an Employee object
    public Employee(String name, double baseSalary) {
        this.name = name;  // Set the employee's name
        this.baseSalary = baseSalary;  // Set the employee's initial salary
        this.employeeID = idCounter++;  // Assign a unique ID for this employee
        this.bonus = 0;  // Start with no bonus
    }

    // Retrieve the base salary of the employee
    public double getBaseSalary() {
        return baseSalary;
    }

    // Update the base salary of the employee
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;  // Change the employee's salary to the new value
    }

    // Get the name of the employee
    public String getName() {
        return name;
    }

    // Obtain the unique ID of the employee
    public int getEmployeeID() {
        return employeeID;
    }

    // Get the employee's manager
    public Employee getManager() {
        return manager;  // Return the employee's current manager
    }

    // Set or change the employee's manager
    public void setManager(Employee manager) {
        this.manager = manager;  // Assign a new manager to this employee
    }

    // Check if two employees are the same based on their unique ID
    public boolean equals(Employee other) {
        return this.employeeID == other.employeeID;  // Return true if IDs match
    }

    // Return a string representation of the employee, including ID and name
    public String toString() {
        return employeeID + " " + name;  // Format: "ID Name"
    }

    // Get the current bonus amount for the employee
    public double getBonus() {
        return bonus;  // Return the current bonus value
    }

    // Set or update the bonus amount for the employee
    public void setBonus(double bonus) {
        this.bonus = bonus;  // Change the employee's bonus to the specified value
    }

    // Return the status of the employee as a string
    public String employeeStatus() {
        return this.toString();  // Use the toString method to get employee's status
    }
}
