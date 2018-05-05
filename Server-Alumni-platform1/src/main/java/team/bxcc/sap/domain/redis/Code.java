package team.bxcc.sap.domain.redis;

import java.io.Serializable;

public class Code implements Serializable {

    private static final long serialVersionUID = -1L;

    private String code;

    private Long stamp;

    public Code() {
        this.code = null;
        this.stamp = null;
    }

    public Code(String code, Long stamp) {
        this.code = code;
        this.stamp = stamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getStamp() {
        return stamp;
    }

    public void setStamp(Long stamp) {
        this.stamp = stamp;
    }
}
