package org.spring.itis.controllers;

import org.itis.hib.domain.Order;
import org.itis.hib.service.OrderService;
import org.itis.hib.service.UserService;
import org.itis.hib.util.Constants;
import org.spring.itis.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class OrderController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderValidator orderValidator;
    @RequestMapping(value = "/orders_list", method = RequestMethod.GET)
    public String renderOrdersList(  ModelMap modelMap) {
        modelMap.addAttribute("orders_list", orderService.getAllOrders());
        return Constants.ATTR_ORDERS_LIST;
    }
    @RequestMapping(value = "/new_order", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order,
                          BindingResult result) {
        orderValidator.validate(order, result);
        if (result.hasErrors()) {
            request.setAttribute("usersList", userService.getAllUsers());
            return Constants.ATTR_ORDER_FORM;
        }
        orderService.addOrder(order);
        return "redirect:orders_list";
    }
    @RequestMapping(value = "/new_order", method = RequestMethod.GET)
    public String renderOrderForm(ModelMap modelMap) {
        modelMap.addAttribute("usersList", userService.getAllUsers());
        modelMap.addAttribute("order", new Order());
        return Constants.ATTR_ORDER_FORM;
    }

    @RequestMapping(value = "/edit_order", method = RequestMethod.POST)
    public String editOrder(@ModelAttribute("order") Order order,
                           BindingResult result) {
        orderValidator.validate(order, result);
        if (result.hasErrors()) {
            request.setAttribute("usersList", userService.getAllUsers());
            request.setAttribute("cur_order", orderService.getOrderById(order.getId()));
            return Constants.ATTR_ORDER_EDIT_FORM;
        }
        orderService.updateOrder(order);
        return "redirect:orders_list";
    }
    @RequestMapping(value = "/delete_order", method = RequestMethod.GET)
    public String deleteOrder(@RequestParam("id") Integer id) {
        orderService.deleteOrder(orderService.getOrderById(id));
        return "redirect:orders_list";
    }
    @RequestMapping(value = "/edit_order", method = RequestMethod.GET)
    public String renderUserEditForm(@RequestParam("id") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("order", new Order());
        modelMap.addAttribute("usersList", userService.getAllUsers());
        modelMap.addAttribute("cur_order", orderService.getOrderById(id));
        return Constants.ATTR_ORDER_EDIT_FORM;
    }
}
