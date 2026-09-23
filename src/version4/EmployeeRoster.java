package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this.max = 10;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        this.max = max;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }
        empList[count] = emp;
        count++;
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                Employee removed = empList[i];
                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j + 1];
                }
                empList[count - 1] = null;
                count--;
                return removed;
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }
        return null;
    }

    public int countHE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) c++;
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) c++;
        }
        return c;
    }

    public int countCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) c++;
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) c++;
        }
        return c;
    }

    public void displayHE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                ((HourlyEmployee) empList[i]).displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                ((PieceWorkerEmployee) empList[i]).displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                ((CommissionEmployee) empList[i]).displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                ((BasePlusCommissionEmployee) empList[i]).displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            System.out.printf("%d. ID: %d | Name: %s | Type: %s%n",
                    i + 1, e.getEmpID(), e.getEmpName(), e.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            boolean birthdayMatch = e.getBirthDate().getMonth() == currentMonth;
            String bonusNote = birthdayMatch ? " (Birthday Bonus Applied)" : "";

            if (e instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) e;
                System.out.printf("[Base Plus Commission] ID: %d | Name: %s | Salary: PHP%.2f%s%n",
                        e.getEmpID(), e.getEmpName(), bpce.computeSalary(currentMonth), bonusNote);
            } else if (e instanceof CommissionEmployee) {
                CommissionEmployee ce = (CommissionEmployee) e;
                System.out.printf("[Commission] ID: %d | Name: %s | Salary: PHP%.2f%s%n",
                        e.getEmpID(), e.getEmpName(), ce.computeSalary(currentMonth), bonusNote);
            } else if (e instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) e;
                System.out.printf("[Piece Worker] ID: %d | Name: %s | Salary: PHP%.2f%s%n",
                        e.getEmpID(), e.getEmpName(), pwe.computeSalary(currentMonth), bonusNote);
            } else if (e instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) e;
                System.out.printf("[Hourly] ID: %d | Name: %s | Salary: PHP%.2f%s%n",
                        e.getEmpID(), e.getEmpName(), he.computeSalary(currentMonth), bonusNote);
            }
        }
    }
}