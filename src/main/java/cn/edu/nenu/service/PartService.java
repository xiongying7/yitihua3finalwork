package cn.edu.nenu.service;

import cn.edu.nenu.config.orm.jpa.DynamicSpecifications;
import cn.edu.nenu.config.orm.jpa.SearchFilter;
import cn.edu.nenu.domain.Dictionary;
import cn.edu.nenu.domain.Part;
import cn.edu.nenu.repository.DictionaryRepository;
import cn.edu.nenu.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PartService {


    @Autowired
    PartRepository partRepo;

    /**
     * 根据主键获取实体，常用
     */
    public Part findOne(Integer pkId){
        return partRepo.findOne(pkId);
    }

    /**
     * 保存一个实体，常用
     */
    public Part save(Part entity){
        return partRepo.save(entity);
    }

    /**
     * 批量保存实体  Set，List
     */
    public Iterable<Part> save(Iterable<Part> entities){
        return partRepo.save(entities);
    }

    /**
     * 根据主键删除实体，常用
     */
    public void remove(Integer pkId){
        partRepo.delete(pkId);
    }

    /**
     * 根据实体删除实体，不常用
     */
    public void remove(Part entity){
        partRepo.delete(entity);
    }

    /**
     * 批量删除实体，使用较少
     */
    public void remove(Iterable<Part> parts){
        partRepo.delete(parts);
    }

    /**
     * 根据字典类型获取字典集合
     */
    public List<Part> findByType(String type){
        return partRepo.findByTypeOrderBySort(type);
    }

    /**
     * 根据查询条件获取分页结果数据
     */
    public Page<Part> getEntityPage(Map<String, Object> filterParams, int pageNumber, int pageSize, String sortType){
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Part> spec = buildSpecification(filterParams);
        return partRepo.findAll(spec,pageRequest);
    }
    /**
     * 创建分页请求.
     */
    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "sort");
        } else if ("sort".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "sort");
        }
        return new PageRequest(pageNumber - 1, pageSize, sort);
    }

    /**
     * 创建动态查询条件组合.
     */
    private Specification<Part> buildSpecification(Map<String, Object> filterParams) {

        Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
        //if (StringUtils.isNotBlank(id)) {
        //    filters.put("id", new SearchFilter("id", SearchFilter.Operator.EQ, id));
        //}
        Specification<Part> spec = DynamicSpecifications.bySearchFilter(filters.values(), Part.class);
        return spec;
    }

    public float getMaxSort() {
        Part part = partRepo.findFirstByOrderBySortDesc();
        if (part==null){
            return 0;
        }else {
            return part.getSort();
        }

    }
}
