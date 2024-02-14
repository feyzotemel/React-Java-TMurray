package feyz.com.basicApp.Enums;

public enum RoleEnum {
    ROLE_ADMIN((Long) 1L),
    ROLE_ORDINARY((Long) 2L);

    private Long numVal;

    RoleEnum(Long numVal) {
        this.numVal = numVal;
    }

    public static String getRoleName(Long numVal) {
        for (RoleEnum role : RoleEnum.values()) {
            if (role.numVal.equals(numVal)) {
                return role.name();
            }
        }
        return null;
    }

    public Long getNumVal() {
        return numVal;
    }
}
