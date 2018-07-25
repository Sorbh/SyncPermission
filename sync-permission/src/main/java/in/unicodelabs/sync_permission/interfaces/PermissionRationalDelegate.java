package in.unicodelabs.sync_permission.interfaces;


import in.unicodelabs.sync_permission.PermissionRequest;

public interface PermissionRationalDelegate {
    void requestPermission(PermissionRequest permissionRequest, int requestCode);
}
