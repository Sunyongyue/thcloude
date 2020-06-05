package com.th.thservice.entity;

public class UpdataRecord extends BaseModel {

    private String use;
    private int useId;
    private String name;
    private int nameId;
    private String matching_protocol;
    private int matching_protocolId;
    private int falg;
    private int sort;

    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public int getMatching_protocolId() {
        return matching_protocolId;
    }

    public void setMatching_protocolId(int matching_protocolId) {
        this.matching_protocolId = matching_protocolId;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatching_protocol() {
        return matching_protocol;
    }

    public void setMatching_protocol(String matching_protocol) {
        this.matching_protocol = matching_protocol;
    }

    public int getFalg() {
        return falg;
    }

    public void setFalg(int falg) {
        this.falg = falg;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
