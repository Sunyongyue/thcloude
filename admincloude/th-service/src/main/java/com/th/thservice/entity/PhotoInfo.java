package com.th.thservice.entity;

public class PhotoInfo extends BaseModel{
    private int parentId ;
    private String describe;
    private String path;
    private String dispalyType;
    private int sort;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDispalyType() {
        return dispalyType;
    }

    public void setDispalyType(String dispalyType) {
        this.dispalyType = dispalyType;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
