package pro.bolshakov.geekbrains.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.bolshakov.geekbrains.domain.Item;
import pro.bolshakov.geekbrains.service.ItemService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private ItemService itemService;

    public MainController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ModelAttribute("items")
    public List<Item> addAtrributeItems(){
        return itemService.getAll();
    }

    @RequestMapping({"/", "/index.html"})
    public String getIndex(){
        return "index";
    }

    @MessageMapping("/item")
    @SendTo("/topic/items")
    public Item addItem(Item item){
        itemService.addItem(item);
        return item;
    }

}
