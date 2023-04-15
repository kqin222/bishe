package djj.domain;

import javax.xml.crypto.Data;
import java.util.Date;

public class StudentMessage {
    private String studentNum;
    private String studentName;

    private String sex;
    private String dep;
    private String major;
    private String banji;
    private String phone;

    public StudentMessage(String studentNum, String studentName) {
        this.studentNum = studentNum;
        this.studentName = studentName;
    }

    public StudentMessage() {
    }

    public StudentMessage(String studentNum, String studentName, String sex, String dep, String major, String banji, String phone) {
        this.studentNum = studentNum;
        this.studentName = studentName;
        this.sex = sex;
        this.dep = dep;
        this.major = major;
        this.banji = banji;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "StudentMessage{" +
                "studentNum='" + studentNum + '\'' +
                ", studentName='" + studentName + '\'' +
                ", sex='" + sex + '\'' +
                ", dep='" + dep + '\'' +
                ", major='" + major + '\'' +
                ", banji='" + banji + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
