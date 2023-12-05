package cvut.fel.controller.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Resource: https://www.baeldung.com/spring-mvc-handlerinterceptor
 */
@Component
public class LoggerInterceptor implements HandlerInterceptor {

    private final LoggingStrategy strategy;

    @Autowired
    public LoggerInterceptor(ShortLoggingStrategy shortLoggingStrategy,
                             DetailedLoggingStrategy detailedLoggingStrategy,
                             @Value("${requestLogging.detail}") Boolean detailedLogging) {

        strategy = detailedLogging ? detailedLoggingStrategy : shortLoggingStrategy;
    }

    /*
    The preHandle() method is called before the actual controller is executed. It is
    called from FE to BE. We can use this method to intercept the request and do something.
     */
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

            strategy.logPreHandle(request);

        return true;
    }

    /*
    The postHandle() method is called after the controller is executed. It is called
    from BE to FE. We can use this method to log data manipulation.
     */
    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {

        strategy.logPostHandle(request);
    }

}
