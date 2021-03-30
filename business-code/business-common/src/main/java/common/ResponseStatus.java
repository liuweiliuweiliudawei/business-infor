package common;

/**
 * 响应状态枚举
 * @author chunjianjun
 * @date 2021-01
 */
public enum ResponseStatus {
    SUCCESS(200, "ok"),
    UNAUTHORIZED(401, "未授权"),
    ILLEGAL_ARGUMENT_EXCEPTION(400, "非法参数"),
    UNKNOWN_EXCEPTION(500, "服务器发生未知错误"),
    NOT_FOUND_EXCEPTION(10001, "没有找到指定的数据");

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private int code;
    private String msg;

    ResponseStatus(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
