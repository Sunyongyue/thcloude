package com.th.thservice.entity;

public class TestTarget extends BaseModel {
    //测试模板id
    private Long testTemplateId;
    //测试目标内容
    private String content;
    private int sort;

    public Long getTestTemplateId() {
        return testTemplateId;
    }

    public void setTestTemplateId(Long testTemplateId) {
        this.testTemplateId = testTemplateId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
