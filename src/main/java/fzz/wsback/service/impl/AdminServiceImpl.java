package fzz.wsback.service.impl;

import fzz.wsback.dao.AdminDao;
import fzz.wsback.domain.Admin;
import fzz.wsback.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author NE
 */
@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin checkLogin(Integer adminId, String adminPassword) {
        Admin admin = adminDao.getAdminByAdminId(adminId);

        if (admin != null && admin.getAdminPassword().equals(adminPassword)) {
            return admin;
        } else {
            return null;
        }
    }
}
