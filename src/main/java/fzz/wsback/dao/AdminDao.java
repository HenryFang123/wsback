package fzz.wsback.dao;

import fzz.wsback.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author NE
 */
@Repository(value = "AdminDao")
public interface AdminDao {
    /**
     * 通过管理员 ID 获取管理员信息
     *
     * @param adminId 管理员 ID
     * @return Admin 实体类对象
     */
    Admin getAdminByAdminId(@Param("adminId") Integer adminId);
}
