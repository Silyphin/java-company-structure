import java.util.*;

public class BusinessLead extends BusinessEmployee {
    private static final int HEAD_COUNT = 10; // Maximum number of direct reports
    private int headcount; // Declare headcount variable
    private ArrayList<Accountant> reports = new ArrayList<>();

    public BusinessLead(String name) {
        super(name);
        setBaseSalary(60000 * 2); // Set salary to twice that of an Accountant
        this.headcount = HEAD_COUNT; // Initialize headcount to 10
    }

    public boolean hasHeadCount() {
        return reports.size() < headcount; // Check if reports are less than headcount
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (hasHeadCount()) {
            reports.add(e);
            e.setManager(this);
            e.supportTeam(supportTeam);
            setBonusBudget(getBonusBudget() + e.getBaseSalary() * 1.1); // Increase bonus budget
            return true; // Successfully added report
        }
        return false; // No headcount available
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (bonus <= this.getBonusBudget()) { // Check if bonus fits in the budget
            setBonusBudget(getBonusBudget() - bonus); // Deduct from the budget
            e.setBonus(e.getBonus() + bonus); // Update employee's bonus
            return true; // Successfully granted the bonus
        }
        return false; // Not enough budget
    }

    public boolean approveBonus(Employee e, double bonus) {
        for (Accountant a : reports) {
            if (a.getTeamSupported() != null && a.getTeamSupported().equals(e.getManager())) {
                return a.approveBonus(bonus); // Checks if Accountant can approve the bonus
            }
        }
        return false; // No approval granted
    }
}

