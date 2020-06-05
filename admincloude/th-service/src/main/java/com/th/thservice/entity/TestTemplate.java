package com.th.thservice.entity;

import java.util.HashMap;
import java.util.List;

public class TestTemplate extends BaseModel {
    //父级ID
    private Long parent_id;
    //模板名称
    private String testName;
    //测试目标
    private String testTarget;
    //测试流程
    private String content;
    //操作显隐
    private int operaFlag;
    //备注
    private String remarks;
    //属性0快速 1正常
    private int attribute;
    //排序
    private int sort;
    //工业0，民用1，公共2
    private int type;
   /* //一个模板多个目标，一个目标多个步骤
    private HashMap<TestTarget, List<TestStep>> templates;
*/

    // 非数据库字段
    //父级名称
    private String parentName;
    // 非数据库字段
    //等级
    private Integer level;
    // 非数据库字段
    //子级集合
    private List<TestTemplate> children;
    // 非数据库字段
    //懒加载hasChildren
     private Boolean hasChildren=false;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<TestTemplate> getChildren() {
        return children;
    }

    public void setChildren(List<TestTemplate> children) {
        this.children = children;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestTarget() {
        return testTarget;
    }

    public void setTestTarget(String testTarget) {
        this.testTarget = testTarget;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOperaFlag() {
        return operaFlag;
    }

    public void setOperaFlag(int operaFlag) {
        this.operaFlag = operaFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
