package cvut.fel.bilbo.controller.interceptors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Scope("singleton")
public class ShortLoggingStrategy implements LoggingStrategy{

    @Override
    public void logPreHandle(HttpServletRequest request) {
        log.info(request.getRequestURI() + ", sessionID:" + request.getSession().getId());
    }

    @Override
    public void logPostHandle(HttpServletRequest request) { }

}
