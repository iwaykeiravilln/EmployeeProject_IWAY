package version3;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[4];
        employees[0] = new HourlyEmployee(101, new Name("Keira", "Villanueva", "Iway"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        employees[1] = new PieceWorkerEmployee(201, new Name("Miyuki", "Angelyn", "Abe", "Jr."),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15.0);
        employees[2] = new CommissionEmployee(301, new Name("Ashley", "Munoz"),
                new MyDate(9, 9, 1990), new MyDate(1, 1, 2015), 75000.0);
        employees[3] = new BasePlusCommissionEmployee(401, new Name("William", "Moriarty"),
                new MyDate(14, 2, 1975), new MyDate(20, 9, 2012), 30000.0, 8000.0);

        int targetMonth = 9;
        System.out.println("-----PAYROLL REPORT (Target Month: Sep)-----");
        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            double basePay = e.computeSalary();
            double totalPay = e.computeSalary(targetMonth);
            double bonus = totalPay - basePay;
            boolean eligible = bonus > 0;
            System.out.printf("%d. %s%n", i + 1, e);
            System.out.printf("   Base Pay: PHP%.2f | Birthday Bonus: PHP%.2f (%s)%n",
                    basePay, bonus, eligible ? "Eligible" : "Ineligible");
            System.out.printf("   Total Payout: PHP%.2f%n%n", totalPay);
        }

        System.out.println("-----OBJECT CONTRACT TESTS (equals & hashCode)-----");
        HourlyEmployee emp1 = new HourlyEmployee(101, new Name("Keira", "Villanueva", "Iway"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        HourlyEmployee emp1Identical = new HourlyEmployee(101, new Name("Miyuki", "Angelyn", "Abe"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        HourlyEmployee emp2 = new HourlyEmployee(102, new Name("Sherlock", "Holmes"),
                new MyDate(3, 11, 1998), new MyDate(15, 1, 2021), 37.5f, 250.0);

        System.out.println("emp1 equals emp1Identical: " + emp1.equals(emp1Identical));
        System.out.printf("emp1 hashCode: %d | emp1Identical hashCode: %d (Match: %b)%n",
                emp1.hashCode(), emp1Identical.hashCode(), emp1.hashCode() == emp1Identical.hashCode());
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));

        System.out.println("-----DEEP CLONE VERIFICATION-----");
        HourlyEmployee empOriginal = new HourlyEmployee(101, new Name("Keira", "Villanueva", "Iway"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        HourlyEmployee empClone = empOriginal.clone();

        System.out.println("Original Name before modification: " + empOriginal.getEmpName());
        empClone.getEmpName().setLastName("Salvatore");
        System.out.println("Clone Name changed to:             " + empClone.getEmpName());
        System.out.println("Original Name after modification:  " + empOriginal.getEmpName()
                + (empOriginal.getEmpName().equals(empClone.getEmpName()) ? "" : " (Deep copy successful!)"));
    }
}