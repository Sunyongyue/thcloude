package com.th.thservice.entity;

import java.util.List;

public class UpdateRecordInfo extends BaseModel {
    private int parentId;
    private String version;
    private String upTime;
    private int upcontent;
    private int sort;
    private List<UpdateContent> contents;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public int getUpcontent() {
        return upcontent;
    }

    public void setUpcontent(int upcontent) {
        this.upcontent = upcontent;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<UpdateContent> getContents() {
        return contents;
    }

    public void setContents(List<UpdateContent> contents) {
        this.contents = contents;
    }
}
