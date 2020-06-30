package cn.edu.nenu.repository;

import cn.edu.nenu.config.orm.PlatformRepository;
import cn.edu.nenu.domain.Part;
import cn.edu.nenu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {



    @Query("from User u where u.username=?1 order by u.sort asc ")
    List<User> findByTypeOrderBySort(String type);

    User findFirstByOrderBySortDesc();
}
