import djj.config.SpringConfig;
import djj.dao.StudentAccountDao;
import djj.dao.StudentInOutLogDao;
import djj.dao.StudentMessageDao;
import djj.domain.StudentAccount;
import djj.domain.StudentInOutLog;
import djj.domain.StudentMessage;
import djj.service.StudentAccountService;
import djj.service.StudentInOutLogService;
import djj.service.StudentMessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.time.LocalTime.now;

public class app {
    public static void main(String[] args) throws ParseException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentMessageDao bean = applicationContext.getBean(StudentMessageDao.class);
        bean.updatePersonalMessageByNum("11","w","w","w","w","w","w");



    }
}
