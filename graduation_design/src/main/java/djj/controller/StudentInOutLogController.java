package djj.controller;

import djj.domain.Request;
import djj.domain.StudentAccount;
import djj.domain.StudentInOutLog;
import djj.domain.StudentMessage;
import djj.service.StudentAccountService;
import djj.service.StudentInOutLogService;
import djj.service.StudentMessageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.time.LocalTime.now;

    @RestController
    @RequestMapping("/inOutLog")
public class StudentInOutLogController {

    @Autowired
    private StudentInOutLogService studentInOutLogService;
    @Autowired
    private StudentMessageService studentMessageService;

    @GetMapping("/1/num/{num}/pageNum/{pageNum}/pageSize/{pageSize}")
    @ResponseBody
    public List<StudentInOutLog> getAllCheckedLog(@PathVariable String num, @PathVariable int pageNum, @PathVariable int pageSize) {
        return studentInOutLogService.getAllLogByIsCheckedFenYe("1", num, pageNum, pageSize);
    }

    @GetMapping("/2/num/{num}/date/{date}/pageNum/{pageNum}/pageSize/{pageSize}")
    @ResponseBody
    public List<StudentInOutLog> getAllCheckedLogByDate(@PathVariable String num,@PathVariable String date, @PathVariable int pageNum, @PathVariable int pageSize) throws ParseException {
//        String s = studentInOutLogService.utcStrToBeiJingStr(date);
        return studentInOutLogService.getAllLogByIsCheckedFenYeByDate("1",num, date, pageNum, pageSize);
    }

    @GetMapping("/3/num/{num}/pageNum/{pageNum}/pageSize/{pageSize}")
    @ResponseBody
    public List<StudentInOutLog> getAllRequestByNum(@PathVariable String num, @PathVariable int pageNum, @PathVariable int pageSize) {
        List<StudentInOutLog> allRequestByNum = studentInOutLogService.getAllRequestByNum(num, pageNum, pageSize);
        int len = allRequestByNum.size();int i = 0;
        while(len != i){
            if (allRequestByNum.get(i).getChecked().equals("1")){
                allRequestByNum.get(i).setChecked("已通过");
            } else if (allRequestByNum.get(i).getChecked().equals("0")) {
                allRequestByNum.get(i).setChecked("未处理");
            } else if (allRequestByNum.get(i).getChecked().equals("2")) {
                allRequestByNum.get(i).setChecked("被拒绝");
            } else if (allRequestByNum.get(i).getChecked().equals("3")) {
                allRequestByNum.get(i).setChecked("已催促");
            }
            i++;
        }
        return allRequestByNum;
    }

    @GetMapping("/4/num/{num}/pageNum/{pageNum}/pageSize/{pageSize}/checked/{checked}")
    @ResponseBody
    public List<StudentInOutLog> getAllRequestByNum(@PathVariable String num, @PathVariable int pageNum, @PathVariable int pageSize, @PathVariable String checked) throws UnsupportedEncodingException {

//
        byte[] bytes=checked.getBytes("ISO-8859-1");
        String ans=new String(bytes,"utf-8");

        if(Objects.equals(ans, "被拒绝")){
            checked = "2";
        } else if (Objects.equals(ans, "未处理")) {
            checked = "0";
        } else if (Objects.equals(ans, "已通过")) {
            checked = "1";
        } else if (Objects.equals(ans, "已催促")) {
            checked = "3";
        }
        List<StudentInOutLog> allRequestByNum = studentInOutLogService.getAllRequestByNumAndChecked(num, pageNum, pageSize, checked);
//
//
//
        int len = allRequestByNum.size();int i = 0;
        while(len != i){
            if (allRequestByNum.get(i).getChecked().equals("1")){
                allRequestByNum.get(i).setChecked("已通过");
            } else if (allRequestByNum.get(i).getChecked().equals("0")) {
                allRequestByNum.get(i).setChecked("未处理");
            } else if (allRequestByNum.get(i).getChecked().equals("2")) {
                allRequestByNum.get(i).setChecked("被拒绝");
            } else if (allRequestByNum.get(i).getChecked().equals("3")) {
                allRequestByNum.get(i).setChecked("已催促");
            }
            i++;
        }
        System.out.println(allRequestByNum);
        return allRequestByNum;
//        return studentInOutLogService.getAllRequestByNumAndChecked(num, pageNum, pageSize, checked);
    }

