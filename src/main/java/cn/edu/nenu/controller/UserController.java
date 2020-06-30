package cn.edu.nenu.controller;

import cn.edu.nenu.config.HttpServlet;
import cn.edu.nenu.domain.User;
import cn.edu.nenu.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 列表页面
     */
    @RequestMapping("")
    public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                       @RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model, ServletRequest request){

        Map<String, Object> searchParams = HttpServlet.getParametersStartingWith(request, "s_");
        Page<User> users = userService.getEntityPage(searchParams, pageNumber, PAGE_SIZE, sortType);
        model.addAttribute("users", users);
        model.addAttribute("sortType", sortType);
        model.addAttribute("PAGE_SIZE", PAGE_SIZE);
        model.addAttribute("searchParams", HttpServlet.encodeParameterStringWithPrefix(searchParams, "s_"));
        String path = "/WEB-INF/views/dict/list.jsp";
        return "user/list";
    }

    /**
     * 进入新增页面
     */
    @GetMapping(value = "create")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("action", "create");
        return "user/form";
    }

    /**
     * 新增页面，提交保存
     * @author zhangyj, 2020.05.21
     */
    @PostMapping(value = "create")
    public String create(@Valid User newUser, RedirectAttributes redirectAttributes) {
        float sort = userService.getMaxSort();
        newUser.setSort(sort+1);
//        newPart.setStatus(Constants.Status.ENABLE);
        userService.save(newUser);
        redirectAttributes.addFlashAttribute("message", "创建成功");
        return "redirect:/user/";
    }

    /**
     * 进入编辑页面
     */
    @GetMapping(value = "update/{id}")
    public String updateForm(@PathVariable("id") Integer pkId, Model model){
        User user =  userService.findOne(pkId);
        model.addAttribute("user",user);
        model.addAttribute("action", "update");
        return "user/form";
    }

    /**
     * 页面编辑后，保存
     */
    @PostMapping(value = "update")
    public String update(@Valid User user, RedirectAttributes redirectAttributes){
        Integer pkId = user.getId();
        User newUser = userService.findOne(pkId);
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setPhone(user.getPhone());
        newUser.setEmail(user.getEmail());
        newUser.setCreateTime(user.getCreateTime());


        userService.save(newUser);
        redirectAttributes.addFlashAttribute("message", "更改数据字典信息成功");
        return "redirect:/user/";
    }

    /**
     * 根据ID删除单个字典
     */
    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer pkId, RedirectAttributes redirectAttributes) {
        String message = "删除成功";
        try {
            userService.remove(pkId);
        }catch (Exception e){
            message = "删除失败";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/user/";
    }

    /**
     * 批量删除
     */
    @PostMapping(value = "delete")
    public String deleteBatch(ServletRequest request,RedirectAttributes redirectAttributes){
        String[] chkIds = request.getParameterValues("chkIds");
        for (String id:chkIds){
            userService.remove(Integer.valueOf(id));
        }
        return "redirect:/user/";
    }
}
