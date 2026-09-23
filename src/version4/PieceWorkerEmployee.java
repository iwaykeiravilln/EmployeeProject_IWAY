package version4;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = (totalPiecesFinished >= 0) ? totalPiecesFinished : 0;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = (ratePerPiece >= 0) ? ratePerPiece : 0.0;
    }

    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        int totalHundreds = totalPiecesFinished / 100;
        double bonusPay = totalHundreds * (10 * ratePerPiece);
        return basePay + bonusPay + getBirthdayBonus(currentMonth);
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Pieces Finished: %d | Rate/Piece: PHP%.2f%n",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Pieces: %d, Rate: PHP%.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj) || !(obj instanceof PieceWorkerEmployee)) return false;
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished && ratePerPiece == other.ratePerPiece;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}