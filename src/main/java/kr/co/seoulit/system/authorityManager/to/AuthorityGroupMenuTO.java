package kr.co.seoulit.system.authorityManager.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorityGroupMenuTO {
	String authorityGroupCode, menuCode, menuName;
}
