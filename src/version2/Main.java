package version2;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Name & Date Output Verification ---");
        Name sampleName = new Name("Alice", "Marie", "Smith");
        MyDate sampleDate = new MyDate(18, 9, 2026);
        System.out.print("Name: ");
        sampleName.displayName();
        System.out.print("Date: ");
        sampleDate.displayDate();

        System.out.println("\n--- Hourly Employee Payroll Test ---");
        HourlyEmployee h1 = new HourlyEmployee();
        h1.setEmpID(1001);
        h1.setEmpName(new Name("Alice", "Marie", "Smith"));
        h1.setBirthDate(new MyDate(18, 9, 2000));
        h1.setDateHired(new MyDate(1, 6, 2022));
        h1.setTotalHoursWorked(45.0f);
        h1.setRatePerHour(200.0);

        HourlyEmployee h2 = new HourlyEmployee(1002, new Name("John", "Doe"),
                new MyDate(3, 11, 1998), new MyDate(15, 1, 2021), 37.5f, 250.0);

        System.out.println("[displayHourlyEmployee()]");
        h1.displayHourlyEmployee();
        h2.displayHourlyEmployee();
        System.out.println("[toString()]");
        System.out.println(h1);
        System.out.println(h2);

        System.out.println("[Birthday Incentive Check - h1]");
        System.out.printf("Regular Month (Oct) Salary: PHP%.2f%n", h1.computeSalary(10));
        System.out.printf("Birth Month (Sep) Salary: PHP%.2f%n", h1.computeSalary(9));

        System.out.println("\n--- Piece Worker Employee Payroll Test ---");
        PieceWorkerEmployee p1 = new PieceWorkerEmployee();
        p1.setEmpID(2001);
        p1.setEmpName(new Name("Keira", "Villanueva", "Iway"));
        p1.setBirthDate(new MyDate(5, 3, 2004));
        p1.setDateHired(new MyDate(10, 8, 2023));
        p1.setTotalPiecesFinished(250);
        p1.setRatePerPiece(15.0);

        PieceWorkerEmployee p2 = new PieceWorkerEmployee(2002, new Name("Kiera", "Yawi"),
                new MyDate(20, 12, 1999), new MyDate(2, 2, 2020), 120, 20.0);

        System.out.println("[displayPieceWorkerEmployee()]");
        p1.displayPieceWorkerEmployee();
        p2.displayPieceWorkerEmployee();
        System.out.println("[toString()]");
        System.out.println(p1);
        System.out.println(p2);

        System.out.println("[Birthday Incentive Check - p1]");
        System.out.printf("Regular Month (Jun) Salary: PHP%.2f%n", p1.computeSalary(6));
        System.out.printf("Birth Month (Mar) Salary: PHP%.2f%n", p1.computeSalary(3));

        System.out.println("\n--- Commission Employee Payroll Test ---");
        CommissionEmployee c1 = new CommissionEmployee();
        c1.setEmpID(3001);
        c1.setEmpName(new Name("Indiana", "Jones"));
        c1.setBirthDate(new MyDate(1, 7, 1985));
        c1.setDateHired(new MyDate(1, 1, 2015));
        c1.setTotalSale(75000.0);

        CommissionEmployee c2 = new CommissionEmployee(3002, new Name("Shannon", "Debussy"),
                new MyDate(30, 4, 1990), new MyDate(5, 5, 2018), 550000.0);

        System.out.println("[displayCommissionEmployee()]");
        c1.displayCommissionEmployee();
        c2.displayCommissionEmployee();
        System.out.println("[toString()]");
        System.out.println(c1);
        System.out.println(c2);

        System.out.println("[Birthday Incentive Check - c1]");
        System.out.printf("Regular Month (Jan) Salary: PHP%.2f%n", c1.computeSalary(1));
        System.out.printf("Birth Month (Jul) Salary: PHP%.2f%n", c1.computeSalary(7));

        System.out.println("\n--- Base Plus Commission Employee Payroll Test ---");
        BasePlusCommissionEmployee b1 = new BasePlusCommissionEmployee();
        b1.setEmpID(4001);
        b1.setEmpName(new Name("Sherlock", "Holmes"));
        b1.setBirthDate(new MyDate(6, 1, 1980));
        b1.setDateHired(new MyDate(1, 3, 2010));
        b1.setTotalSale(120000.0);
        b1.setBaseSalary(10000.0);

        BasePlusCommissionEmployee b2 = new BasePlusCommissionEmployee(4002, new Name("William", "Moriarty"),
                new MyDate(14, 2, 1975), new MyDate(20, 9, 2012), 30000.0, 8000.0);

        System.out.println("[displayBasePlusCommissionEmployee()]");
        b1.displayBasePlusCommissionEmployee();
        b2.displayBasePlusCommissionEmployee();
        System.out.println("[toString()]");
        System.out.println(b1);
        System.out.println(b2);

        System.out.println("[Birthday Incentive Check - b1]");
        System.out.printf("Regular Month (Jun) Salary: PHP%.2f%n", b1.computeSalary(6));
        System.out.printf("Birth Month (Jan) Salary: PHP%.2f%n", b1.computeSalary(1));
    }
}