    @GetMapping("/5/num/{num}")
    @ResponseBody
    public StudentMessage getAllCheckedLog(@PathVariable String num) {
        StudentMessage studentMessageByNum = studentMessageService.getStudentMessageByNum(num);
        return studentMessageByNum;
    }

    @GetMapping("/6/num/{num}/address/{address}/pageNum/{pageNum}/pageSize/{pageSize}")
    @ResponseBody
    public List<StudentInOutLog> getAllCheckedLogByAddress(@PathVariable String num,@PathVariable String address, @PathVariable int pageNum, @PathVariable int pageSize) throws UnsupportedEncodingException {

        //解决get请求中文乱码
        byte[] bytes=address.getBytes("ISO-8859-1");
        String ans=new String(bytes,"utf-8");



        return studentInOutLogService.getAllLogByIsCheckedFenYeByAddress("1",num, ans, pageNum, pageSize);
    }

        @GetMapping("/7/num/{num}/date/{date}/address/{address}/pageNum/{pageNum}/pageSize/{pageSize}")
        @ResponseBody
        public List<StudentInOutLog> getAllCheckedLogByAddressAndDate(@PathVariable String num,@PathVariable String date,@PathVariable String address, @PathVariable int pageNum, @PathVariable int pageSize) throws UnsupportedEncodingException, ParseException {
            //解决get请求中文乱码
            byte[] bytes=address.getBytes("ISO-8859-1");
            String ans=new String(bytes,"utf-8");

//            String s = studentInOutLogService.utcStrToBeiJingStr(date);

            return studentInOutLogService.getAllLogByIsCheckedFenYeByAddressAndDate("1",num,date, ans, pageNum, pageSize);
        }

        @GetMapping("/8/num/{num}/pageNum/{pageNum}/pageSize/{pageSize}/date/{date}")
        @ResponseBody
        public List<StudentInOutLog> getAllRequestByDate(@PathVariable String num, @PathVariable int pageNum, @PathVariable int pageSize, @PathVariable String date) {
            List<StudentInOutLog> allRequestByNum = studentInOutLogService.getAllRequestByNumAndDate(num, pageNum, pageSize, date);
            int len = allRequestByNum.size();int i = 0;
            while(len != i){
                if (allRequestByNum.get(i).getChecked().equals("1")){
                    allRequestByNum.get(i).setChecked("已通过");
                } else if (allRequestByNum.get(i).getChecked().equals("0")) {
                    allRequestByNum.get(i).setChecked("未处理");
                } else if (allRequestByNum.get(i).getChecked().equals("2")) {
                    allRequestByNum.get(i).setChecked("被拒绝");
                } else if (allRequestByNum.get(i).getChecked().equals("3")) {
                    allRequestByNum.get(i).setChecked("已催促");
                }
                i++;
            }
            return allRequestByNum;
        }

