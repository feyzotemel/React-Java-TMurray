package feyz.com.basicApp.Enums;

public enum RoleEnum {
    ROLE_ADMIN((Integer) 1),
    ROLE_ORDINARY((Integer) 2);

    private Integer numVal;

    RoleEnum(Integer numVal) {
        this.numVal = numVal;
    }

    public static String getRoleName(Integer numVal) {
        for (RoleEnum role : RoleEnum.values()) {
            if (role.numVal.equals(numVal)) {
                return role.name();
            }
        }
        return null;
    }

    public Integer getNumVal() {
        return numVal;
    }
}
