package djj.dao;

import djj.domain.Request;
import djj.domain.StudentAccount;
import djj.domain.StudentInOutLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInOutLogDao {

    @Select("SELECT * FROM biyesheji.inoutlog where checked=#{arg0} && num=#{arg1}")
    List<StudentInOutLog> getAllByIsChecked(String checked,String num);

    @Select("SELECT * FROM biyesheji.inoutlog where checked=#{arg0} && num=#{arg1} && date=#{arg2}")
    List<StudentInOutLog> getAllByIsCheckedByDate(String checked,String num,String date);

    @Select("SELECT * FROM biyesheji.inoutlog where checked=#{arg0} && num=#{arg1} && purposeAddress=#{arg2}")
    List<StudentInOutLog> getAllByIsCheckedByAddress(String checked,String num,String address);

    @Select("SELECT * FROM biyesheji.inoutlog where checked=#{arg0} && num=#{arg1} && purposeAddress=#{arg3} && date=#{arg2}")
    List<StudentInOutLog> getAllByIsCheckedByAddressAndDate(String checked,String num,String date,String address);

    @Select("SELECT date,name,num,phone,outTime,inTime,reason,purposeAddress,checked,startAddress FROM biyesheji.inoutlog where checked=#{arg0} && num=#{arg1} LIMIT #{arg2}, #{arg3};")
    List<StudentInOutLog> getAllByIsCheckedFenYe(String checked,String num,int beginIndex,int pageSize);

    @Select("SELECT date,name,num,phone,outTime,inTime,reason,purposeAddress,startAddress FROM biyesheji.inoutlog where checked=#{arg0} && date=#{arg1} LIMIT #{arg2}, #{arg3};")
    List<StudentInOutLog> getAllByIsCheckedFenYeByDate(String checked,String date,int beginIndex,int pageSize);

    @Select("SELECT date,name,num,phone,outTime,inTime,reason,purposeAddress,startAddress FROM biyesheji.inoutlog where checked=#{arg0} && purposeAddress=#{arg1} LIMIT #{arg2}, #{arg3};")
    List<StudentInOutLog> getAllByIsCheckedFenYeByAddress(String checked,String address,int beginIndex,int pageSize);



    @Select("SELECT date,name,num,phone,outTime,inTime,reason,purposeAddress,startAddress FROM biyesheji.inoutlog where checked=#{arg0} && purposeAddress=#{arg2} && date=#{arg1} LIMIT #{arg3}, #{arg4};")
    List<StudentInOutLog> getAllByIsCheckedFenYeByAddressAndDate(String checked,String date,String address,int beginIndex,int pageSize);

    @Select("SELECT * FROM biyesheji.inoutlog where num=#{arg0} LIMIT #{arg1}, #{arg2};")
    List<StudentInOutLog> getAllRequestByNum(String num,int beginIndex,int pageSize);

    @Select("SELECT * FROM biyesheji.inoutlog where num=#{arg0} && checked=#{arg3} LIMIT #{arg1}, #{arg2};")
    List<StudentInOutLog> getAllRequestByNumAndChecked(String num,int beginIndex,int pageSize,String checked);

    @Select("SELECT * FROM biyesheji.inoutlog where num=#{arg0} && date=#{arg3} LIMIT #{arg1}, #{arg2};")
    List<StudentInOutLog> getAllRequestByNumAndDate(String num,int beginIndex,int pageSize,String date);

    @Select("SELECT * FROM biyesheji.inoutlog where num=#{arg0} && date=#{arg3} && checked=#{arg4} LIMIT #{arg1}, #{arg2};")
    List<StudentInOutLog> getAllRequestByNumAndDate_Checked(String num,int beginIndex,int pageSize,String date,String checked);

    //还不确定对不对 这是用于将请求插入数据库的
    @Insert("INSERT INTO `biyesheji`.`inoutlog` (`date`, `name`, `num`, `phone`, `outTime`, `inTime`, `reason`, `checked`, `purposeAddress`,`startAddress`,`myResponse`) VALUES (#{arg0}, #{arg1}, #{arg2}, #{arg3}, #{arg4}, #{arg5}, #{arg6}, #{arg7}, #{arg8},#{arg9},#{arg10})")
    int insertStudentRequest(String date, String name, String num, String phone, String outTime, String inTime, String reason, String checked, String purposeAddress,String startAddress,String res);

    @Update("update inoutlog set checked=#{arg2} where num=#{arg1} && outTime=#{arg0};")
    int changeCheckedByDateAndNum(String date, String num, String s);

    @Update("update inoutlog set checked=#{arg2},myResponse=#{arg3} where num=#{arg1} && date=#{arg0};")
    int changeCheckedByDateAndNumWithRes(String date, String num, String s,String res);
    @Select("select * from biyesheji.inoutlog limit #{arg0},#{arg1}")
    List<StudentInOutLog> getAllRequest(int beginIndex, int pageSize);

    @Select("select date,name,num,phone,outTime,inTime,reason,purposeAddress,checked,startAddress ,purposeAddress from biyesheji.inoutlog where (checked=#{arg2} || checked=#{arg3}) and purposeAddress=#{arg4} limit #{arg0},#{arg1}")
    List<StudentInOutLog> getAllInRequestNoRes(int beginIndex, int pageSize,String ck1,String ck2,String purposeAddress);

    @Select("select date,name,num,phone,outTime,inTime,reason,purposeAddress,checked,startAddress ,purposeAddress from biyesheji.inoutlog where (checked=#{arg2} || checked=#{arg3}) and purposeAddress!=#{arg4} limit #{arg0},#{arg1}")
    List<StudentInOutLog> getAllOutRequestNoRes(int beginIndex, int pageSize,String ck1,String ck2,String purposeAddress);

    @Select("select * from biyesheji.inoutlog where name=#{arg0} and (checked=#{arg1} || checked=#{arg2}) and purposeAddress=#{arg3}")
    StudentInOutLog getAllInRequestByName(String name, String s, String s1, String address);

    @Select("select * from biyesheji.inoutlog where name=#{arg0} and (checked=#{arg1} || checked=#{arg2}) and purposeAddress!=#{arg3}")
    StudentInOutLog getAllOutRequestByName(String name, String s, String s1, String address);

    @Select("select * from biyesheji.inoutlog where num=#{arg0} and (checked=#{arg1} || checked=#{arg2})")
    List<Request> getRequestByNum(String num,String ck1,String ck2);

    @Select("select * from biyesheji.inoutlog where checked=#{arg2} limit #{arg0},#{arg1}")
    List<StudentInOutLog> getAllInOutLog(int beginIndex, int pageSize, String ck);

    @Select("select * from biyesheji.inoutlog where num=#{arg0} and checked=#{arg1}")
    List<StudentInOutLog> getAllInOutLogByNum(int num,String ck);

    @Select("select * from biyesheji.inoutlog where num=#{arg0}")
    List<Request> getAllReqByNum(String num);

    @Select("select * from biyesheji.inoutlog where checked=#{arg0}")
    List<StudentInOutLog> getAllLogSL(String ck);

    @Select("select * from biyesheji.inoutlog where (checked=#{arg1} || checked=#{arg0}) and purposeAddress=#{arg2}")
    List<Request> getAllReqSL(String s, String s1,String address);

    @Select("select * from biyesheji.inoutlog where (checked=#{arg1} || checked=#{arg0}) and purposeAddress!=#{arg2}")
    List<Request> getAllReqSL1(String s, String s1, String address);
}
