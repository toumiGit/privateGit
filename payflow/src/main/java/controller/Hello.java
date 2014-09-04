package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by toumi on 05/08/14.
 */

@Controller
@RequestMapping("/welcome")
public class Hello {

    @RequestMapping (method= RequestMethod.GET)
    public String printWelcome(ModelMap model)
    {
        model.addAttribute("message", "messageTest");
        return "hello";
    }

}
