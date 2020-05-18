package ax.snuskriget.server.controllers;

import ax.snuskriget.server.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @GetMapping("/")
    public List<Item> items() {
        final List<Item> items = new ArrayList<>();
        items.add(new Item("Snorkfröken"));
        items.add(new Item("Muminpappan"));
        return items;
    }
}
