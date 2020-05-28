package IntegratedAccount.UI.Admin;

import IntegratedAccount.Service.Admin.AdminService;
import IntegratedAccount.Service.Admin.AdminServiceFactory;

public abstract class BaseAdminUI implements IAdminUI {


    protected AdminService adminService;

    public BaseAdminUI() {
        adminService = AdminServiceFactory.getAdminService();

    }

}
