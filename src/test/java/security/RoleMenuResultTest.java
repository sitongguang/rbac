package security;

import org.junit.Test;
import rbac.Menu;
import rbac.Role;
import roleMenu.MenuForFront;
import roleMenu.RoleMenuResult;

import java.util.TreeSet;

public class RoleMenuResultTest {
    @Test
    public void roleMenus(){
        RoleMenuResult roleMenuResult11 = new RoleMenuResult("01","admin","0101","basic information",null);
        RoleMenuResult roleMenuResult12 = new RoleMenuResult("01","admin","0102","School information","school.ctl");
        RoleMenuResult roleMenuResult13 = new RoleMenuResult("01","admin","0103","Teacher information","teacher.ctl");

        RoleMenuResult roleMenuResult21 = new RoleMenuResult("02","teacher","0201","grade information","grade.ctl");
        RoleMenuResult roleMenuResult22 = new RoleMenuResult("02","teacher","0202","course information","course.ctl");

        TreeSet<RoleMenuResult> roleMenuResultTreeSet = new TreeSet<RoleMenuResult>();
        roleMenuResultTreeSet.add(roleMenuResult11);
        roleMenuResultTreeSet.add(roleMenuResult12);
        roleMenuResultTreeSet.add(roleMenuResult13);
        roleMenuResultTreeSet.add(roleMenuResult21);
        roleMenuResultTreeSet.add(roleMenuResult22);

        int idIdx=1;
        RoleMenuResult currentMenuResult = roleMenuResultTreeSet.first();
        String currentRoleDescription = currentMenuResult.getRoleDescription();
        TreeSet<Menu> currentMenus = new TreeSet<Menu>();

        for(RoleMenuResult roleMenuResult: roleMenuResultTreeSet){
            System.out.println(roleMenuResult.getMenuNo());
        }



//        currentMenus.add(currentMenuResult.getMenuDescription())
//        MenuForFront menuForFront = new MenuForFront(currentRoleDescription,null);
//        for(RoleMenuResult roleMenuResult : roleMenuResultTreeSet){
//            if(currentRoleDescription.equals(roleMenuResult.getRoleDescription())){
//                //generate menus
//
//            }
//
//            MenuForFront menuForFront = new MenuForFront(roleMenuResult.getRoleDescription(),null);

//            MenuForFront menuForFront = new MenuForFront(
//                    new Role(idIdx++,roleMenuResult.getRoleDescription(),roleMenuResult.getMenuNo()),
//                    new Menu(idIdx++,roleMenuResult.getMenuDescription(),roleMenuResult.getMenuNo(),roleMenuResult.getMenuNo()));

//        }



    }
}
