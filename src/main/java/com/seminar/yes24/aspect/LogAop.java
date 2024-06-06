package com.seminar.yes24.aspect;

import com.seminar.yes24.dto.common.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
// 이 클래스를 Aspect로 선언하여 AOP 기능을 구현
@Aspect
@Component
public class LogAop {

    @Pointcut("execution(* com.seminar.yes24.controller.*.*(..))")
    public void controllerPointcut() {}
    @Pointcut("@annotation(com.seminar.yes24.aspect.annotation.DoAopError)")
    private void DoAopError() {}

    @AfterReturning(value = "controllerPointcut()",returning = "returnObj")
    private void logReturnValue(Object returnObj) {

        if  (returnObj instanceof ResponseDto) {
            ResponseDto<?> responseDto = (ResponseDto<?>)returnObj;
            log.info("Return data: {}", responseDto.data());
        } else {
            log.info("Return value is not ResponseDto");
        }
    }

    // 포인트컷 표현식으로 대상 메서드를 지정합니다.
    @AfterThrowing(pointcut = "DoAopError()", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        // 예외 발생 후 실행할 로직을 여기에 작성합니다.
        log.info("AOP예외 발생!!!!!!!!!!! 비상!!!: " + exception.getMessage());
    }




}
