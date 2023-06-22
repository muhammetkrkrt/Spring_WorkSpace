package com.muhammet.hastanerandevu.controllermvc;

import com.muhammet.hastanerandevu.model.ModelHome;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView md = new ModelAndView("index");
        ModelHome model = ModelHome.builder()
                .content("Merhaba yeni sistemimiz aktif edilmiştir.")
                .title("Hastane Randevu Sistemi")
                .urunList(Arrays.asList("Ürün 1", "Ürün 2", "Ürün 3", "Ürün 4"))
                .build();
        md.addObject("model", model);
        return md;
    }
}
