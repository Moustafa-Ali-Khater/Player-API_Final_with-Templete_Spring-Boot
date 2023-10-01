package com.spring.playerapi.controller;

import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    private PlayerService playerService;

    /*@GetMapping("/profile")
    public String test(Model model) {
        model.addAttribute("name", "Mostafa Khater");
        return "home";
    }*/

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public String getAllPlayers(Model model) {
        model.addAttribute("players", playerService.allPlayers());
        return "home";
    }

    @GetMapping("/playerform")
    public String playerForm(Model model) {
        model.addAttribute("player", new Player());
        return "playerform";
    }

    @PostMapping("/savePlayer")
    public String saveplayer(@ModelAttribute("player") Player player) {
        playerService.savePlayer(player);
        return "redirect:/players";
    }

    @GetMapping("/getplayer")
    public String getplayer(@RequestParam("playerId") int id, Model model) {
        model.addAttribute("player", playerService.showPlayer(id));
        return "playerform";
    }

    @GetMapping("/removeplayer")
    public String removeplayer(@RequestParam("playerId") int id) {
        playerService.deletePlayer(id);
        return "redirect:/players";
    }
}
