package in.unicodelabs.sync_permission;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class PermissionRequest implements Serializable {
    private final String name;
    private boolean isPermanentlyDenied = false;

    public PermissionRequest(@NonNull String name) {
        this.name = name;
    }

    public String getPermission() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isPermanentlyDenied() {
        return isPermanentlyDenied;
    }

    public void setPermanentlyDenied(boolean permanentlyDenied) {
        isPermanentlyDenied = permanentlyDenied;
    }
}
