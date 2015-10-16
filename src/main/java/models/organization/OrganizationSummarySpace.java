package models.organization;

import lombok.Data;

import java.util.UUID;

@Data
public class OrganizationSummarySpace {

    protected UUID guid;
    protected String name;
    protected int serviceCount;
    protected int appCount;
    protected int memDevTotal;
    protected int memProdTotal;

}
