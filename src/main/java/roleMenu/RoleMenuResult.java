package roleMenu;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RoleMenuResult {
    private String roleNo;
    private String roleDescription;
    private String menuNo;
    private String menuDescription;
    private String menuUrl;

}
