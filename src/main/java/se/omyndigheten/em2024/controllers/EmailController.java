package se.omyndigheten.em2024.controllers;

import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.omyndigheten.em2024.services.EmailService;

/**
 * Created by Krille on 09/06/2024 16:49
 */
@Controller
public class EmailController {

    private final EmailService emailService;
    private String htmlMail = "<h2>Välkommen till The one and only EM-tips 2024</h2>"
            + "<p>Ditt tips är bifogat till detta mail. Kontrollera att det stämmer</p>"
            + "<p>Insatsen, 50 kronor, swishas till 070-2244230.</p>"
            + "<p>Om swish är för modernt så kan jag skicka ett kontonummer till dig.</p>"
            + "<p>Vill du skänka ett bidrag, kanske 5-10kr, till omkostnader så är det välkommet men inget krav. Ev. överskott går tillbaka till vinstpotten.</p>"
            + "<p>M v h</p>"
            + "<h3>Krister</h3>";

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping("/matchtips3")
    public String matchTipsSubmit(@ModelAttribute TipsController.MatchTipsListWrapper matchTipsWrapper, @RequestParam("deltagareEpost") String deltagareEpost,
                                  @RequestParam("deltagareArtistnamn") String deltagareArtistnamn, Model model) {
        model.addAttribute("matchtips", matchTipsWrapper.getMatchTipsList());
        String filePath = "/opt/em2024/tipsfiler/" + deltagareArtistnamn + ".txt";
        try {
            emailService.sendMessageWithAttachment(deltagareEpost, "Ämne", htmlMail, filePath);
            emailService.sendSimpleMessage("krille.home@gmail.com","Ny anmälan",deltagareArtistnamn + " " + deltagareEpost);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "duaranmald";
    }

}
