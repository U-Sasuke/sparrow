package priv.yq.sparrow.result;

import java.io.Serializable;

/**
 * Created by yaoqing on 2018/11/28.
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final int SUCCESS = 0;
    private static final int ERROR = -1;

    private Integer type;
    private String code;
    private String msg;

    public static Result success() {
        Result result = new Result();
        result.setType(SUCCESS);
        result.setMsg("success");
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setType(ERROR);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "type=" + type +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

}
