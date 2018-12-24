package sec.project.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Controller
public class HijackController {

    @RequestMapping(value = "/hijack", method = RequestMethod.GET)
    public String hijack(@RequestParam String content) {
        System.out.println("Hijacked content:\n" + content);
        return "form";
    }

}
