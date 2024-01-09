package cvut.fel.bilbo.controller.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public interface LoggingStrategy {

    Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);

    void logPreHandle(HttpServletRequest request);

    void logPostHandle(HttpServletRequest request);

}
