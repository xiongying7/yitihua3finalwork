package cn.edu.nenu.repository;

import cn.edu.nenu.config.orm.PlatformRepository;
import cn.edu.nenu.domain.Organization;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrganizationRepository extends PlatformRepository<Organization,Integer>{


    @Query("from Organization o where o.autoCode=?1")
    Organization findByAutoCode(String autoCode);

    @Query("from Organization o where o.pId=?1")
    List findByPId(Integer id);
}
