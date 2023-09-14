package com.jotad9.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jotad9.crud.dto.UserDto;
import com.jotad9.crud.model.User;
import com.jotad9.crud.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping()
public class StartController {
    @Autowired
    private UserService userService;// Debes inyectar tu servicio de usuario aquí

    public StartController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login"; // Redirige a la página de inicio de sesión
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Devuelve la vista del formulario de inicio de sesión (login.html en mi caso)
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes,
            HttpSession session) {

        // Verifica la autenticación con el servicio de usuario
        if (userService.authenticate(username, password)) {
            // Autenticación exitosa, establece una sesión de usuario
            session.setAttribute("loggedInUser", username);
            return "redirect:/listar"; // Redirige a la página de inicio o panel de control
        } else {
            // Autenticación fallida, muestra un mensaje de error
            redirectAttributes.addFlashAttribute("error", "Invalid Email and Password.");
            return "redirect:/login"; // Redirige de nuevo al formulario de inicio de sesión
        }
    }


    // handler method to handle user registration request
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
            BindingResult result,
            Model model) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

}
