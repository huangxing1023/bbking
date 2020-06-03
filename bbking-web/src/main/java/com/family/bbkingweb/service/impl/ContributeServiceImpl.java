package com.family.bbkingservice.impl;

import com.family.bbkingdao.entity.contribute.Contribution;
import com.family.bbkingdao.entity.contribute.ContributionType;
import com.family.bbkingdao.entity.contribute.ContributionTypeInfo;
import com.family.bbkingdao.mapper.ContributeMapper;
import com.family.bbkingservice.ContributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service("contributeService")
public class ContributeServiceImpl implements ContributeService {
    @Autowired
    private ContributeMapper contributeMapper;
    @Override
    public int saveContribution(Contribution contribution) {
        return contributeMapper.saveContribution(contribution);
    }

    @Override
    public List<ContributionTypeInfo> getContributionTypeInfo() {
        List<ContributionTypeInfo> result = new ArrayList<>();
        List<ContributionType> contributionTypes = contributeMapper.getContributionType(new ContributionType());
        for (ContributionType contributionType:contributionTypes) {
            ContributionTypeInfo contributionTypeInfo = new ContributionTypeInfo();
            contributionTypeInfo.setTypeId(contributionType.getId());
            contributionTypeInfo.setTypeName(contributionType.getTypeName());
            Contribution contribution = new Contribution();
            contribution.setType(contributionType.getId());
            List<Contribution> contributions = contributeMapper.getContribution(contribution);
            contributionTypeInfo.setContributions(contributions);
            result.add(contributionTypeInfo);
        }
        return result;
    }

    @Override
    @Cacheable(value = "contribution", key = "#contribution.id")
    public Contribution getContributionById(Contribution contribution) {
        return contributeMapper.getContributionById(contribution);
    }

    @Override
    public List<Contribution> getContribution(@RequestParam("contribution") Contribution contribution) {
        return contributeMapper.getContribution(contribution);
    }

    @Override
    public int updateContribution(Contribution contribution) {
        return contributeMapper.updateContribution(contribution);
    }
}
