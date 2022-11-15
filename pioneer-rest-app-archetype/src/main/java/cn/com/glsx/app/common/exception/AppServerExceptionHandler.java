package cn.com.glsx.app.common.exception;

import com.glsx.plat.core.web.R;
import com.glsx.plat.exception.BusinessException;
import com.glsx.plat.exception.ExceptionLevel;
import com.glsx.plat.exception.GlobalExceptionHandler;
import com.glsx.plat.exception.SystemMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.BindingException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author payu
 */
@Slf4j
@RestControllerAdvice
public class AppServerExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(AppServerException.class)
    public R handleAdminException(AppServerException e) {
        saveException(e, ExceptionLevel.fatal);
        return R.error(e.getErrorCode(), e.getMessage());
    }

    /**
     * 引入Feign服务的话
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(FeignException.class)
//    public R handleFeignException(FeignException e) {
//        saveException(e, ExceptionLevel.fatal);
//        return R.error(e.status(), e.getMessage());
//    }

    /**
     * Mybatis BindingException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindingException.class)
    public R handleBindingException(BindingException e) {
        saveException(e, ExceptionLevel.fatal);
        return R.error(e.getMessage());
    }

    @ExceptionHandler(value = MyBatisSystemException.class)
    public R myBatisSystemException(MyBatisSystemException e, HttpServletRequest request) {
        Throwable cause = e.getCause();
        if (cause instanceof BusinessException) {
            return businessExceptionHandler(request, e);
        }
        log.error("数据存储出错", e);
        saveException(e, ExceptionLevel.fatal);
        return SystemMessage.DATA_HANDLE_ERROR.result();
    }

    @Override
    protected void saveException(Exception e, ExceptionLevel level) {
        // TODO: 2020/10/14 异常入库,对此方法进行aop处理
    }

}
