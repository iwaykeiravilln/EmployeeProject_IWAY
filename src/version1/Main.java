package version1;

public class Main {
    public static void main(String[] args) {
        HourlyEmployee h1 = new version1.HourlyEmployee();
        h1.setEmpID(1001); 
        h1.setEmpName("Jane Doe"); 
        h1.setTotalHoursWorked(45.0f);
        h1.setRatePerHour(200.0);
        
        HourlyEmployee h2 = new version1.HourlyEmployee(1002, "John Doe", 37.5f, 250.0);

        System.out.println("--- Hourly Employee ---");
        h1.displayHourlyEmployee();
        h2.displayHourlyEmployee();
        System.out.println(h1);
        System.out.println(h2);
        
        PieceWorkerEmployee p1 = new version1.PieceWorkerEmployee(2001, "Keira Iway");
        p1.setTotalPiecesFinished(250);
        p1.setRatePerPiece(15.0);

        PieceWorkerEmployee p2 = new version1.PieceWorkerEmployee(2002, "Kiera Yawi", 120, 20.0);

        System.out.println("\n--- Piece Worker Employee ---");
        p1.displayPieceWorkerEmployee();
        p2.displayPieceWorkerEmployee();
        System.out.println(p1);
        System.out.println(p2);
        
        CommissionEmployee c1 = new version1.CommissionEmployee();
        c1.setEmpID(3001);
        c1.setEmpName("Indiana Jones");
        c1.setTotalSale(75000.0);

        CommissionEmployee c2 = new version1.CommissionEmployee(3002, "Shannon Debussy", 550000.0);

        System.out.println("\n--- Commission Employee ---");
        c1.displayCommissionEmployee();
        c2.displayCommissionEmployee();
        System.out.println(c1);
        System.out.println(c2);
        
        BasePlusCommissionEmployee b1 = new version1.BasePlusCommissionEmployee(4001, "Sherlock Holmes");
        b1.setTotalSale(120000.0);
        b1.setBaseSalary(10000.0);

        BasePlusCommissionEmployee b2 = new version1.BasePlusCommissionEmployee(4002, "William Moriarty", 30000.0, 8000.0);

        System.out.println("\n--- Base Plus Commission Employee ---");
        b1.displayBasePlusCommissionEmployee();
        b2.displayBasePlusCommissionEmployee();
        System.out.println(b1);
        System.out.println(b2);
    }

}
