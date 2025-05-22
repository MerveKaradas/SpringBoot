package com.doyur.demo.controller1;

import com.doyur.demo.model.Menu;
import com.doyur.demo.service.abstracts.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/menus")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Menu>> getAllMenus() {
        return ResponseEntity.ok(menuService.getAllMenus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(int id) {
        return ResponseEntity.ok(menuService.findMenuById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        Menu newMenu = menuService.saveMenu(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMenu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable int id, @RequestBody Menu menu) {
        return ResponseEntity.ok(menuService.updateMenu(id, menu));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable int id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }
}
