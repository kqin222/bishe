package djj.service;

import djj.dao.StudentAccountDao;
import djj.dao.StudentMessageDao;
import djj.domain.StudentMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMessageService {

    @Autowired
    private StudentMessageDao studentMessageDao;

    public boolean isStudentNumExist(String studentNum){
        StudentMessage studentMessage = studentMessageDao.selectByStudentNum(studentNum);
        if (studentMessage != null){
            return true;
        }
        return false;
    }

    public boolean isNumNameRight(String studentNum,String studentName){
        System.out.println("搜索的学号是"+studentNum);
        StudentMessage studentMessage = studentMessageDao.selectByStudentNum(studentNum);
        return studentMessage.getStudentName().equals(studentName);
    }

    public StudentMessage getStudentMessageByNum(String num){
        System.out.println("查询学号为：=---"+num);
        StudentMessage studentMessage = studentMessageDao.selectByStudentNum(num);
        System.out.println(studentMessage);
        return studentMessage;
    }

    public int updatePersonalMessage(String num, String name, String sex, String dep, String major, String banji, String phone) {
        return studentMessageDao.updatePersonalMessageByNum(num,name,sex,dep,major,banji,phone);
    }

    public List<StudentMessage> selectAll(int pageNum,int pageSize){
        int beginIndex = (pageNum - 1) * pageSize;
        return studentMessageDao.selectAll(beginIndex,pageSize);
    }

    public int deleteByAccountName(String num) {
        return studentMessageDao.deleteByAccountName(num);
    }

    public int insertMessage(String num, String name, String sex, String dep, String banji, String phone, String major) {
        int i = studentMessageDao.insertMessage(num, name, sex, dep, banji, phone, major);
        return i;
    }

    public List<StudentMessage> selectAllSL() {
        return studentMessageDao.selectAllSL();
    }
}
