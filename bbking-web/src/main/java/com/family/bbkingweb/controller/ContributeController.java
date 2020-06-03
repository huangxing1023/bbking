package com.family.bbkingweb.controller;

import com.family.bbkingdao.entity.common.PageBean;
import com.family.bbkingdao.entity.user.User;
import com.family.bbkingdao.entity.contribute.Contribution;
import com.family.bbkingdao.entity.contribute.ContributionTypeInfo;
import com.family.bbkingservice.ContributeService;
import com.family.bbkingweb.aspect.PageView;
import com.family.bbkingweb.aspect.PraiseView;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("contribute")
public class ContributeController {
    @Autowired
    private ContributeService contributeService;

    @RequestMapping("addContribution")
    @ResponseBody
    public Map<String,Object> addContribution(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result = new HashedMap();
        String title = request.getParameter("title");
        String imageFieldId = request.getParameter("imageFieldId");
        String videoFieldId = request.getParameter("videoFieldId");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String type = request.getParameter("type");
        Contribution contribution = new Contribution();
        contribution.setId(UUID.randomUUID().toString());
        contribution.setImageFieldId(imageFieldId);
        contribution.setVideoFieldId(videoFieldId);
        contribution.setTitle(title);
        contribution.setCoin(0);
        contribution.setPraise(0);
        contribution.setView(0);
        contribution.setFlag("1");
        contribution.setType(type);
        contribution.setCreator(user.getId());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sf.format(new Date());
        contribution.setCreateTime(date);
        int flag = contributeService.saveContribution(contribution);
        return result;
    }

    @RequestMapping("getContributionTypeInfo")
    @ResponseBody
    public Map<String,Object> getContributionTypeInfo(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result = new HashedMap();
        List<ContributionTypeInfo> contributionTypeInfos = contributeService.getContributionTypeInfo();
        result.put("data",contributionTypeInfos);
        result.put("msg","success");
        return result;
    }

    @RequestMapping("getContribution")
    @ResponseBody
    public Map<String,Object> getContribution(Contribution contribution){
        Map<String,Object> result = new HashedMap();
        List<Contribution> contributions = contributeService.getContribution(contribution);
        result.put("msg","success");
        result.put("data",contributions);
        return result;
    }

    @RequestMapping("getContributionPage")
    @ResponseBody
    public Map<String,Object> getContributionPage(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result = new HashedMap();
        Contribution contribution = new Contribution();
        contribution.setId(request.getParameter("id"));
        contribution.setType(request.getParameter("type"));
        List<Contribution> contributions = contributeService.getContribution(contribution);
        result.put("msg","success");
        result.put("data",contributions);
        return result;
    }

    @PraiseView
    @RequestMapping("praiseContribution")
    @ResponseBody
    public Map<String,Object> praiseContribution(Contribution contribution){
        Map<String,Object> result = new HashedMap();
        Contribution contribution1 = contributeService.getContributionById(contribution);
        int praise = contribution1.getPraise();
        result.put("msg","success");
        result.put("data",praise+1);
        return result;
    }
}
