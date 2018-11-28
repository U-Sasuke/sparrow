package priv.yq.sparrow.result;

/**
 * Created by yaoqing on 2018/11/28.
 */
public enum ErrorCode {

    ERROR_OXOA001("oxoa001", "参数为空！"),
    ERROR_OXOA002("oxoa002", "Json格式错误！");

    private String code;
    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
