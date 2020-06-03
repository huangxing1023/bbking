package com.family.bbkingweb.task;

import com.family.bbkingdao.entity.contribute.Contribution;
import com.family.bbkingservice.ContributeService;
import com.family.bbkingweb.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ArticleViewTask {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private ContributeService contributeService;

    // 每天凌晨一点执行
    @Scheduled(cron = "0 0 1 * * ? ")
    @Transactional(rollbackFor=Exception.class)
    public void createHyperLog() {
        log.info("浏览量入库开始");
        List<Contribution> contributionList = contributeService.getContribution(new Contribution());
        for(int i=0;i<contributionList.size();i++){
//            String key = "contributionId_"+contributionList.get(i).getId();
//            //int view = contributionList.get(i).getView();
//            //Long redisView = redisTemplate.opsForValue().size(key)//size(key);
//            if(redisView!=null && redisView>0){
//                int view = contributionList.get(i).getView();//系统中的浏览量
//                contributionList.get(i).setView(view+Integer.parseInt(String.valueOf(redisView)));
//                int num = contributeService.updateContribution(contributionList.get(i));
//                if(num != 0){
//                    log.info("数据库更新后的浏览量为：{}", contributionList.get(i).getView());
//                    redisUtil.del(key);
//                }
//            }
        }
        log.info("浏览量入库结束");
    }

}

