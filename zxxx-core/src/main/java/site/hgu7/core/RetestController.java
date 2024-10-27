package site.hgu7.core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetestController {

    @RequestMapping("/hi")
    public String sayhi(){
        return "hi~~";
    }
}
