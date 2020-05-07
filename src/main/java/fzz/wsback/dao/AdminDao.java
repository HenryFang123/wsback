package fzz.wsback.dao;

import fzz.wsback.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author NE
 */
@Repository("AdminDao")
public interface AdminDao {

    Admin getAdminObjectByAdminId(@Param("adminId") Integer adminId);
}
