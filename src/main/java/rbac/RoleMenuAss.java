package rbac;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
@Data
@AllArgsConstructor
public class RoleMenuAss implements Comparable
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Integer id;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Menu menu;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Role role;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public RoleMenuAss(){
		super();
	}

    @Override
    public int compareTo(Object o) {
	    RoleMenuAss roleMenuAss = (RoleMenuAss)o;
        return this.id - roleMenuAss.id;
    }
}

