package security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.Logger;
import org.junit.Before;
import org.junit.Test;
import rbac.*;
import roleMenu.MenuForFront;


import java.util.TreeSet;
@Log4j2
public class MenuTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getMenusByUser(){
        //创建两个用户
        User u1 = new User(1,"pass","username");
        User u2 = new User(2,"pass","username");
        //创建三个角色
        Role r1 = new Role(1,"admin","01");
        Role r2 = new Role(2,"teacher","02");
        Role r3 = new Role(3,"student","03");

        //用户u1关联角色r1,r2
        UserRoleAss userRoleAss11 = new UserRoleAss(11,r1,u1);
        UserRoleAss userRoleAss12 = new UserRoleAss(12,r2,u1);

        TreeSet<UserRoleAss> userRoleAssTreeSet = new TreeSet<UserRoleAss>();
        userRoleAssTreeSet.add(userRoleAss11);
        userRoleAssTreeSet.add(userRoleAss12);

        //用户u2关联角色r1,r3
        UserRoleAss userRoleAss21 = new UserRoleAss(21,r1,u2);
        UserRoleAss userRoleAss23 = new UserRoleAss(23,r3,u2);
        userRoleAssTreeSet.add(userRoleAss21);
        userRoleAssTreeSet.add(userRoleAss23);


        TreeSet<RoleMenuAss> roleMenuAssTreeSet = new TreeSet<RoleMenuAss>();
        //角色r1对应的菜单
        Menu menu10 = new Menu(11,"基本信息管理","01","");
        Menu menu11 = new Menu(12,"学院管理","0102","school.ctl");
        Menu menu12 = new Menu(13,"教师管理","0103","school.ctl");
        Menu menu13 = new Menu(14,"学生管理","0104","school.ctl");

        RoleMenuAss roleMenuAss10 = new RoleMenuAss(11,menu10,r1);
        RoleMenuAss roleMenuAss11 = new RoleMenuAss(12,menu11,r1);
        RoleMenuAss roleMenuAss12 = new RoleMenuAss(13,menu12,r1);
        RoleMenuAss roleMenuAss13 = new RoleMenuAss(14,menu13,r1);

        roleMenuAssTreeSet.add(roleMenuAss10);
        roleMenuAssTreeSet.add(roleMenuAss11);
        roleMenuAssTreeSet.add(roleMenuAss12);
        roleMenuAssTreeSet.add(roleMenuAss13);

        //角色r2对应的菜单
        Menu menu21 = new Menu(21,"成绩管理","0201","school.ctl");
        Menu menu22 = new Menu(22,"课表管理","0202","school.ctl");
        //设置角色r2和菜单menu21,menu22关联
        RoleMenuAss roleMenuAss21 = new RoleMenuAss(21,menu21,r2);
        RoleMenuAss roleMenuAss22 = new RoleMenuAss(22,menu22,r2);
        //增加到关联表集合中
        roleMenuAssTreeSet.add(roleMenuAss21);
        roleMenuAssTreeSet.add(roleMenuAss22);

        //角色r3对应的菜单
        Menu menu31 = new Menu(31,"成绩查询","0301","score.ctl");
        Menu menu32 = new Menu(32,"成绩复议","0302","scoreProtest.ctl");
        //设置角色r3和菜单menu31,menu32关联
        RoleMenuAss roleMenuAss31 = new RoleMenuAss(31,menu31,r3);
        RoleMenuAss roleMenuAss32 = new RoleMenuAss(32,menu32,r3);
        //增加到关联表集合中
        roleMenuAssTreeSet.add(roleMenuAss31);
        roleMenuAssTreeSet.add(roleMenuAss32);

        //设置当前用户
        User currentUser = u2;
        //打印当前用户的角色及对应菜单
        for(UserRoleAss userRoleAss : userRoleAssTreeSet){
            if(currentUser.equals(userRoleAss.getUser())) {
                Role roleOfCurrentUser = userRoleAss.getRole();
                for (RoleMenuAss roleMenuAss : roleMenuAssTreeSet) {
                    if(roleOfCurrentUser.equals(roleMenuAss.getRole())) {
                        System.out.print(roleOfCurrentUser + "\t");
                        Menu menu = roleMenuAss.getMenu();
                        System.out.println(menu);
                    }
                }
            }
        }

        //生成当前用户的角色及对应菜单的JSON
        TreeSet<MenuForFront> menuForFrontSet = new TreeSet<MenuForFront>();
        for(UserRoleAss userRoleAss : userRoleAssTreeSet){
            if(currentUser.equals(userRoleAss.getUser())) {
                Role roleOfCurrentUser = userRoleAss.getRole();
                TreeSet<Menu> menus = new TreeSet<Menu>();
                for (RoleMenuAss roleMenuAss : roleMenuAssTreeSet) {
                    if(roleOfCurrentUser.equals(roleMenuAss.getRole())) {
                        Menu menu = roleMenuAss.getMenu();
                        menus.add(menu);
                    }
                }
                MenuForFront menuForFront = new MenuForFront(roleOfCurrentUser,menus);
                menuForFrontSet.add(menuForFront);
            }
        }


        JSONObject json = new JSONObject();
        System.out.println(json.toJSONString(menuForFrontSet));
    }
}
