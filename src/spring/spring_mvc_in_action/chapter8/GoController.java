package spring.spring_mvc_in_action.chapter8;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoController {
    private final Log logger = LogFactory.getLog(GoController.class);

    @RequestMapping(value = {"/"}, method = {RequestMethod.HEAD})
    public String head() {
        return "go.jsp";
    }

    @GetMapping(value = "/index")
    public String index(Model model) {
        logger.info("----------processed by index------------");

        model.addAttribute("msg", "Go Go Go!");
        return "go.jsp";
    }
}
