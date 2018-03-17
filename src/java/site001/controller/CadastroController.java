package site001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import site001.model.Usuario;
import site001.service.UsuarioService;

@Controller
public class CadastroController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ModelAndView cadastrar(Usuario usuario) {
        usuario = usuarioService.create(usuario);
        ModelAndView mv = new ModelAndView();
        if (usuario != null && usuario.getId() != null) {
            mv.addObject("sucesso", true);
            mv.setViewName("login");
        } else {
            mv.addObject("sucesso", false);
            mv.setViewName("cadastro");
        }
        return mv;
    }
}
