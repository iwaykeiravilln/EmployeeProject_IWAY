package version5;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)-----");

        EmployeeRoster roster = new EmployeeRoster();

        HourlyEmployee e1 = new HourlyEmployee(101, new Name("Keira", "Villanueva", "Iway"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        PieceWorkerEmployee e2 = new PieceWorkerEmployee(201, new Name("Miyuki", "Angelyn", "Abe", "Jr."),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15.0);
        CommissionEmployee e3 = new CommissionEmployee(301, new Name("Ashley", "Santos", "Munoz"),
                new MyDate(20, 9, 1992), new MyDate(1, 3, 2019), 100000.0);
        BasePlusCommissionEmployee e4 = new BasePlusCommissionEmployee(401, new Name("Wile", "E", "Coyote"),
                new MyDate(10, 11, 1988), new MyDate(1, 7, 2020), 120000.0, 14000.0);

        enrollAndReport(roster, e1, "Hourly");
        enrollAndReport(roster, e2, "Piece Worker");
        enrollAndReport(roster, e3, "Commission");
        enrollAndReport(roster, e4, "Base Plus Commission");

        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");

        System.out.println("-----PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)-----");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        roster.displayPayroll(9);

        System.out.println("-----COLLECTION REMOVAL TEST-----");
        Employee removed = roster.removeEmployee(201);
        if (removed != null) {
            System.out.println("Removing Employee ID 201... Successfully removed.");
        } else {
            System.out.println("Employee ID 201 not found.");
        }
        System.out.println("Updated Roster Size: " + roster.countEmployees());
        System.out.println("\nCurrent Active Employees:");
        roster.displayAllEmployees();
    }

    private static void enrollAndReport(EmployeeRoster roster, Employee emp, String label) {
        roster.addEmployee(emp);
        System.out.println("Enrolled: " + emp.getEmpName() + " (" + label + ")");
    }
}
