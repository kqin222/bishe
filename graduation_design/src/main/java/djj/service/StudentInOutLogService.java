package djj.service;

import djj.dao.StudentAccountDao;
import djj.dao.StudentInOutLogDao;
import djj.domain.Request;
import djj.domain.StudentInOutLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StudentInOutLogService {

    @Autowired
    private StudentInOutLogDao studentInOutLogDao;

    public List<StudentInOutLog> getAllLogByIsChecked(String checked,String num){
        return studentInOutLogDao.getAllByIsChecked(checked,num);
    }

    public List<StudentInOutLog> getAllLogByIsCheckedFenYe(String checked,String num,int pageNum,int pageSize){
        int beginIndex = (pageNum - 1) * pageSize;
        List<StudentInOutLog> allLog = studentInOutLogDao.getAllByIsChecked(checked, num);
        try {
            return returnFinishInOut(allLog,beginIndex,pageSize);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public List<StudentInOutLog> getAllLogByIsCheckedFenYeByDate(String checked,String num,String date,int pageNum,int pageSize){
        int beginIndex = (pageNum - 1) * pageSize;
//        List<StudentInOutLog> allLog = studentInOutLogDao.getAllByIsCheckedFenYeByDate(checked, date, beginIndex, pageSize);
        List<StudentInOutLog> allLog = studentInOutLogDao.getAllByIsCheckedByDate(checked,num, date);


        try {
            return returnFinishInOut(allLog,beginIndex,pageSize);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StudentInOutLog> getAllLogByIsCheckedFenYeByAddress(String checked,String num,String address,int pageNum,int pageSize){
        int beginIndex = (pageNum - 1) * pageSize;
        List<StudentInOutLog> allLog = studentInOutLogDao.getAllByIsCheckedByAddress(checked,num, address);


        try {
            return returnFinishInOut(allLog,beginIndex,pageSize);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StudentInOutLog> getAllLogByIsCheckedFenYeByAddressAndDate(String checked,String num,String date,String address,int pageNum,int pageSize){
        int beginIndex = (pageNum - 1) * pageSize;
//        List<StudentInOutLog> allLog = studentInOutLogDao.getAllByIsCheckedFenYeByAddressAndDate(checked, date, address, beginIndex, pageSize);
        List<StudentInOutLog> allLog = studentInOutLogDao.getAllByIsCheckedByAddressAndDate(checked,num, date, address);

        try {
            return returnFinishInOut(allLog,beginIndex,pageSize);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StudentInOutLog> getAllRequestByNum(String num, int pageNum, int pageSize){
        int beginIndex = (pageNum - 1) * pageSize;
        List<StudentInOutLog> allRequest = studentInOutLogDao.getAllRequestByNum(num, beginIndex, pageSize);
//        int len = allRequest.size();int i = 0;
//        List<Request> requests = new ArrayList<>();
//        while(i != len){
//            String des = "你与"+allRequest.get(i).getDate()+"提交的与"+allRequest.get(i).getOutTime()+"去"+allRequest.get(i).getPurposeAddress()+"与"+allRequest.get(i).getInTime()+"返校的出校申请";
//            String checked = allRequest.get(i).getChecked();
//            Request request = new Request(des,checked);
//            requests.add(request);
//            i++;
//        }
        return allRequest;
    }

//    public List<StudentInOutLog> getAllRequestByNum(String checked,String num, int pageNum, int pageSize){
//        int beginIndex = (pageNum - 1) * pageSize;
//        List<StudentInOutLog> allRequest = studentInOutLogDao.getAllByIsCheckedFenYe(checked,num,beginIndex,pageSize);
//
//        return allRequest;
//    }

    public List<StudentInOutLog> getAllRequestByNumAndChecked(String num, int pageNum, int pageSize,String checked){
        int beginIndex = (pageNum - 1) * pageSize;
        List<StudentInOutLog> allRequest = studentInOutLogDao.getAllRequestByNumAndChecked(num, beginIndex, pageSize,checked);
//        int len = allRequest.size();int i = 0;
//        List<Request> requests = new ArrayList<>();
//        while(i != len){
//            String des = "你与"+allRequest.get(i).getDate()+"提交的与"+allRequest.get(i).getOutTime()+"去"+allRequest.get(i).getPurposeAddress()+"与"+allRequest.get(i).getInTime()+"返校的出校申请";
//            String ck = allRequest.get(i).getChecked();
//            Request request = new Request(des,ck);
//            requests.add(request);
//            i++;
//        }
        return allRequest;
    }

    public List<StudentInOutLog> getAllRequestByNumAndDate(String num, int pageNum, int pageSize,String date){
        int beginIndex = (pageNum - 1) * pageSize;
        List<StudentInOutLog> allRequest = studentInOutLogDao.getAllRequestByNumAndDate(num, beginIndex, pageSize,date);
//        int len = allRequest.size();int i = 0;
//        List<Request> requests = new ArrayList<>();
//        while(i != len){
//            String des = "你与"+allRequest.get(i).getDate()+"提交的与"+allRequest.get(i).getOutTime()+"去"+allRequest.get(i).getPurposeAddress()+"与"+allRequest.get(i).getInTime()+"返校的出校申请";
//            String ck = allRequest.get(i).getChecked();
//            Request request = new Request(des,ck);
//            requests.add(request);
//            i++;
//        }
        return allRequest;
    }

    public List<StudentInOutLog> getAllRequestByNumAndDate_Checked(String num, int pageNum, int pageSize,String date,String checked){
        int beginIndex = (pageNum - 1) * pageSize;
        List<StudentInOutLog> allRequest = studentInOutLogDao.getAllRequestByNumAndDate_Checked(num, beginIndex, pageSize,date,checked);
//        int len = allRequest.size();int i = 0;
//        List<Request> requests = new ArrayList<>();
//        while(i != len){
//            String des = "你与"+allRequest.get(i).getDate()+"提交的与"+allRequest.get(i).getOutTime()+"去"+allRequest.get(i).getPurposeAddress()+"与"+allRequest.get(i).getInTime()+"返校的出校申请";
//            String ck = allRequest.get(i).getChecked();
//            Request request = new Request(des,ck);
//            requests.add(request);
//            i++;
//        }
        return allRequest;
    }

    public String utcStrToBeiJingStr(String utcStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = null;
        date = sdf.parse(utcStr);
//        System.out.println("UTC时间："+date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR,calendar.get(Calendar.HOUR)+8);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = calendar.getTime();
        String date2 = simpleDateFormat.format(calendar.getTime());
//        System.out.println("北京时间："+date2);
        return date2;
    }

    public List<StudentInOutLog> returnFinishInOut(List<StudentInOutLog> studentInOutLogs,int beginIndex, int pageSize ) throws ParseException {
        List<StudentInOutLog> okList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int len = studentInOutLogs.size();int i  = 0;
        while (i != len){
            String inTime = studentInOutLogs.get(i).getInTime();
            Date inTimeDate = simpleDateFormat.parse(inTime);
            Date nowDate = new Date();
            if(inTimeDate.before(nowDate)){
                okList.add(studentInOutLogs.get(i));
            }
            i++;
        }

        //这里逻辑好像有错误 等出错再改
        int oklen = okList.size();int endIndex = beginIndex + pageSize;
//        System.out.println("oklen:"+oklen);
        if(endIndex > oklen) {
            endIndex = oklen;
        }
        if(beginIndex > oklen) {
            beginIndex = 0;
        }
//        System.out.println("开始索引"+beginIndex);
//        System.out.println("结束索引"+endIndex);
        return okList.subList(beginIndex,endIndex);
    }

    public int insertRequest(String date, String name, String num, String phone, String outTime, String inTime, String reason, String checked, String purposeAddress,String startAddress) {
        return studentInOutLogDao.insertStudentRequest(date,name,num,phone,outTime,inTime,reason,checked,purposeAddress,startAddress,"");
    }

    public int changeCheckedByDateAndNum(String date, String num) {
        return studentInOutLogDao.changeCheckedByDateAndNum(date,num,"3");
    }

    public int changeCheckedToOneByDateAndNum(String date, String num,String myResponse) {
        return studentInOutLogDao.changeCheckedByDateAndNumWithRes(date,num,"1",myResponse);
    }

    public int changeCheckedToTwoByDateAndNum(String date, String num,String myResponse) {
        return studentInOutLogDao.changeCheckedByDateAndNumWithRes(date,num,"2",myResponse);
    }

    public List<StudentInOutLog> getAllRequest(int pageNum, int pageSize) {
        int beginIndex = (pageNum - 1) * pageSize;
        return studentInOutLogDao.getAllRequest(beginIndex,pageSize);
    }

    public List<StudentInOutLog> getAllInRequestNoRes(int pageNum, int pageSize) {
        int beginIndex = (pageNum - 1) * pageSize;
        return studentInOutLogDao.getAllInRequestNoRes(beginIndex,pageSize,"0","3","学校");
    }

    public List<StudentInOutLog> getAllOutRequestNoRes(int pageNum, int pageSize) {
        int beginIndex = (pageNum - 1) * pageSize;
        return studentInOutLogDao.getAllOutRequestNoRes(beginIndex,pageSize,"0","3","学校");
    }

    public StudentInOutLog getInRequestByName(String name) {
        return studentInOutLogDao.getAllInRequestByName(name,"0","3","学校");
    }

    public StudentInOutLog getOutRequestByName(String name) {
        return studentInOutLogDao.getAllOutRequestByName(name,"0","3","学校");
    }

    //只招未处理的请求
    public int getRequestByNum(String num) {
        System.out.println(studentInOutLogDao.getRequestByNum(num,"0","3"));
        if(studentInOutLogDao.getRequestByNum(num,"0","3").size() == 0){
            return 0;
        }else {
            return 1;
        }
    }

    //管理员查询所有进出记录
    public List<StudentInOutLog> getAllInOutLog(int pageNum, int pageSize) {
        int beginIndex = (pageNum - 1) * pageSize;
        List<StudentInOutLog> all = studentInOutLogDao.getAllInOutLog(beginIndex,pageSize,"1");

        try {
            return returnFinishInOut(all,beginIndex,pageSize);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StudentInOutLog> getAllInOutLogByNum(int num) throws ParseException {
        List<StudentInOutLog> studentInOutLogs = studentInOutLogDao.getAllInOutLogByNum(num,"1");
        List<StudentInOutLog> okList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int len = studentInOutLogs.size();int i  = 0;
        while (i != len){
            String inTime = studentInOutLogs.get(i).getInTime();
            Date inTimeDate = simpleDateFormat.parse(inTime);
            Date nowDate = new Date();
            if(inTimeDate.before(nowDate)){
                okList.add(studentInOutLogs.get(i));
            }
            i++;
        }
        return okList;
    }

    public List<Request> getAllReqByNum(String num) {
        return studentInOutLogDao.getAllReqByNum(num);
    }

    public List<StudentInOutLog> getAllInOutLogSL() throws ParseException {
        List<StudentInOutLog> studentInOutLogs = studentInOutLogDao.getAllLogSL("1");
        List<StudentInOutLog> okList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int len = studentInOutLogs.size();int i  = 0;
        while (i != len){
            String inTime = studentInOutLogs.get(i).getInTime();
            Date inTimeDate = simpleDateFormat.parse(inTime);
            Date nowDate = new Date();
            if(inTimeDate.before(nowDate)){
                okList.add(studentInOutLogs.get(i));
            }
            i++;
        }
        return okList;
    }

    public List<Request> getAllReqSL() {
        return studentInOutLogDao.getAllReqSL("0","3","学校");
    }

    public List<Request> getAllReqSL1() {
        return studentInOutLogDao.getAllReqSL1("0","3","学校");
    }
}
