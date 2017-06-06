package cn.swu.fun.system.dto;

public class ResultDto {

	public final static int CODE_OK = 0; // 正确返回
	public final static int CODE_NOT_LOGIN = 1; // 没有登录
	public final static int CODE_INTERNAL_ERROR = 2; // 服务器内部错误
	public final static int CODE_WRONG_PARAMETERS = 3; // 参数错误
	public final static int CODE_NO_SUCH_FUNCTION = 4; // 没有这个方法

	// 状态码
	private int code;
	// 信息
	private String message;
	// 数据
	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
