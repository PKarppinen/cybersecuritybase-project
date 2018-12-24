package sec.project.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupCustomRepository;
import sec.project.repository.SignupRepository;

@Controller
public class DoneController {

    @Autowired
    private HttpSession session;

    @Autowired
    private SignupCustomRepository signupCustomRepository;

    @RequestMapping(value = "/done", method = RequestMethod.GET)
    public String loadDone(Model model) {
        String signupName = "";
        if (session.getAttribute("signupName") != null && !session.getAttribute("signupName").equals("")) {
            signupName = signupCustomRepository.findNameByName((String)session.getAttribute("signupName"));
        }
        model.addAttribute("signupName", signupName);
        model.addAttribute("signupAddress", (String)session.getAttribute("signupAddress"));
        return "done";
    }

}
