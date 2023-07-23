package com.vishnu.Nectar.aspects;

import com.vishnu.Nectar.repository.AuditLogRepository;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//@Aspect
//@Component
//public class AuditLogAspect {
//
//    private final AuditLogRepository auditLogRepository;
//
//    @Autowired
//    public AuditLogAspect(AuditLogRepository auditLogRepository){
//        this.auditLogRepository = auditLogRepository;
//    }
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
//    private void requestMapping(){}
//
//    private void logBeforeRequestMapping(JoinPoint jointPoint){
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        String requestEndPoint = request.getRequestURI();
//        String requestType = request.getMethod();
//    }
//}
