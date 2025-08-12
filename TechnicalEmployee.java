public class TechnicalEmployee extends Employee {
    private int successfulCheckIns = 0;

    //Constructor TechnicalEmployee with parameter name
    public TechnicalEmployee(String name) {
        super(name, 50000);
    }

    public int getSuccessfulCheckIns() {
        return successfulCheckIns;
    }

    public void incrementCheckIns() {
        successfulCheckIns++;
    }

    //returns String representation of TechnicalEmployee
    @Override
    public String employeeStatus() {
        return super.getEmployeeID() + " " + super.getName() + " has " + successfulCheckIns + " successful check-ins";
    }
}

