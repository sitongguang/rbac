package security;

import org.junit.Before;
import org.junit.Test;
import rbac.*;

import java.util.TreeSet;

public class MenuTest {
    private TreeSet<Menu> menusForAdmin;
    private TreeSet<Menu> menusForTeacher;
    private UserMenus userMenus ;
    @Before
    public void setUp() throws Exception {
        User u1 = new User(1,"pass","username");



        Role r1 = new Role(1,"admin","01");

        UserRoleAss userRoleAss1 = new UserRoleAss(1,r1,u1);

        Role r2 = new Role(1,"teacher","02");
        UserRoleAss userRoleAss2 = new UserRoleAss(1,r2,u1);



        Menu menu = new Menu(1,"基本信息管理","01","");
        menusForAdmin.add(menu);
        menusForAdmin.add(new Menu(2,"学院管理","0101","school.ctl"));
        menusForAdmin.add(new Menu(3,"教师管理","0102","school.ctl"));
        menusForAdmin.add(new Menu(4,"学生管理","0103","school.ctl"));


        menusForTeacher.add(menu);
        menusForTeacher.add(new Menu(11,"成绩管理","0101","school.ctl"));
        menusForTeacher.add(new Menu(12,"课表管理","0102","school.ctl"));

        userMenus = new UserMenus();
        userMenus.setUser(u1);

    }

    @Test
    public void orderMenus(){


    }
}
