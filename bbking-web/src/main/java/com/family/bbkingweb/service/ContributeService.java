package com.family.bbkingweb.service;

import com.family.bbkingweb.dao.entity.contribute.Contribution;
import com.family.bbkingweb.dao.entity.contribute.ContributionTypeInfo;

import java.util.List;

public interface ContributeService {
    int saveContribution(Contribution contribution);
    List<ContributionTypeInfo> getContributionTypeInfo();
    Contribution getContributionById(Contribution contribution);
    List<Contribution> getContribution(Contribution contribution);
    int updateContribution(Contribution contribution);

}
