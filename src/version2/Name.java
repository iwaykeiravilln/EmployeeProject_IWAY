package version2;

public class Name {
    private String firstName;
    private String lastName;
    private String middleInit;

    public Name() {
        this.firstName = "N/A";
        this.lastName = "N/A";
        this.middleInit = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInit = "";
    }

    public Name(String firstName, String lastName, String middleInit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInit = middleInit;
    }

    public String getMiddleInit() {
        return middleInit;
    }

    public void setMiddleInit(String middleInit) {
        this.middleInit = middleInit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return (middleInit == null || middleInit.isEmpty()) ? firstName + " " + lastName : firstName + " " + middleInit + ". " + lastName;
    }
}