        @GetMapping("/9/num/{num}/pageNum/{pageNum}/pageSize/{pageSize}/date/{date}/checked/{checked}")
        @ResponseBody
        public List<StudentInOutLog> getAllRequestByDateAndChecked(@PathVariable String num, @PathVariable int pageNum, @PathVariable int pageSize, @PathVariable String date,@PathVariable String checked) throws UnsupportedEncodingException {

            byte[] bytes=checked.getBytes("ISO-8859-1");
            String ans=new String(bytes,"utf-8");

            if(Objects.equals(ans, "被拒绝")){
                checked = "2";
            } else if (Objects.equals(ans, "未处理")) {
                checked = "0";
            } else if (Objects.equals(ans, "已通过")) {
                checked = "1";
            } else if (Objects.equals(ans, "已催促")) {
                checked = "3";
            }

            List<StudentInOutLog> allRequestByNum = studentInOutLogService.getAllRequestByNumAndDate_Checked(num, pageNum, pageSize, date,checked);


            int len = allRequestByNum.size();int i = 0;
            while(len != i){
                if (allRequestByNum.get(i).getChecked().equals("1")){
                    allRequestByNum.get(i).setChecked("已通过");
                } else if (allRequestByNum.get(i).getChecked().equals("0")) {
                    allRequestByNum.get(i).setChecked("未处理");
                } else if (allRequestByNum.get(i).getChecked().equals("2")) {
                    allRequestByNum.get(i).setChecked("被拒绝");
                } else if (allRequestByNum.get(i).getChecked().equals("3")) {
                    allRequestByNum.get(i).setChecked("已催促");
                }
                i++;
            }
            return allRequestByNum;

//            return studentInOutLogService.getAllRequestByNumAndDate_Checked(num, pageNum, pageSize, date,checked);
        }
        //查询所有进校请求
        @GetMapping("/10/pageNum/{pageNum}/pageSize/{pageSize}")
        @ResponseBody
        public List<StudentInOutLog> getAllRequest(@PathVariable int pageNum, @PathVariable int pageSize) {
            return studentInOutLogService.getAllRequest(pageNum,pageSize);
        }

        //查询所有未处理和催促的进校请求
        @GetMapping("/11/pageNum/{pageNum}/pageSize/{pageSize}")
        @ResponseBody
        public List<StudentInOutLog> getAllInRequestNoRes(@PathVariable int pageNum, @PathVariable int pageSize) {
            List<StudentInOutLog> allRequestByNum = studentInOutLogService.getAllInRequestNoRes(pageNum,pageSize);
            int len = allRequestByNum.size();int i = 0;
            while(len != i){
                if (allRequestByNum.get(i).getChecked().equals("1")){
                    allRequestByNum.get(i).setChecked("已通过");
                } else if (allRequestByNum.get(i).getChecked().equals("0")) {
                    allRequestByNum.get(i).setChecked("未处理");
                } else if (allRequestByNum.get(i).getChecked().equals("2")) {
                    allRequestByNum.get(i).setChecked("被拒绝");
                } else if (allRequestByNum.get(i).getChecked().equals("3")) {
                    allRequestByNum.get(i).setChecked("已催促");
                }
                i++;
            }
            return allRequestByNum;
        }

        //按姓名搜进校请求
        @GetMapping("/12/accountName/{accountName}")
        @ResponseBody
        public List<StudentInOutLog> getAllInRequestNoRes(@PathVariable String accountName) {
            List<StudentInOutLog> studentInOutLogs = new ArrayList<>();
            studentInOutLogs.add(studentInOutLogService.getInRequestByName(accountName));
            List<StudentInOutLog> allRequestByNum = studentInOutLogs;
            int len = allRequestByNum.size();int i = 0;
            while(len != i){
                if (allRequestByNum.get(i).getChecked().equals("1")){
                    allRequestByNum.get(i).setChecked("已通过");
                } else if (allRequestByNum.get(i).getChecked().equals("0")) {
                    allRequestByNum.get(i).setChecked("未处理");
                } else if (allRequestByNum.get(i).getChecked().equals("2")) {
                    allRequestByNum.get(i).setChecked("被拒绝");
                } else if (allRequestByNum.get(i).getChecked().equals("3")) {
                    allRequestByNum.get(i).setChecked("已催促");
                }
                i++;
            }
            return allRequestByNum;
        }

