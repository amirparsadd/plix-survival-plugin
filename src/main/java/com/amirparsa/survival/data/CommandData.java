package com.amirparsa.survival.data;

public class CommandData {
    public String permission;
    public boolean enabled;

    private CommandData() {}

    public CommandData(String permission, boolean enabled) {
        this.permission = permission;
        this.enabled = enabled;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
