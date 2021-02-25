package info.Podkowinski.HomePharmacy.User;

import info.Podkowinski.HomePharmacy.Sickness.Sickness;
import info.Podkowinski.HomePharmacy.Sickness.SicknessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addNewUser")
    public String addUser(@RequestBody AddUserDTO addUserDTO, @RequestHeader String userId){
        User newUser = new User();

        newUser.setId(userId);
        newUser.setEmail(addUserDTO.getEmail());
        newUser.setName(addUserDTO.getName());

        userService.save(newUser);

        return "Account created successfully!";
    }

//    @GetMapping("/edit/{id}")
//    public String editMember(@PathVariable int id, Model model){
//        User userToEdit = userService.findById(id);
//        model.addAttribute("member", userToEdit);
//        return "User/user-edit";
//    }
//    @PostMapping("/edit")
//    public String editMemberPost(@ModelAttribute User user, Model model){
//        userService.save(user);
//        model.addAttribute("members", userService.findAll());
//        return "redirect:/listOfMembers";
//    }
//    @GetMapping("/list")
//    public String membersList(Model model){
//        model.addAttribute("members", userService.findAll());
//        return "User/user-list";
//    }
//    @GetMapping("/delete/{id}")
//    public String deleteMember(@PathVariable int id, Model model){
//        userService.deleteById(id);
//        model.addAttribute("members", userService.findAll());
//        return "redirect:/listOfMembers";
//    }
}
