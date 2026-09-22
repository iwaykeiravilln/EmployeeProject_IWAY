/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version1;
/**
 *
 * @author User
 */
public class PieceWorkerEmployee {
    
    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee(){
        this.empID = 0;
        this.empName = "N/A";
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }
    
    public PieceWorkerEmployee(int empID, String empName){
        this.empID = empID;     
        this.empName = empName;   
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece){
        this.empID = empID;
        this.empName = empName;
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = Math.max(totalPiecesFinished, 0);
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }
    
    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = (ratePerPiece >= 0) ? ratePerPiece : 0.0;
    }
    
    //methods
    public double computeSalary() {
        double base = totalPiecesFinished * ratePerPiece;
        int totalHundreds = totalPiecesFinished/100; 
        double bonus = totalHundreds * (10 * ratePerPiece);
        return base + bonus;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | Pieces Finished: %d | Rate/Piece: PHP%.2f\n", empID, empName, totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %d, Rate: PHP%.2f, Total Salary: PHP%.2f]",empID, empName, totalPiecesFinished, ratePerPiece, computeSalary());
    }
}
