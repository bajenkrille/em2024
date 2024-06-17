package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import se.omyndigheten.em2024.commands.DeltagareCommand;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.services.DeltagareService;

import javax.validation.Valid;

/**
 * Created by Krille on 17/05/2024 17:21
 */
@Controller
public class DeltagareController {

    private final DeltagareService deltagareService;

    public DeltagareController(DeltagareService deltagareService) {
        this.deltagareService = deltagareService;
    }

    @GetMapping("/deltagare_avstangd")
    public String anmalanGet(Model model) {
        model.addAttribute("deltagareCommand", new DeltagareCommand());
        return "deltagare_avstangd";
    }

    @PostMapping("/deltagare_avstangd")
    public String anmalanSubmit(@Valid @ModelAttribute("deltagareCommand") DeltagareCommand deltagareCommand, BindingResult bindRes, Model model) {
        //model.addAttribute("deltagare", deltagare);

        if (bindRes.hasErrors()){
            return "deltagare_avstangd";
        }

        if (deltagareCommand.getNickName().isEmpty()){
            String newNickName = deltagareCommand.getFirstName() + deltagareCommand.getLastName().substring(0,3);
            deltagareCommand.setNickName(newNickName);
        }

        Deltagare deltagare = new Deltagare();
        deltagare.setFirstName(deltagareCommand.getFirstName());
        deltagare.setLastName(deltagareCommand.getLastName());
        deltagare.setNickName(deltagareCommand.getNickName());
        deltagare.setEmail(deltagareCommand.getEmail());
        deltagare.setPassword(deltagareCommand.getPassword());
        deltagare.setPhoneNumber(deltagareCommand.getPhoneNumber());


        deltagareService.saveDeltagare(deltagare);
        Long id = deltagare.getId();
        return "redirect:/matchtips?deltagareId=" + deltagare.getId();
    }
}
