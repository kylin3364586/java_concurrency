package org.example.thinking.in.spring.ioc.bean.scope.web.contorller;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月16日 15:29:00
 */
@Controller
public class IndexController {

    @Autowired
    private User user; //CGLIB提升后的对象（每次都是不变的）

    @GetMapping("/index.html")
    public String index(Model model){
        model.addAttribute("user", user);
        return "index";
    }
}
