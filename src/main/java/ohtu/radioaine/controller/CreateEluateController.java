package ohtu.radioaine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ohtu.radioaine.service.ProductService;

@Controller
public class CreateEluateController {

    @Autowired
    private ProductService esinePalvelu;

    @RequestMapping("createEluate")
    public String createEluate() {
        return "createEluate";
    }

}