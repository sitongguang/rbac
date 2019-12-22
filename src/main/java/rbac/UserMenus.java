package rbac;

import lombok.Data;

import java.util.TreeSet;
@Data
public class UserMenus {
    private User user;
    private TreeSet<Menu> menus;
}
