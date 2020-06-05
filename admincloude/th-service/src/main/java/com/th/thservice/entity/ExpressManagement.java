package com.th.thservice.entity;



public class ExpressManagement {
    private int id;

    private String SrType;
    //收寄类型
    private String ExpressCompany;
    //快递公司
    private String Date;
    //日期
    private String Addressee;
    //收件人
    private String Sender;
    //寄件人
    private String Company;
    //收件公司
    private int ExpressNum;
    //快递单号
    private String Address;
    //地址
    private String Content;
    //详情
    private String ExpressType;
    //分类
    private String Remark;
    //备注

    public ExpressManagement(){}
    public ExpressManagement(String Date, String Addressee, String Sender, String Company, int ExpressNum, String Address,
                             String Content, String ExpressType, String Remark,int id,String SrType,String ExpressCompany){
        this.Date=Date;
        this.Addressee=Addressee;
        this.Sender=Sender;
        this.Company=Company;
        this.ExpressNum=ExpressNum;
        this.ExpressType=ExpressType;
        this.Remark=Remark;
        this.Content=Content;
        this.id=id;
        this.ExpressCompany=ExpressCompany;
        this.ExpressType=ExpressType;


    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAddressee() {
        return Addressee;
    }

    public void setAddressee(String addressee) {
        Addressee = addressee;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public int getExpressNum() {
        return ExpressNum;
    }

    public void setExpressNum(int expressNum) {
        ExpressNum = expressNum;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getExpressType() {
        return ExpressType;
    }

    public void setExpressType(String expressType) {
        ExpressType = expressType;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrType() {
        return SrType;
    }

    public void setSrType(String srType) {
        SrType = srType;
    }

    public String getExpressCompany() {
        return ExpressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        ExpressCompany = expressCompany;
    }




}
