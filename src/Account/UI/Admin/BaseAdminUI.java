package Account.UI.Admin;

import Account.Service.Admin.AdminService;
import Account.Service.Admin.AdminServiceFactory;

public abstract class BaseAdminUI implements IAdminUI {


    protected AdminService adminService;

    public BaseAdminUI() {
        adminService = AdminServiceFactory.getAdminService();

    }

}
