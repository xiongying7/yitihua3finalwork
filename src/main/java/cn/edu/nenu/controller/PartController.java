package cn.edu.nenu.controller;

import cn.edu.nenu.config.Constants;
import cn.edu.nenu.config.HttpServlet;
import cn.edu.nenu.domain.Dictionary;
import cn.edu.nenu.domain.Part;
import cn.edu.nenu.service.DictionaryService;
import cn.edu.nenu.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.Map;

import static cn.edu.nenu.config.Constants.PAGE_SIZE;


@Controller
@RequestMapping("/part")
public class PartController {

    @Autowired
    PartService partService;

    /**
     * 列表页面
     */
    @RequestMapping("")
    public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                       @RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model, ServletRequest request){

        Map<String, Object> searchParams = HttpServlet.getParametersStartingWith(request, "s_");
        Page<Part> parts = partService.getEntityPage(searchParams, pageNumber, PAGE_SIZE, sortType);
        model.addAttribute("parts", parts);
        model.addAttribute("sortType", sortType);
        model.addAttribute("PAGE_SIZE", PAGE_SIZE);
        model.addAttribute("searchParams", HttpServlet.encodeParameterStringWithPrefix(searchParams, "s_"));
        String path = "/WEB-INF/views/part/list.jsp";
        return "part/list";
    }

    /**
     * 进入新增页面
     */
    @GetMapping(value = "create")
    public String createForm(Model model) {
        model.addAttribute("part", new Part());
        model.addAttribute("action", "create");
        return "part/form";
    }

    /**
     * 新增页面，提交保存
     * @author zhangyj, 2020.05.21
     */
    @PostMapping(value = "create")
    public String create(@Valid Part newPart, RedirectAttributes redirectAttributes) {
        float sort = partService.getMaxSort();
        newPart.setSort(sort+1);
//        newPart.setStatus(Constants.Status.ENABLE);
        partService.save(newPart);
        redirectAttributes.addFlashAttribute("message", "创建成功");
        return "redirect:/part/";
    }

    /**
     * 进入编辑页面
     */
    @GetMapping(value = "update/{id}")
    public String updateForm(@PathVariable("id") Integer pkId, Model model){
        Part part =  partService.findOne(pkId);
        model.addAttribute("part",part);
        model.addAttribute("action", "update");
        return "part/form";
    }

    /**
     * 页面编辑后，保存
     */
    @PostMapping(value = "update")
    public String update(@Valid Part part, RedirectAttributes redirectAttributes){
        Integer pkId = part.getId();
        Part newPart = partService.findOne(pkId);
        newPart.setType(part.getType());
        newPart.setName(part.getName());
        newPart.setWriter(part.getWriter());

        partService.save(newPart);
        redirectAttributes.addFlashAttribute("message", "更改成功");
        return "redirect:/part/";
    }

    /**
     * 根据ID删除单个字典
     */
    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer pkId, RedirectAttributes redirectAttributes) {
        String message = "删除成功";
        try {
            partService.remove(pkId);
        }catch (Exception e){
            message = "删除失败";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/part/";
    }

    /**
     * 批量删除
     */
    @PostMapping(value = "delete")
    public String deleteBatch(ServletRequest request,RedirectAttributes redirectAttributes){
        String[] chkIds = request.getParameterValues("chkIds");
        for (String id:chkIds){
            partService.remove(Integer.valueOf(id));
        }
        return "redirect:/part/";
    }
}
