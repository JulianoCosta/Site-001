
package site001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import site001.model.Usuario;

@Controller
public class PrincipalController {

    @RequestMapping(value = "/principal", method = RequestMethod.POST)
    public ModelAndView principal(Usuario usuario){
     
        ModelAndView mv = new ModelAndView();
        mv.setViewName("principal");
        
        return mv;
    }
}
