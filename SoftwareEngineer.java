public class SoftwareEngineer extends TechnicalEmployee {
    private boolean codeAccess;
    private int successfulCheckIns;  // This will track successful check-ins

    // Constructor
    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = true;  // Initially setting code access to true
        this.successfulCheckIns = 0;  // Initially no successful check-ins
    }

    // Get the current code access status
    public boolean getCodeAccess() {
        return codeAccess;
    }

    // Set the code access status
    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    // Get the current count of successful check-ins
    public int getSuccessfulCheckIns() {
        return successfulCheckIns;
    }

    // Check if the manager approves check-in
    public boolean checkInCode() {
        // Get the manager of this SoftwareEngineer
        Employee manager = this.getManager();

        // Check if the manager is a TechnicalLead
        if (manager instanceof TechnicalLead) {
            TechnicalLead lead = (TechnicalLead) manager;

            // If the manager approves the check-in and code access is true
            if (lead.approveCheckIn(this) && this.getCodeAccess()) {
                successfulCheckIns++; // Increment successful check-ins
                return true;          // Check-in is successful
            }
        }

        // If check-in fails, revoke code access
        this.setCodeAccess(false);
        return false;  // Check-in is unsuccessful
    }

    // Return a string representation of the SoftwareEngineer
    @Override
    public String employeeStatus() {
        return getEmployeeID() + " " + getName() + " has " + getSuccessfulCheckIns() + " successful check-ins";
    }
}


