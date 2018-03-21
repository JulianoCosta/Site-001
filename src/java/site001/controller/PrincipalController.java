package site001.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import site001.model.Usuario;
import site001.service.UsuarioService;

@Controller
public class PrincipalController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/principal", method = RequestMethod.GET)
    public ModelAndView principal() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("principal");
        List<Usuario> usuarioList = usuarioService.readByCriteria(null, null, null);
        mv.addObject("usuarioList", usuarioList);
        return mv;
    }
}
