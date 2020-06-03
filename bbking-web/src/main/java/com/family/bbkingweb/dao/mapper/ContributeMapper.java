package com.family.bbkingweb.dao.mapper;

import com.family.bbkingweb.dao.entity.contribute.Contribution;
import com.family.bbkingweb.dao.entity.contribute.ContributionType;

import java.util.List;

public interface ContributeMapper {
    int saveContribution(Contribution contribution);
    Contribution getContributionById(Contribution contribution);
    List<ContributionType> getContributionType(ContributionType contributionType);
    List<Contribution> getContribution(Contribution contribution);
    int updateContribution(Contribution contribution);
}
