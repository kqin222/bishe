package djj.dao;

import djj.domain.StudentAccount;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAccountDao {

    @Select("select * from studentaccount where accountName=#{accountName}")
    StudentAccount selectByAccountName(String accountName);

    @Select("select * from studentaccount")
    List<StudentAccount> selectAllStudentAccount();

    @Insert("INSERT INTO studentaccount(accountName,accountPassword) values (#{arg0},#{arg1})")
    int insertStudentAccount(String a,String b);

    @Delete("DELETE FROM studentaccount where accountName=#{accountName}")
    int deleteStudentAccount(String accountName);

    @Update("UPDATE studentaccount set accountPassword=#{arg1} where accountName=#{arg0}")
    int updateStudentAccount(String accountName,String newAccountPassword);

    @Select("SELECT * from studentaccount LIMIT #{arg0}, #{arg1}")
    List<StudentAccount> selectAllAccountFenYe(int beginIndex,int pageNum);

}
