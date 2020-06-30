package cn.edu.nenu.repository;

import cn.edu.nenu.config.orm.PlatformRepository;
import cn.edu.nenu.domain.Dictionary;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DictionaryRepository extends PlatformRepository<Dictionary,Long> {


    @Query("from Dictionary d where d.type=?1 order by d.sort asc ")
    List<Dictionary> findByTypeOrderBySort(String type);

    Dictionary findFirstByOrderBySortDesc();
}
