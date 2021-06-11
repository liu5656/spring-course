package dadalang.view;

import dadalang.dao.IAccountDao;
import dadalang.factory.BeanFactory;
import dadalang.service.IAccountService;
import dadalang.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
//        seriousCoupleingTest();
//        removingCoupleingTest();
        springIOCTest();
    }
    // 耦合严重，业务层和表现层耦合，业务层和持久层耦合
    static void seriousCoupleingTest() {
        IAccountService service = new AccountServiceImpl();
        service.saveAccount();
    }

    // 采用工厂模式，减轻耦合
    static void removingCoupleingTest() {
        IAccountService service = (IAccountService) BeanFactory.getBean("accountService");
        service.saveAccount();
    }

    // 采用IOC的方法，
    static void springIOCTest() {
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        // 根据id获取bean对象
        IAccountService service = (IAccountService) app.getBean("accountService");
        IAccountDao dao = app.getBean("accountDao", IAccountDao.class);
        System.out.println(service);
        System.out.println(dao);
    }
}
