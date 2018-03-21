package site001.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import site001.model.Usuario;
import site001.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuario/cadastro", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("formulario_usuario");
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
            mv.setViewName("formulario_usuario");
        }
        return mv;
    }

    @RequestMapping(value = "/usuario/edicao", method = RequestMethod.GET)
    public ModelAndView update() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formulario_usuario");
        mv.addObject("edicao", true);
        return mv;
    }

    @RequestMapping(value = "/usuario/edicao", method = RequestMethod.POST)
    public ModelAndView update(Usuario usuario, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        usuario.setId(usuarioLogado.getId());
        if (usuarioService.update(usuario)) {
            mv.setViewName("redirect:/principal");
            mv.addObject("sucesso_edicao", true);
            session.setAttribute("usuarioLogado", usuario);
        } else {
            mv.setViewName("formulario_usuario");
            mv.addObject("sucesso_edicao", false);
            mv.addObject("edicao", true);
        }
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Usuario usuario, HttpSession session) {
        usuario = usuarioService.login(usuario);
        ModelAndView mv = new ModelAndView();
        if (usuario.getId() != null) {
            mv.setViewName("redirect:/principal");
            session.setAttribute("usuarioLogado", usuario);
        } else {
            mv.setViewName("login");
            mv.addObject("usuario", usuario);
            mv.addObject("sucesso_login", false);
        }
        return mv;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        session.setAttribute("usuarioLogado", null);
        return new ModelAndView("redirect:/login");
    }
}
