package com.th.thservice.entity;

public class TestStep extends BaseModel {
    //测试目标ID
    private Long testTargetId;
    //测试步骤内容
    private String content;
    private  int sort;

    public Long getTestTargetId() {
        return testTargetId;
    }

    public void setTestTargetId(Long testTargetId) {
        this.testTargetId = testTargetId;
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
