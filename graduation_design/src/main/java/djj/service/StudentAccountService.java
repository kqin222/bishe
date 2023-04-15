package djj.service;

import djj.dao.StudentAccountDao;
import djj.domain.StudentAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAccountService {
    @Autowired
    private StudentAccountDao studentAccountDao;

    public StudentAccount getStudentAccount(String accountName){
        return studentAccountDao.selectByAccountName(accountName);
    }

    public Boolean insertStudentAccount(String accountName,String accountPassword){
        int i = studentAccountDao.insertStudentAccount(accountName, accountPassword);
        if(i != 0){
            return true;
        }
        return false;
    }

    public Boolean updateStudentAccountPassword(String accountName,String newPassword){
        int i = studentAccountDao.updateStudentAccount(accountName, newPassword);
        if(i != 0){
            return true;
        }
        return false;
    }

    public List<StudentAccount> getAllAccount(int pageNum,int pageSize){
        int beginIndex = (pageNum - 1) * pageSize;
        return studentAccountDao.selectAllAccountFenYe(beginIndex,pageSize);
    }

    public int deleteByAccountName(String num){
        int i = studentAccountDao.deleteStudentAccount(num);
        if(i != 0){
            return i;
        }
        return 0;
    }

    public List<StudentAccount> getAllAccountSL() {
        return studentAccountDao.selectAllStudentAccount();
    }
}
