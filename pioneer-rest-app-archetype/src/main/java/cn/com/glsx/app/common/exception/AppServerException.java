package cn.com.glsx.app.common.exception;

import com.glsx.plat.exception.SystemMessage;
import lombok.Getter;

/**
 * @author payu
 */
@Getter
public class AppServerException extends RuntimeException {

    private int errorCode = SystemMessage.FAILURE.getCode();

    public AppServerException(String message) {
        super(message);
    }

    public AppServerException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public static AppServerException of(SystemMessage message) {
        return new AppServerException(message.getCode(), message.getMsg());
    }

    public AppServerException(Throwable cause) {
        super(cause);
    }

    public AppServerException(String message, Throwable cause) {
        super(message, cause);
    }

}
