package cn.edu.nenu.repository;

import cn.edu.nenu.config.orm.PlatformRepository;
import cn.edu.nenu.domain.Dictionary;
import cn.edu.nenu.domain.Part;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartRepository extends PlatformRepository<Part,Integer> {


    @Query("from Part p where p.type=?1 order by p.sort asc ")
    List<Part> findByTypeOrderBySort(String type);

    Part findFirstByOrderBySortDesc();
}
