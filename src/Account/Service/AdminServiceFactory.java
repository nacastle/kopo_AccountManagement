package Account.Service;

public class AdminServiceFactory {

    private static AdminService adminService = null;

    public static AdminService getAdminService() {

        if(adminService== null) {
            adminService = new AdminService();
        }
        return adminService;
    }

}
