package org.spring.itis.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.itis.hib.domain.RegistratedUser;
import org.itis.hib.domain.User;
import org.itis.hib.service.RegistratedUserService;
import org.itis.hib.service.UserService;
import org.spring.itis.util.Constants;
import org.spring.itis.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private RegistratedUserService registratedUserService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public String userAuthorization(ModelMap modelMap) {
        RegistratedUser current_user = registratedUserService.getUserByLogin(request.getParameter("login"));
        if (current_user == null) {
            modelMap.addAttribute("error", "Неверно введён логин или пароль");
            return Constants.VIEW_MAIN;
        }
        if (!current_user.getHash_password().equals(DigestUtils.md5Hex(request.getParameter("password") + Constants.SAULT))) {
            modelMap.addAttribute("error", "Неверно введён логин или пароль");
            return Constants.VIEW_MAIN;
        }
        return "redirect:users_list";
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user,
                          BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return Constants.VIEW_USER_FORM;
        }
        userService.addUser(user);
        return "redirect:users_list";
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public String renderUserForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return Constants.VIEW_USER_FORM;
    }

    @RequestMapping(value = "/edit_user", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user,
                           BindingResult result, ModelMap modelMap) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            modelMap.addAttribute("cur_user", userService.getUserById(user.getId()));
            return Constants.VIEW_USER_EDIT_FORM;
        }
        userService.updateUser(user);
        return "redirect:users_list";
    }

    @RequestMapping(value = "/delete_user", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(userService.getUserById(id));
        return "redirect:users_list";
    }

    @RequestMapping(value = "/edit_user", method = RequestMethod.GET)
    public String renderUserEditForm(@RequestParam("id") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("cur_user", userService.getUserById(id));
        return Constants.VIEW_USER_EDIT_FORM;
    }

    @RequestMapping(value = "/users_list", method = RequestMethod.GET)
    public String renderUsersList(ModelMap modelMap) {
        modelMap.addAttribute("users_list", userService.getAllUsers());
        return Constants.VIEW_USERS_LIST;
    }
}
