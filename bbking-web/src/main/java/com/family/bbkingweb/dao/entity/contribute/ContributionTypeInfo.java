package com.family.bbkingdao.entity.contribute;

import java.io.Serializable;
import java.util.List;

public class ContributionTypeInfo implements Serializable {

    private static final long serialVersionUID = 7011260203087436388L;
    private String typeId;
    private String typeName;
    private List<Contribution> contributions;


    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions = contributions;
    }
}