        //查询所有未处理和催促的请假请求
        @GetMapping("/13/pageNum/{pageNum}/pageSize/{pageSize}")
        @ResponseBody
        public List<StudentInOutLog> getAllOutRequestNoRes(@PathVariable int pageNum, @PathVariable int pageSize) {
            List<StudentInOutLog> allRequestByNum = studentInOutLogService.getAllOutRequestNoRes(pageNum,pageSize);
            int len = allRequestByNum.size();int i = 0;
            while(len != i){
                if (allRequestByNum.get(i).getChecked().equals("1")){
                    allRequestByNum.get(i).setChecked("已通过");
                } else if (allRequestByNum.get(i).getChecked().equals("0")) {
                    allRequestByNum.get(i).setChecked("未处理");
                } else if (allRequestByNum.get(i).getChecked().equals("2")) {
                    allRequestByNum.get(i).setChecked("被拒绝");
                } else if (allRequestByNum.get(i).getChecked().equals("3")) {
                    allRequestByNum.get(i).setChecked("已催促");
                }
                i++;
            }
            return allRequestByNum;
        }

        //按姓名搜请假请求
        @GetMapping("/14/accountName/{accountName}")
        @ResponseBody
        public List<StudentInOutLog> getAllOutRequestNoRes(@PathVariable String accountName) {
            List<StudentInOutLog> studentInOutLogs = new ArrayList<>();
            studentInOutLogs.add(studentInOutLogService.getOutRequestByName(accountName));
            List<StudentInOutLog> allRequestByNum = studentInOutLogs;
            int len = allRequestByNum.size();int i = 0;
            while(len != i){
                if (allRequestByNum.get(i).getChecked().equals("1")){
                    allRequestByNum.get(i).setChecked("已通过");
                } else if (allRequestByNum.get(i).getChecked().equals("0")) {
                    allRequestByNum.get(i).setChecked("未处理");
                } else if (allRequestByNum.get(i).getChecked().equals("2")) {
                    allRequestByNum.get(i).setChecked("被拒绝");
                } else if (allRequestByNum.get(i).getChecked().equals("3")) {
                    allRequestByNum.get(i).setChecked("已催促");
                }
                i++;
            }
            return allRequestByNum;
        }

        //按学号搜是否存在请求(未处理的)
        @GetMapping("/15/num/{num}")
        @ResponseBody
        public String getIsExistRequest(@PathVariable String num) {
            if(studentInOutLogService.getRequestByNum(num) == 0){
                return "false";
            }else{
                return "true";
            }
        }

        //查询所有进出记录（被同意且时间过了）
        @GetMapping("/16/pageNum/{pageNum}/pageSize/{pageSize}")
        @ResponseBody
        public List<StudentInOutLog> getAllInOutLog(@PathVariable int pageNum, @PathVariable int pageSize) {
            return studentInOutLogService.getAllInOutLog(pageNum,pageSize);
        }

        //查询所有进出记录（被同意且时间过了）
        @GetMapping("/17/num/{num}")
        @ResponseBody
        public int getAllInOutLogByNum(@PathVariable int num) throws ParseException {
            System.out.println(num);
            return studentInOutLogService.getAllInOutLogByNum(num).size();
        }

        //查询所有进出请求（未被审批0、3）
        @GetMapping("/18/num/{num}")
        @ResponseBody
        public int getAllReqByNum(@PathVariable String num) throws ParseException {
            return studentInOutLogService.getAllReqByNum(num).size();
        }

        //查询所有进出记录（被同意且时间过了）
        @GetMapping("/19")
        @ResponseBody
        public int getAllInOutLogByNum() throws ParseException {
            return studentInOutLogService.getAllInOutLogSL().size();
        }

        //查询所有进请求（正在申请中）
        @GetMapping("/20")
        @ResponseBody
        public int getAllReqSL() throws ParseException {
            return studentInOutLogService.getAllReqSL().size();
        }

        //查询所有出请求（正在申请中）
        @GetMapping("/21")
        @ResponseBody
        public int getAllReqSL1() throws ParseException {
            return studentInOutLogService.getAllReqSL1().size();
        }




