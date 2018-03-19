package site001.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import site001.dao.criteria.UsuarioCriteria;
import site001.model.Usuario;
import site001.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuario/cadastro", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("cadastro");
    }

    @RequestMapping(value = "/usuario/cadastro", method = RequestMethod.POST)
    public ModelAndView create(Usuario usuario) {
        usuario = usuarioService.create(usuario);
        ModelAndView mv = new ModelAndView();
        if (usuario != null && usuario.getId() != null) {
            mv.addObject("sucesso_cadastro", true);
            mv.setViewName("login");
        } else {
            mv.addObject("sucesso_cadastro", false);
            mv.setViewName("cadastro");
        }
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Usuario usuario) {
        usuario = usuarioService.login(usuario);
        ModelAndView mv = new ModelAndView();
        if (usuario.getId() != null) {
            mv.addObject("usuario", usuario);
            mv.setViewName("principal");
        } else {
            mv.addObject("sucesso_login", false);
            mv.setViewName("login");
        }
        return mv;
    }
}
