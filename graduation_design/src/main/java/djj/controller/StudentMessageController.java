package djj.controller;

import djj.domain.StudentAccount;
import djj.domain.StudentMessage;
import djj.service.StudentAccountService;
import djj.service.StudentMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/studentMessage")
public class StudentMessageController {

    @Autowired
    private StudentMessageService studentMessageService;

    //判断学号是否存在
    @GetMapping("/1/{studentNum}")
    public String isAccountNameExist(@PathVariable String studentNum){
        boolean studentNumExist = studentMessageService.isStudentNumExist(studentNum);
        if(studentNumExist) {
            return "true";
        }
        return "false";
    }
    //查询所有学生信息
    @GetMapping("/2/pageNum/{pageNum}/pageSize/{pageSize}")
    public List<StudentMessage> selectAll(@PathVariable int pageNum,@PathVariable int pageSize){
        return studentMessageService.selectAll(pageNum,pageSize);
    }
    //查询单个学生信息
    @GetMapping("/3/studentNum/{studentNum}")
    public List<StudentMessage> selectAll(@PathVariable String studentNum){
        List<StudentMessage> studentMessages = new ArrayList<>();
        studentMessages.add(studentMessageService.getStudentMessageByNum(studentNum));
        return studentMessages;
    }
    //查询所有学生信息SL
    @GetMapping("/4")
    public int selectAllSL(){
        return studentMessageService.selectAllSL().size();
    }
//    //判断学号是否和姓名匹配
//    @GetMapping("/2/studentNum/{studentNum}/studentName/{studentName}")
//    public String isNumNameRight(@PathVariable String studentNum,@PathVariable String studentName){
//        System.out.println(studentName);
//        if(studentMessageService.isNumNameRight(studentNum,studentName)){
//            return "true";
//        }
//        return "false";
//    }



    //修改个人信息
    @PutMapping("/1")
    public String updatePersonalMessage(String num,String name,String sex, String dep, String major, String banji, String phone) throws UnsupportedEncodingException {

        //解决get请求中文乱码
        byte[] bytes1=name.getBytes("ISO-8859-1");
        byte[] bytes2=sex.getBytes("ISO-8859-1");
        byte[] bytes3=dep.getBytes("ISO-8859-1");
        byte[] bytes4=major.getBytes("ISO-8859-1");
        byte[] bytes5=banji.getBytes("ISO-8859-1");
        String ans1=new String(bytes1,"utf-8");
        String ans2=new String(bytes2,"utf-8");
        String ans3=new String(bytes3,"utf-8");
        String ans4=new String(bytes4,"utf-8");
        String ans5=new String(bytes5,"utf-8");

        int i = studentMessageService.updatePersonalMessage(num, ans1, ans2, ans3, ans4, ans5, phone);
        if(i != 0){
            return "true";
        }
        return "false";
    }




    //判断学号是否和姓名匹配
    @PostMapping("/2")
    public String isNumNameRight(String studentNum,String studentName){
        if(studentMessageService.isNumNameRight(studentNum,studentName)){
            return "true";
        }
        return "false";
    }
    //注册账户
    @PostMapping("/3")
    public String insertStudentMessage(String num,String name,String sex,String dep,String banji,String phone,String major){
        int i = studentMessageService.insertMessage(num, name, sex, dep, banji, phone, major);
        if(i != 0){
            return "true";
        }
        return "false";
    }



    //删除一行数据
    @DeleteMapping("/1")
    public String deleteRow(String num){
        int i = studentMessageService.deleteByAccountName(num);
        if(i != 0){
            return "true";
        }
        return "false";
    }
    //删除数据s
    @DeleteMapping("/2")
    public String deleteRows(@RequestBody List<StudentMessage> selection){
        System.out.println(selection);
        int i = 0;
        while(i != selection.size()){
            String s = deleteRow(selection.get(i).getStudentNum());
            if(s.equals("false")){
                return "false";
            }
            i++;
        }
        return "true";
    }


//    //更新数据
//    @PutMapping("/2")
//    public String updateRow(String studentNum,String studentName,String sex,String age,String dep,String banji,String phone,String major){
//        int i = studentMessageService.updatePersonalMessage(studentNum,studentName,sex,dep,major,banji,phone);studentMessageService.
//        return "ok";
//    }
}
