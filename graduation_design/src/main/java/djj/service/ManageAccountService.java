package djj.service;

import djj.dao.ManageAccountDao;
import djj.domain.ManageAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageAccountService {
    @Autowired
    ManageAccountDao manageAccountDao;

    public ManageAccount getManageAccount(String username){
        return manageAccountDao.selectByAccountName(username);
    }

    public List<ManageAccount> selectAll(int pageNum,int pageSize){
        int beginIndex = (pageNum - 1) * pageSize;
        return manageAccountDao.selectAll(beginIndex,pageSize);
    }

    public int deleteByAccountName(String num) {
        int i = manageAccountDao.deleteManageAccount(num);
        if(i != 0){
            return i;
        }
        return 0;
    }

    public Boolean updateAccountPassword(String accountName, String accountPassword) {
        int i = manageAccountDao.updatePassword(accountName, accountPassword);
        return i != 0;
    }

    public Boolean insertAccount(String accountName, String accountPassword) {
        int i = manageAccountDao.insertAccount(accountName, accountPassword);
        if(i != 0){
            return true;
        }
        return false;
    }

    public List<ManageAccount> selectAllAccount(String num) {
        return manageAccountDao.selectAllAccount(num);
    }
}
