package djj.dao;

import djj.domain.StudentAccount;
import djj.domain.StudentMessage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMessageDao {

    @Select("select * from studentmessage where studentNum=#{studentNum}")
    StudentMessage selectByStudentNum(String studentNum);

    @Update("update studentmessage set studentName=#{arg1},sex=#{arg2},dep=#{arg3},major=#{arg4},banji=#{arg5},phone=#{arg6} where studentNum=#{arg0}")
    int updatePersonalMessageByNum(String num, String name, String sex, String dep, String major, String banji, String phone);

    @Select("select * from studentmessage LIMIT #{arg0}, #{arg1}")
    List<StudentMessage> selectAll(int beginIndex,int pageSize);

    @Delete("DELETE FROM studentMessage where studentNum=#{arg0}")
    int deleteByAccountName(String num);

    @Insert("INSERT INTO studentmessage values (#{arg0},#{arg1},#{arg2},#{arg3},#{arg6},#{arg4},#{arg5})")
    int insertMessage(String num, String name, String sex, String dep, String banji, String phone, String major);

    @Select("select * from studentmessage")
    List<StudentMessage> selectAllSL();
}
