package pro.bolshakov.geekbrains.service;

import org.springframework.stereotype.Service;
import pro.bolshakov.geekbrains.domain.Item;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public List<Item> getAll(){
        return items;
    }

}
