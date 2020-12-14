package pro.bolshakov.geekbrains.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.bolshakov.geekbrains.domain.Item;
import pro.bolshakov.geekbrains.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final SimpMessagingTemplate template;

    public ItemController(ItemService itemService, SimpMessagingTemplate template) {
        this.itemService = itemService;
        this.template = template;
    }

    @PutMapping
    public ResponseEntity<Void> addItem(@RequestBody String body){
        if(body != null && !body.trim().isEmpty()){
            Item item = new Item(body);
            itemService.addItem(item);
            sendNotification(item);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    private void sendNotification(Item item){
        template.convertAndSend("/topic/items", item);
    }

}
