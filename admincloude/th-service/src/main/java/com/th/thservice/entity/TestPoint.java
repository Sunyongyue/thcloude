package com.th.thservice.entity;

import java.util.List;

public class TestPoint extends BaseModel {
    private int testTermId;
    private String content;
    private String test_step;
    private String testResult;
    private int status;
    private String remarks;
    private List<String> testStep;

    public int getTestTermId() {
        return testTermId;
    }

    public void setTestTermId(int testTermId) {
        this.testTermId = testTermId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTest_step() {
        return test_step;
    }

    public void setTest_step(String test_step) {
        this.test_step = test_step;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<String> getTestStep() {
        return testStep;
    }

    public void setTestStep(List<String> testStep) {
        this.testStep = testStep;
    }
}
