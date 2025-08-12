import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    private static final int HEAD_COUNT = 4;
    private ArrayList<SoftwareEngineer> reports = new ArrayList<>();
    private double baseSalary; // Base salary specific to TechnicalLead
    private int headCount; // Number of direct reports

    public TechnicalLead(String name) {
        super(name);
        this.baseSalary = super.getBaseSalary() * 1.3; // Set base salary to 1.3 times TechnicalEmployee's base salary
        this.headCount = HEAD_COUNT; // Set default head count to 4
    }

    // Getter for head count
    public int getHeadCount() {
        return headCount;
    }
    // Checks if the TechnicalLead can add more reports
    public boolean hasHeadCount() {
        return reports.size() < HEAD_COUNT;
    }
    // Adds a SoftwareEngineer as a report if there's available headcount
    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount()) {
            reports.add(e);
            e.setManager(this);  // Assign this TechnicalLead as manager
            return true;
        }
        return false;   // Return false if headcount is full
    }

    // Approves a check-in for a SoftwareEngineer if they are a direct report
    public boolean approveCheckIn(SoftwareEngineer e) {
        return reports.contains(e) && e.getCodeAccess();
    }

    // Returns the list of reports
    public ArrayList<SoftwareEngineer> getReports() {
        return reports;
    }

    // Overrides employeeStatus to include managing reports
    @Override
    public String employeeStatus() {
        String status = super.employeeStatus() + " is managing: \n";
        for (SoftwareEngineer e : reports) {
            status += e.employeeStatus() + "\n";  // Include each report's status
        }
        return reports.isEmpty() ? super.employeeStatus() + " and no direct reports yet" : status;
    }
}

