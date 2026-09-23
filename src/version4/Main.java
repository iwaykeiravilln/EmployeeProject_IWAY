package version4;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT-----");

        EmployeeRoster roster = new EmployeeRoster(6);

        HourlyEmployee e1 = new HourlyEmployee(101, new Name("Keira", "Villanueca", "Iway"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        PieceWorkerEmployee e2 = new PieceWorkerEmployee(201, new Name("Prince", "Charles", "England", "Jr."),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15.0);
        CommissionEmployee e3 = new CommissionEmployee(301, new Name("Miyuki", "Angelyn", "Abe"),
                new MyDate(20, 9, 1992), new MyDate(1, 3, 2019), 100000.0);
        BasePlusCommissionEmployee e4 = new BasePlusCommissionEmployee(401, new Name("Ashley", "Santos", "Munoz"),
                new MyDate(10, 11, 1988), new MyDate(1, 7, 2020), 120000.0, 14000.0);
        HourlyEmployee e5 = new HourlyEmployee(102, new Name("David", "John", "Watson"),
                new MyDate(2, 2, 1995), new MyDate(10, 10, 2021), 40.0f, 200.0);
        PieceWorkerEmployee e6 = new PieceWorkerEmployee(202, new Name("Albert", "Moriarty"),
                new MyDate(3, 3, 1993), new MyDate(1, 4, 2021), 180, 12.0);

        addAndReport(roster, e1, "Hourly");
        addAndReport(roster, e2, "Piece Worker");
        addAndReport(roster, e3, "Commission");
        addAndReport(roster, e4, "Base Plus Commission");
        addAndReport(roster, e5, "Hourly");
        addAndReport(roster, e6, "Piece Worker");

        System.out.println("\n-----ROSTER COMPOSITION COUNTS-----");
        System.out.println("Total Employees: " + roster.getCount() + " / " + roster.getMax());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        HourlyEmployee overflow = new HourlyEmployee(103, new Name("Extra", "Employee"),
                new MyDate(1, 1, 1990), new MyDate(1, 1, 2020), 40.0f, 150.0);
        boolean added = roster.addEmployee(overflow);
        System.out.println("\nAttempting to add beyond capacity -> " + (added ? "Success" : "Failed (Roster Full)"));

        System.out.println("\n-----CATEGORICAL DISPLAY-----");
        System.out.println("[Hourly Employees]");
        roster.displayHE();
        System.out.println("[Piece Worker Employees]");
        roster.displayPWE();
        System.out.println("[Commission Employees]");
        roster.displayCE();
        System.out.println("[Base Plus Commission Employees]");
        roster.displayBPCE();

        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        roster.displayPayroll(9);

        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        Employee removed = roster.removeEmployee(201);
        if (removed != null) {
            System.out.println("Removing Employee ID 201 (" + removed.getEmpName() + ")... Successfully removed.");
        } else {
            System.out.println("Employee ID 201 not found.");
        }
        System.out.println("Current Employee Count: " + roster.getCount());
        System.out.println("\nRemaining Employees in Roster:");
        roster.displayAllEmployees();
    }

    private static void addAndReport(EmployeeRoster roster, Employee emp, String label) {
        boolean success = roster.addEmployee(emp);
        System.out.println("Added: " + emp.getEmpName() + " (" + label + ") -> " + (success ? "Success" : "Failed"));
    }
}