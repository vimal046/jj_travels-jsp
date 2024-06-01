package entity;

public class Dest {

    private int destId;
    private String destName;
    private String destDescription;
    private String destImageLoc;

    public Dest(int destId, String destName, String destDescription, String destImageLoc) {
        this.destId = destId;
        this.destName = destName;
        this.destDescription = destDescription;
        this.destImageLoc = destImageLoc;
    }

    public int getDestId() {
        return destId;
    }

    public void setDestId(int destId) {
        this.destId = destId;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public String getDestDescription() {
        return destDescription;
    }

    public void setDestDescription(String destDescription) {
        this.destDescription = destDescription;
    }

    public String getDestImageLoc() {
        return destImageLoc;
    }

    public void setDestImageLoc(String destImageLoc) {
        this.destImageLoc = destImageLoc;
    }

    @Override
    public String toString() {
        return "Hotel{"
                + "destId=" + destId
                + ", destName='" + destName + '\''
                + ", destDescription='" + destDescription + '\''
                + ", destImageLoc='" + destImageLoc + '\''
                + '}';
    }

}
