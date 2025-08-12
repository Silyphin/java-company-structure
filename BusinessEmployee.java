public class BusinessEmployee extends Employee{
    private double bonusBudget;
    //Constructor BusinessEmployee with parameter name
    public BusinessEmployee(String name){
        super(name, 60000);
    }

    //returns remaining bonusBudget
    public double getBonusBudget(){
        return bonusBudget;
    }

    //determining bonusBudget
    public void setBonusBudget(double bonusBudget){
        this.bonusBudget = bonusBudget;
    }
    //returns String representation of BusinessEmployee
    public String employeeStatus(){
        return super.getEmployeeID() + " " + super.getName() + " with a budget of " + bonusBudget;
    }
}
