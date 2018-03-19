
package site001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import site001.model.Usuario;

@Controller
public class LoginController {
    
    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView logar(Usuario usuario){
        ModelAndView mv = new ModelAndView();
        //TODO validar login aqui.
        mv.setViewName("principal");
        return mv;
    }
}
