package djj.controller;

import djj.domain.StudentAccount;
import djj.service.StudentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/studentAccount")
public class StudentAccountController {
    @Autowired
    private StudentAccountService studentAccountService;

    //判断账户是否存在
    @GetMapping("/1/{accountName}")
    public String isAccountNameExist(@PathVariable String accountName){
        StudentAccount studentAccount = studentAccountService.getStudentAccount(accountName);
        System.out.println(accountName);
        if(studentAccount == null) {
            return "false";
        }
        return "true";
    }
    //检查账号和密码是否匹配
    @GetMapping("/2/accountName/{accountName}/accountPassword/{accountPassword}")
    public String checkAccount(@PathVariable String accountName,@PathVariable String accountPassword){
        StudentAccount studentAccount = studentAccountService.getStudentAccount(accountName);
        if (studentAccount.getAccountPassword().equals(accountPassword)) {
            return "true";
        }
        return "false";
    }
    //更新账户的密码
    @GetMapping("/3/accountName/{accountName}/accountPassword/{accountPassword}")
    public String updatePassword(@PathVariable String accountName,@PathVariable String accountPassword){
        Boolean aBoolean = studentAccountService.updateStudentAccountPassword(accountName, accountPassword);
        if (aBoolean){
            return "true";
        }
        return "false";
    }
    //查询所有学生账号密码
    @GetMapping("/4/num/{num}/pageNum/{pageNum}/pageSize/{pageSize}")
    public List<StudentAccount> selectAllAccount(@PathVariable String num, @PathVariable int pageNum, @PathVariable int pageSize){
        return studentAccountService.getAllAccount(pageNum,pageSize);
    }
    //删除一行学生账户
    @DeleteMapping("/5")
    public String deleteRow(String num){
        int i = studentAccountService.deleteByAccountName(num);
        if(i != 0){
            return "true";
        }
        return "false";
    }
    //通过用户名查新学生账户信息
    @GetMapping("/6/accountName/{accountName}")
    public List<StudentAccount> selectByAccountName(@PathVariable String accountName){
        System.out.println(studentAccountService.getStudentAccount(accountName));
        List<StudentAccount> studentAccounts=new ArrayList<>();
        studentAccounts.add(studentAccountService.getStudentAccount(accountName));
        return studentAccounts;
    }
    //查询所有学生账号shuliang
    @GetMapping("/7")
    public int selectAllAccount(){
        return studentAccountService.getAllAccountSL().size();
    }



    //删除duohang学生账户
    @DeleteMapping("/1")
    public String deleteRows(@RequestBody List<StudentAccount> selection){
        int len = selection.size();
        int i = 0;int log = 1;//log变零则表示失败
        while(i != len){
            String s = deleteRow(selection.get(i).getAccountName());
            if(s.equals("false")){
                log = 0;
            }
            i++;
        }
        return "true";
    }




    //注册账户
    @PostMapping("/1/accountName/{accountName}/accountPassword/{accountPassword}")
    public String insertStudentAccount(@PathVariable String accountName,@PathVariable String accountPassword){
        Boolean b = studentAccountService.insertStudentAccount(accountName, accountPassword);
        if (b){
            return "true";//注册成功
        }
        return "false";
    }

}
