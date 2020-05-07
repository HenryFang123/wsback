package fzz.wsback.service;

import fzz.wsback.domain.Admin;
import org.springframework.stereotype.Repository;

@Repository("adminService")
public interface AdminService {

    Admin checkLogin(Integer adminId, String adminPassword);
}
