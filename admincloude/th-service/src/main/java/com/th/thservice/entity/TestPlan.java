package com.th.thservice.entity;

import java.util.HashMap;
import java.util.List;

public class TestPlan extends BaseModel {
    private String planName;
    private String operator;
    private int planStatus;
    private String planProgress;
    private String testName;
    private Long[] testNames;
    private String planCompleteTime;
    private int attribute;
    private int type;
    private int sort;

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long[] getTestNames() {
        return testNames;
    }

    public void setTestNames(Long[] testNames) {
        this.testNames = testNames;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(int planStatus) {
        this.planStatus = planStatus;
    }

    public String getPlanProgress() {
        return planProgress;
    }

    public void setPlanProgress(String planProgress) {
        this.planProgress = planProgress;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getPlanCompleteTime() {
        return planCompleteTime;
    }

    public void setPlanCompleteTime(String planCompleteTime) {
        this.planCompleteTime = planCompleteTime;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
