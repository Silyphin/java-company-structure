# Company Structure Management System

A Java-based employee management system that demonstrates object-oriented programming concepts through a realistic company hierarchy.

## What This Project Does

This system models a company with two main departments: Technical and Business. It handles employee relationships, code check-ins, bonus approvals, and team management.

## How to Run

1. Make sure you have Java installed
2. Download all the Java files
3. Compile: `javac *.java`
4. Create a main class to test the system
5. Run: `java YourMainClass`

## Company Structure

```
Employee (Base Class)
├── TechnicalEmployee
│   ├── SoftwareEngineer (writes code, needs approval)
│   └── TechnicalLead (manages up to 4 engineers)
└── BusinessEmployee
    ├── Accountant (manages budgets for tech teams)
    └── BusinessLead (manages up to 10 accountants)
```

## Key Features

### Employee Management
- Unique ID assignment for each employee
- Manager-report relationships
- Salary and bonus tracking

### Technical Department
- **SoftwareEngineers** can check in code (with approval)
- **TechnicalLeads** approve code check-ins
- Track successful check-ins for performance

### Business Department
- **Accountants** manage bonus budgets for technical teams
- **BusinessLeads** oversee multiple accountants
- Budget calculations based on team salaries

### Bonus System
- Multi-level approval process
- Budget validation at each level
- Automatic budget deduction when bonuses are approved

## Classes Overview

### Employee.java
Base class for all employees with:
- Name, ID, salary, manager tracking
- Bonus management
- Basic employee operations

### TechnicalEmployee.java
Base for technical roles with:
- Default $50,000 salary
- Check-in tracking functionality

### SoftwareEngineer.java
Individual contributors who:
- Need code access to check in code
- Must get manager approval for check-ins
- Track successful check-in history

### TechnicalLead.java
Managers who:
- Manage up to 4 software engineers
- Approve code check-ins from their reports
- Have 1.3x base technical salary

### BusinessEmployee.java
Base for business roles with:
- Default $60,000 salary
- Bonus budget management

### Accountant.java
Support staff who:
- Support one technical team
- Manage bonus budgets (110% of team salaries)
- Approve bonus requests within budget

### BusinessLead.java
Senior managers who:
- Manage up to 10 accountants
- Have 2x accountant base salary
- Handle high-level bonus approvals

## OOP Concepts Demonstrated

### 1. Inheritance (IS-A relationship)
```
Employee (base class)
├── TechnicalEmployee extends Employee
│   ├── SoftwareEngineer extends TechnicalEmployee
│   └── TechnicalLead extends TechnicalEmployee
└── BusinessEmployee extends Employee
    ├── Accountant extends BusinessEmployee
    └── BusinessLead extends BusinessEmployee
```
- Child classes inherit methods and properties from parents
- Example: `SoftwareEngineer` inherits `getName()` from `Employee`
- Avoids code duplication - write once, use everywhere

### 2. Polymorphism (same method, different behavior)
```java
// Same method call, different output for each employee type:
employee.employeeStatus();
// Employee: "1 John"
// SoftwareEngineer: "2 Alice has 5 successful check-ins"
// TechnicalLead: "3 Bob has 3 check-ins is managing: ..."
// Accountant: "4 Carol with budget 50000 is supporting Team Alpha"
```

### 3. Encapsulation (data protection)
```java
private boolean codeAccess;           // PRIVATE - can't access directly
public boolean getCodeAccess() {      // PUBLIC - controlled access
    return codeAccess;
}
public void setCodeAccess(boolean access) {  // PUBLIC - controlled modification
    this.codeAccess = access;
}
```

### 4. Composition (HAS-A relationship)
```java
// TechnicalLead HAS SoftwareEngineers
private ArrayList<SoftwareEngineer> reports;

// Accountant HAS TechnicalLead (team they support)
private TechnicalLead teamSupported;

// BusinessLead HAS Accountants
private ArrayList<Accountant> reports;
```
- Objects contain other objects as components
- Enables complex relationships and interactions between classes

## Real-World Scenario Example

```java
// Create employees
TechnicalLead alice = new TechnicalLead("Alice");
SoftwareEngineer bob = new SoftwareEngineer("Bob");
Accountant charlie = new Accountant("Charlie");
BusinessLead diana = new BusinessLead("Diana");

// Build team structure
alice.addReport(bob);              // Alice manages Bob
charlie.supportTeam(alice);        // Charlie supports Alice's team
diana.addReport(charlie, alice);   // Diana manages Charlie

// Workflow
bob.checkInCode();                 // Bob tries to check in code
// → Alice approves → Bob's check-in count increases
```

## What I Learned

This project helped me understand:
- How inheritance creates clean, reusable code hierarchies
- Using polymorphism to handle different employee types uniformly
- Building complex object relationships through composition
- Implementing business logic with proper encapsulation
- Managing state and behavior across multiple interacting classes

## Technical Skills Demonstrated

- Object-oriented design and implementation
- Inheritance hierarchies and method overriding
- ArrayList management and object relationships
- Input validation and error handling
- Complex business logic implementation
- Multi-class system design


