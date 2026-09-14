package version2;
import java.time.LocalDate;

public class HourlyEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    //setters and getters
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

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = (totalHoursWorked >= 0) ? totalHoursWorked : 0.0f;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    //methods
    public boolean isBirthdayToday (){
        LocalDate today = LocalDate.now();
        return this.birthDate.getMonth() == today.getMonthValue() && this.birthDate.getDay() == today.getDayOfMonth();
    }

    public double computeSalary() {
        double basesalary = 0.0;

        if (totalHoursWorked <= 40) {
            basesalary = totalHoursWorked * ratePerHour;
        } else {
            double regularPay = 40 * ratePerHour;
            double overtimePay = (totalHoursWorked - 40) * (ratePerHour * 1.5);
            basesalary = regularPay + overtimePay;
        }

        if (isBirthdayToday()){
            basesalary += 5000;
        }

        return basesalary;
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | Hours: %.2f | Rate: PHP%.2f/hr\n", empID, empName, totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: PHP%.2f, Total Salary: PHP%.2f]", empID, empName, totalHoursWorked, ratePerHour, computeSalary());
    }
}
