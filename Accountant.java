public class Accountant extends BusinessEmployee {
    private TechnicalLead teamSupported;

    public Accountant(String name) {
        super(name);
        setBonusBudget(0);
    }

    public TechnicalLead getTeamSupported() {
        return teamSupported;
    }

    public void supportTeam(TechnicalLead lead) {
        this.teamSupported = lead;
        double newBudget = 0;

        for (SoftwareEngineer e : lead.getReports()) {
            newBudget += e.getBaseSalary();
        }
        setBonusBudget(newBudget * 1.1);
    }

    public boolean approveBonus(double bonus) {
        // Check if the accountant is supporting a team and if there's enough budget
        if (teamSupported == null || getBonusBudget() < bonus) {
            return false; // Return false if no team is supported or budget is insufficient
        }
        // Deduct the bonus from the budget and return true
        setBonusBudget(getBonusBudget() - bonus);
        return true;
    }

    @Override
    public String employeeStatus() {
        return super.employeeStatus() +
                " with a budget of " + getBonusBudget() +
                " is supporting " + (teamSupported != null ? teamSupported.getName() : "no team");
    }
}

