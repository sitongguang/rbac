package roleMenu;

import lombok.AllArgsConstructor;
import lombok.Data;
import rbac.Menu;
import rbac.Role;

import java.util.TreeSet;

@AllArgsConstructor
@Data
public class MenuForFront implements Comparable{
    private Role role;
    private TreeSet<Menu> menus;

    @Override
    public int compareTo(Object o) {
        MenuForFront other = (MenuForFront)o;
        return this.role.hashCode()+this.menus.hashCode()-
                other.role.hashCode() - other.menus.hashCode();
    }
}
