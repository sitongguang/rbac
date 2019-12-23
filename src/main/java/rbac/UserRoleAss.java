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
public class UserRoleAss implements Comparable
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int id;

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
	 * @ordered
	 */
	
	private User user;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public UserRoleAss(){
		super();
	}

	@Override
	public int compareTo(Object o) {
		UserRoleAss userRoleAss = (UserRoleAss)o;
		return this.id - userRoleAss.id;
	}
}

