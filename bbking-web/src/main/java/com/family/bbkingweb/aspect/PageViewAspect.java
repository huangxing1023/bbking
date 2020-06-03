package com.family.bbkingweb.aspect;

import com.family.bbkingdao.entity.contribute.Contribution;
import com.family.bbkingweb.util.IpUtils;
import com.family.bbkingweb.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PageViewAspect {
    @Autowired
    private RedisUtils redisUtil;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * 切入点
     */
    @Pointcut("@annotation(com.family.bbkingweb.aspect.PageView)")
    public void PageViewAspect() {
        log.info("进入PageViewAspect（）");
    }

    @Pointcut("@annotation(com.family.bbkingweb.aspect.PraiseView)")
    public void praiseAspect() {
        log.info("进入praiseAspect（）");
    }

    /**
     * 切入处理
     * @param joinPoint
     * @return
     */
    @Around("PageViewAspect()")
    public  Object around(ProceedingJoinPoint joinPoint) {
        Object[] object = joinPoint.getArgs();
        Contribution contribution = (Contribution) object[0];
        log.info("contributionId:{}", contribution.getId());
        Object obj = null;
        try {
            String ipAddr = IpUtils.getIpAddr();
            log.info("ipAddr:{}", ipAddr);
            String key = "contributionId_" + contribution.getId();
            // 浏览量存入redis中
            Long num = redisUtil.add(key,ipAddr);
            if (num == 0) {
                log.info("该ip:{},访问的浏览量已经新增过了", ipAddr);
            }
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 点赞数量存储到redis里面
     * @param joinPoint
     * @return
     */
    @Around("praiseAspect()")
    public Object praise (ProceedingJoinPoint joinPoint) {
        Object[] object = joinPoint.getArgs();
        Contribution contribution = (Contribution) object[0];
        log.info("contributionId:{}", contribution.getId());
        Object obj = null;
        try {
            String ipAddr = IpUtils.getIpAddr();
            log.info("ipAddr:{}", ipAddr);
            String key = "contributionPraise_" + contribution.getId();
            // 浏览量存入redis中
            Long num = redisUtil.add(key,ipAddr);
            if (num == 0) {
                log.info("该ip:{},访问的浏览量已经新增过了", ipAddr);
            }
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return obj;
    }
}
