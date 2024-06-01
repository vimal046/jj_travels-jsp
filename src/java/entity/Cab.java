package entity;

public class Cab {

    private int cabId;
    private String cabName;
    private String cabDescription;
    private String cabImageLoc;

    public Cab(int cabId, String cabName, String cabDescription, String cabImageLoc) {
        this.cabId = cabId;
        this.cabName = cabName;
        this.cabDescription = cabDescription;
        this.cabImageLoc = cabImageLoc;
    }

    public int getCabId() {
        return cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public String getCabName() {
        return cabName;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public String getCabDescription() {
        return cabDescription;
    }

    public void setCabDescription(String cabDescription) {
        this.cabDescription = cabDescription;
    }

    public String getCabImageLoc() {
        return cabImageLoc;
    }

    public void setCabImageLoc(String cabImageLoc) {
        this.cabImageLoc = cabImageLoc;
    }

    @Override
    public String toString() {
        return "Cab{"
                + "cabId=" + cabId
                + ", cabName='" + cabName + '\''
                + ", cabDescription='" + cabDescription + '\''
                + ", cabImageLoc='" + cabImageLoc + '\''
                + '}';
    }

}
