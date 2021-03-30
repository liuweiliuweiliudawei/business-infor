package common;

import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * Api 返回数据
 *
 * @author chunjianjun
 * @date 2021-01
 */

public class ApiResponse<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int code;
	private String msg;
	private T data;

	public int getCode(){
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData(){
		return data;
	}

	public void setData(T data){
		this.data = data;
	}

	public static ApiResponse success() {
		ApiResponse<String> result = new ApiResponse<String>();
		result.setCode(ResponseStatus.SUCCESS.getCode());
		result.setMsg("操作成功");

		return result;
	}

	public static ApiResponse success(String msg) {
		ApiResponse<String> result = new ApiResponse<String>();
		result.setCode(ResponseStatus.SUCCESS.getCode());
		result.setMsg(msg);

		return result;
	}

	public static<T> ApiResponse<T> build(T data){
		ApiResponse<T> result = new ApiResponse<>();
		result.setCode(ResponseStatus.SUCCESS.getCode());
		result.setMsg(ResponseStatus.SUCCESS.getMsg());
		result.setData(data);
		return result;
	}

	public static ApiResponse error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static ApiResponse error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static ApiResponse error(int code, String msg) {
		ApiResponse result = new ApiResponse();
		result.setCode(code);
		result.setMsg(msg);

		return result;
	}

	public static<T> ApiResponse<T> error(int code, String msg, T data) {
		ApiResponse result = new ApiResponse();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);

		return result;
	}

}
