package util;

import java.io.Serializable;

public class MsqResp implements Serializable {
    private Status status;

    public MsqResp(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
    
    

