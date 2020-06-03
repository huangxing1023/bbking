package com.family.bbkingweb.controller;

import com.family.bbkingweb.aspect.PageView;
import com.family.bbkingweb.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pageView")
public class PageViewController {
//    @Autowired
//    private ArticleService articleService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RedisUtils redisUtil;

    /**
     * 访问一篇文章时，增加其浏览量:重点在的注解
     * @param articleId：文章id
     * @return
     */
    @PageView
    @RequestMapping("/getArticle")
    public String getArticle(String articleId) {
        try{
            //ArticleDO blog = articleService.getById(articleId);
            log.info("articleId = {}", articleId);
            String key = "articleId_"+articleId;
            Long view = redisUtil.size(key);
            log.info("redis 缓存中浏览数：{}", view);
            //直接从缓存中获取并与之前的数量相加
            //Long views = view + blog.getViews();
            //log.info("文章总浏览数：{}", views);
        } catch (Throwable e) {
            return  "/error";
        }
        return  "/index";
    }
}
