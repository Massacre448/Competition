package ING.atmservice.model;

public class Task {
    private int region;
    private String requestType;
    private int atmId;

    public Task() {
    }

    public Task(int region, String requestType, int atmId) {
        this.region = region;
        this.requestType = requestType;
        this.atmId = atmId;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }
}
