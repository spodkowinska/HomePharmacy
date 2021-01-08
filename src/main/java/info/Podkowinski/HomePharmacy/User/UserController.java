package info.Podkowinski.HomePharmacy.User;

import info.Podkowinski.HomePharmacy.Sickness.Sickness;
import info.Podkowinski.HomePharmacy.Sickness.SicknessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addMember")
    public String addMember(Model model){
        model.addAttribute("member", new User());
        return "User/user-edit";
    }
    @GetMapping("/editMember/{id}")
    public String editMember(@PathVariable int id, Model model){
        User userToEdit = userService.findById(id);
        model.addAttribute("member", userToEdit);
        return "User/user-edit";
    }
    @PostMapping("/editMember")
    public String editMemberPost(@ModelAttribute User user, Model model){
        userService.save(user);
        model.addAttribute("members", userService.findAll());
        return "redirect:/listOfMembers";
    }
    @GetMapping("/listOfMembers")
    public String membersList(Model model){
        model.addAttribute("members", userService.findAll());
        return "User/user-list";
    }
    @GetMapping("/deleteMember/{id}")
    public String deleteMember(@PathVariable int id, Model model){
        userService.deleteById(id);
        model.addAttribute("members", userService.findAll());
        return "redirect:/listOfMembers";
    }
}
