package version4;

import java.util.Objects;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    private String middleInitial() {
        if (middleName == null || middleName.isEmpty()) {
            return "";
        }
        return " " + middleName.substring(0, 1).toUpperCase() + ".";
    }

    @Override
    public String toString() {
        String suf = (suffix == null || suffix.isEmpty()) ? "" : " " + suffix;
        return lastName + ", " + firstName + middleInitial() + suf;
    }

    public void displayName() {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;
        Name other = (Name) obj;
        return firstName.equalsIgnoreCase(other.firstName)
                && middleName.equalsIgnoreCase(other.middleName)
                && lastName.equalsIgnoreCase(other.lastName)
                && suffix.equalsIgnoreCase(other.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, suffix);
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Name should be cloneable", e);
        }
    }
}