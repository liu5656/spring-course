package dadalang.view;

import dadalang.factory.BeanFactory;
import dadalang.service.IAccountService;
import dadalang.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
        seriousCoupleingTest();
        removingCoupleingTest();
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
}
