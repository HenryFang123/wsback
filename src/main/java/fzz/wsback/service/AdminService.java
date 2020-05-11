package fzz.wsback.service;

import fzz.wsback.domain.Admin;
import org.springframework.stereotype.Repository;

/**
 * @author NE
 */
@Repository(value = "adminService")
public interface AdminService {
    /**
     * 管理员登录核对
     *
     * @param adminId 管理员 ID
     * @param adminPassword 管理员密码
     * @return Admin 实体类对象
     */
    Admin checkLogin(Integer adminId,
                     String adminPassword);
}
