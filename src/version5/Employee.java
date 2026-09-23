package version5;

import java.util.Objects;

public class Employee implements Cloneable {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    protected double getBirthdayBonus(int currentMonth) {
        return (birthDate.getMonth() == currentMonth) ? 5000.00 : 0.00;
    }

    public double computeSalary(int currentMonth) {
        return 0.0;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    public void displayEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s%n",
                empID, empName, birthDate, dateHired);
    }

    @Override
    public String toString() {
        return String.format("Employee [ID: %d, Name: %s, Total Salary: PHP%.2f]", empID, empName, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return empID == other.empID
                && empName.equals(other.empName)
                && birthDate.equals(other.birthDate)
                && dateHired.equals(other.dateHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
    }

    @Override
    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.empName = this.empName.clone();
            copy.birthDate = this.birthDate.clone();
            copy.dateHired = this.dateHired.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Employee should be cloneable", e);
        }
    }
}