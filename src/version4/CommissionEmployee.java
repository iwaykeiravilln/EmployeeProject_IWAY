package version4;

import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = (totalSale >= 0) ? totalSale : 0.0;
    }

    protected double getCommissionRate() {
        if (totalSale < 50000) return 0.05;
        else if (totalSale < 100000) return 0.10;
        else if (totalSale < 500000) return 0.15;
        else return 0.20;
    }

    public double computeSalary(int currentMonth) {
        return (totalSale * getCommissionRate()) + getBirthdayBonus(currentMonth);
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sale: PHP%.2f%n",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalSale);
    }

    @Override
    public String toString() {
        return String.format(
                "CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Total Sale: PHP%.2f, Commission Rate: %.0f%%]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalSale, getCommissionRate() * 100);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj) || !(obj instanceof CommissionEmployee)) return false;
        CommissionEmployee other = (CommissionEmployee) obj;
        return totalSale == other.totalSale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}