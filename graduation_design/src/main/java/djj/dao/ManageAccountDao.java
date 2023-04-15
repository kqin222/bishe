package djj.dao;

import djj.domain.ManageAccount;
import djj.domain.StudentAccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManageAccountDao {

    @Select("select * from manageaccount where username=#{username}")
    ManageAccount selectByAccountName(String username);

    @Select("select * from manageaccount LIMIT #{arg0}, #{arg1}")
    List<ManageAccount> selectAll(int beginPage,int pageSize);

    @Delete("DELETE FROM manageaccount where username=#{arg0}")
    int deleteManageAccount(String num);

    @Update("UPDATE manageaccount set password=#{arg1} where username=#{arg0}")
    int updatePassword(String accountName, String accountPassword);

    @Insert("INSERT INTO manageaccount(username,password) values (#{arg0},#{arg1})")
    int insertAccount(String a,String b);

    @Select("select * from manageaccount ")
    List<ManageAccount> selectAllAccount(String num);
}
