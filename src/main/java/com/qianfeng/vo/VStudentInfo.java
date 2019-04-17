package com.qianfeng.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class VStudentInfo {
    //学号



    private String no;

    private String name;

    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String cardno;

    private String school;

    private String education;

    private Integer gid;

    private Integer flag;

    private String email;

    private String qq;

    private String phone;

    private String introno;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCardno() {
        return cardno;
    }

    public String getSchool() {
        return school;
    }

    public String getEducation() {
        return education;
    }

    public Integer getGid() {
        return gid;
    }

    public Integer getFlag() {
        return flag;
    }

    public String getEmail() {
        return email;
    }

    public String getQq() {
        return qq;
    }

    public String getPhone() {
        return phone;
    }

    public String getIntrono() {
        return introno;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public String getPhoto() {
        return photo;
    }

    public String getGradeName() {
        return gradeName;
    }

    private String photo;

    public void setNo(String no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIntrono(String introno) {
        this.introno = introno;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    //所在的班级
    private String gradeName;


}
