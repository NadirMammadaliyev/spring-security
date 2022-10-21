package az.nadir.restapi.enums;

public enum RoleName {
    ROLE_SUPER_ADMIN("ROLE_SUPER_ADMIN"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_MANAGER("ROLE_MANAGER"),
    ROLE_USER("ROLE_USER");

    private final String value;

    RoleName(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