    //提交申请
    @PostMapping("/1")
    public String insertStudentRequest(String startAddress,String purposeAddress, String date1, String date2, String reason, String userNum) throws ParseException {
        try {
            System.out.println(studentInOutLogService.utcStrToBeiJingStr(date1));
        } catch (ParseException e) {
            System.out.println("进校时间为空");
        }
        try {
            System.out.println(studentInOutLogService.utcStrToBeiJingStr(date2));
        } catch (ParseException e) {
            System.out.println("出校时间为空");
        }
        //检验开始结束时间是否合规
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date dateStart = null;
        dateStart = sdf.parse(date1);
        Date dateEnd = null;
        dateEnd = sdf.parse(date2);
        Date nowTime = new Date();
        //compareTo()方法的返回值，date1小于date2返回-1，date1大于date2返回1，相等返回0
        if (dateStart.compareTo(dateEnd) > 0) {
            return "0";//代表开始时间大于结束时间
        }
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd");
        //这里dateStart是utc时间 要搞成北京时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateStart);
        calendar.set(Calendar.HOUR,calendar.get(Calendar.HOUR)+8);
        Date dateStartBJ = calendar.getTime();
        if (dateStartBJ.before(nowTime)){
            return  "2";//代表请假时间早于当前时间
        }
        //获取现在时间
        Date date = new Date();
        System.out.println("现在时间是：------"+dateFormat1.format(date));
        //将数据存入inoutlog数据库
        StudentMessage studentMessageByNum = studentMessageService.getStudentMessageByNum(userNum);
        if (studentInOutLogService.insertRequest(dateFormat1.format(date), studentMessageByNum.getStudentName(), userNum, studentMessageByNum.getPhone(), studentInOutLogService.utcStrToBeiJingStr(date1), studentInOutLogService.utcStrToBeiJingStr(date2), reason, "0", purposeAddress,startAddress) != 0) {
            return "1";//代表插入成功
        }
        return "-1";//失败
    }



        //催促申请
        @PutMapping("/1")
        public String changeCheckedByDateAndNum(String date,String num){
            if (studentInOutLogService.changeCheckedByDateAndNum(date,num) == 1){
                return "success";
            }
            return "failure";
        }

        //同意申请
        @PutMapping("/2")
        public String changeCheckedToOneByDateAndNum(String date,String num,String myResponse) throws UnsupportedEncodingException {
            //解决get请求中文乱码
            byte[] bytes1=myResponse.getBytes("ISO-8859-1");
            String ans1=new String(bytes1,"utf-8");
            if (studentInOutLogService.changeCheckedToOneByDateAndNum(date,num,ans1) == 1){
                return "success";
            }
            return "failure";
        }

        //拒绝申请
        @PutMapping("/3")
        public String changeCheckedToTwoByDateAndNum(String date,String num,String myResponse) throws UnsupportedEncodingException {
            byte[] bytes1=myResponse.getBytes("ISO-8859-1");
            String ans1=new String(bytes1,"utf-8");
            if (studentInOutLogService.changeCheckedToTwoByDateAndNum(date,num,ans1) == 1){
                return "success";
            }
            return "failure";
        }

        //批量同意申请
        @PutMapping("/4")
        public String changeCheckedsToOneByDateAndNum(@RequestBody List<StudentInOutLog> selection,String myResponses) throws UnsupportedEncodingException {
            System.out.println(myResponses);
            int len = selection.size();
            int i = 0;int log = 1;
            while(i != len){
                String s = changeCheckedToOneByDateAndNum(selection.get(i).getDate(),selection.get(i).getNum(),myResponses);
                if(s.equals("failure")){
                    log = 0;
                }
                i++;
            }
            return "success";
        }

        //批量拒绝申请
        @PutMapping("/5")
        public String changeCheckedsToTwoByDateAndNum(@RequestBody List<StudentInOutLog> selection,String myResponses) throws UnsupportedEncodingException {
            int len = selection.size();
            int i = 0;int log = 1;
            while(i != len){
                String s = changeCheckedToTwoByDateAndNum(selection.get(i).getDate(),selection.get(i).getNum(),myResponses);
                if(s.equals("failure")){
                    log = 0;
                }
                i++;
            }
            return "success";
        }
}
