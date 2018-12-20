package priv.yq.sparrow.result;

/**
 * Created by yaoqing on 2018/11/28.
 */
public enum ErrorCode {

    ERROR_0XO0000("0x00000", "系统异常！"),
    ERROR_0XO0001("0x00001", "参数为空！"),
    ERROR_0XO0002("0x00002", "Json格式错误！"),
    ERROR_0XO0003("0x00003", "用户已存在！"),
    ERROR_0XO0004("0x00004", "用户名或密码错误！");

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
