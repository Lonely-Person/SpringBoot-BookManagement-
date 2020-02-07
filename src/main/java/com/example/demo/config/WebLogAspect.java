//package com.example.demo.config;
//
//
//import com.example.demo.domain.AopLogEntity;
//import com.example.demo.service.AopLogService;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.lang.reflect.Method;
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.util.Arrays;
//
//@Aspect
//@Component
//public class WebLogAspect {
//
//    public static Log logger = LogFactory.getLog(WebLogAspect.class);
//
//    @Autowired
//    AopLogService aopLogService;
//
//    String userName;  //访问者
//    LocalDateTime visitTime;  //访问时间
//    String reqUrl;   //请求路径
//    String reqType;  //请求类型
//    String reqIp;    //访问者IP
//    Long interval;   //方法执行时间
//
//
//
//    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
//    public void webLog(){}
//
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        visitTime = LocalDateTime.now();
//        HttpSession session = request.getSession();
//        String userName = (String) session.getAttribute("userName");
//        reqUrl = request.getRequestURL().toString();
//        reqType = request.getMethod();
//        reqIp = request.getRemoteAddr();
//        // 记录下请求内容
//        logger.info("访问者 : " + userName);
//        logger.info("访问时间 : " + visitTime);
//        logger.info("URL : " + reqUrl);
//        logger.info("HTTP_METHOD : " + reqType);
//        logger.info("IP : " + reqIp);
//        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//
//    }
//
//    @After("webLog()")
//    public void doAfter(JoinPoint joinPoint) throws Throwable{
//        LocalDateTime leftTime = LocalDateTime.now();
//        Duration duration = Duration.between(visitTime, leftTime);
//        interval = duration.toMillis();
//
//        logger.info("响应时间 : " + duration);
//
//        AopLogEntity aopLogEntity = new AopLogEntity();
//        aopLogEntity.setUserName(userName);
//        aopLogEntity.setVisitTime(visitTime);
//        aopLogEntity.setReqUrl(reqUrl);
//        aopLogEntity.setReqType(reqType);
//        aopLogEntity.setReqIp(reqIp);
//        aopLogEntity.setIntervalTime(interval);
//
//        aopLogService.insertLog(aopLogEntity);
//
//
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        logger.info("RESPONSE : " + ret);
//    }
//
//}
