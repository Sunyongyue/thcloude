package com.th.thservice.entity;
//液晶显示
public class HardwareLcd extends BaseModel {

    private String use;
    private String model;
    private String matching_protocol;
    private int sort;

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMatching_protocol() {
        return matching_protocol;
    }

    public void setMatching_protocol(String matching_protocol) {
        this.matching_protocol = matching_protocol;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
