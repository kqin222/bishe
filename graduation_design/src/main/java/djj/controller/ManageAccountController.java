package djj.controller;

import djj.domain.ManageAccount;
import djj.domain.StudentAccount;
import djj.service.ManageAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manageAccount")
public class ManageAccountController {
    @Autowired
    ManageAccountService manageAccountService;

    //检查账号和密码是否匹配
    @GetMapping("/1/username/{username}/password/{password}")
    public String checkAccount(@PathVariable String username, @PathVariable String password){
        ManageAccount manageAccount = manageAccountService.getManageAccount(username);

        if (manageAccount.getPassword().equals(password)) {
            return "true";
        }
        return "false";
    }

    //查询所有管理员账户（分页）
    @GetMapping("/2/pageNum/{pageNum}/pageSize/{pageSize}")
    public List<ManageAccount> checkAccount(@PathVariable int pageNum, @PathVariable int pageSize){
        return manageAccountService.selectAll(pageNum,pageSize);
    }

    //更新账户的密码
    @GetMapping("/3/accountName/{accountName}/accountPassword/{accountPassword}")
    public String updatePassword(@PathVariable String accountName,@PathVariable String accountPassword){
        Boolean aBoolean = manageAccountService.updateAccountPassword(accountName, accountPassword);
        if (aBoolean){
            return "true";
        }
        return "false";
    }

    //查询账户
    @GetMapping("/4/accountName/{accountName}")
    public List<ManageAccount> updatePassword(@PathVariable String accountName){
        List<ManageAccount>manageAccounts = new ArrayList<>();
        manageAccounts.add(manageAccountService.getManageAccount(accountName));
        return manageAccounts;
    }

    //查询所有管理员账户数量（不分页）
    @GetMapping("/5/num/{num}")
    public int checkAccount(@PathVariable String num){
        return manageAccountService.selectAllAccount(num).size();
    }



    //删除一行管理员账户
    @DeleteMapping("/1")
    public String deleteRow(String num){
        System.out.println(num);
        int i = manageAccountService.deleteByAccountName(num);
        if(i != 0){
            return "true";
        }
        return "false";
    }
    //删除duohang账户
    @DeleteMapping("/2")
    public String deleteRows(@RequestBody List<ManageAccount> selection){
        System.out.println(selection);
        int len = selection.size();
        int i = 0;int log = 1;//log变零则表示失败
        while(i != len){
            String s = deleteRow(selection.get(i).getUsername());
            if(s.equals("false")){
                log = 0;
            }
            i++;
        }
        return "true";
    }


    //注册账户
    @PostMapping("/1/accountName/{accountName}/accountPassword/{accountPassword}")
    public String insertAccount(@PathVariable String accountName,@PathVariable String accountPassword){
        Boolean b = manageAccountService.insertAccount(accountName, accountPassword);
        if (b){
            return "true";//注册成功
        }
        return "false";
    }
}

