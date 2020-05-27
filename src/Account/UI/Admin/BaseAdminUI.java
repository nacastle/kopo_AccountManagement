package Account.UI.Admin;

import Account.Service.AdminService;
import Account.Service.AdminServiceFactory;

public abstract class BaseAdminUI implements IAdminUI {


    protected AdminService adminService;

    public BaseAdminUI() {
        adminService = AdminServiceFactory.getAdminService();

    }

}
