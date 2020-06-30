package cn.edu.nenu.controller;

import cn.edu.nenu.domain.Organization;
import cn.edu.nenu.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import java.util.List;


@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;



    /**
     * 列表页面
     * @param model
     * @return
     */
    @GetMapping("")
    public String list(@RequestParam(value = "pId",defaultValue = "1") Integer pId,
                       ServletRequest request, Model model){
        //参数接收，默认值，默认机构，
        //Integer pId =Integer.valueOf(request.getParameter("pId")); //如无法从参数中获取，为null时则需要设定默认值

        List<Organization> organizationList = organizationService.getSubList(pId);
        model.addAttribute("list",organizationList);
        model.addAttribute("pId",pId);
        return "organization/list";
    }

    @GetMapping("/create")
    public String createForm(ServletRequest request,Model model){
        // 将请求参数pId，获取响应的上级机构信息，
        String pId = request.getParameter("pId");
        Organization pOrgan = organizationService.get(Integer.valueOf(pId));
        //如果pId=0则无法获取机构信息，此时需要构建一个临时机构
        if (pOrgan==null){
            pOrgan = new Organization();
            pOrgan.setId(Integer.valueOf(pId))
                    .setName("默认机构");
        }
        model.addAttribute("porgan",pOrgan);
        return "organization/form";
    }
    /**
     * 新增
     * @return
     */
    @PostMapping("create")
    //public String save(String json){ //前后端分离
    public String save(ServletRequest request, RedirectAttributes redirectAttributes){
        //前端接收的参数中应包含哪些内容：上级机构ID，pId
        Integer pId = Integer.valueOf(request.getParameter("pId"));
        String name = request.getParameter("name");
        //String currentOrganizationName = "吉林省";
        //*****************以上变量是参数传递过来的**********************************************//
        //根据pId获取改pId下级机构的最大排序值
        float currentLevelMaxSort = organizationService.getSubMaxSort(pId);
        String currentLevelAutoCode = organizationService.getSubMaxAutoCode(pId);
        Organization organization = new Organization();
        organization.setName(name)
                .setPId(pId)
                .setSort(currentLevelMaxSort)
                .setAutoCode(currentLevelAutoCode);
        organizationService.save(organization);
        redirectAttributes.addAttribute("message","操作成功");
        return "redirect:/organization";
    }

    /**
     * 编辑
     * @param json
     * @return
     */
    @PostMapping
    public String update(String json){
        Integer id=1;
        String currentOrganizationName="吉林省";

        //Organization organization = organizationService.get(id);
        //organization.setName(currentOrganizationName);
        //organizationService.update(organization);//有时可以和save方法公用同一方法。
        return "organization/list";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        if (id!=null){//在路径接收参数时增加正则表达式校验id不能为空，此处就可以删除了
            organizationService.delete(id);
        }
        return "organization/list";
    }
}
