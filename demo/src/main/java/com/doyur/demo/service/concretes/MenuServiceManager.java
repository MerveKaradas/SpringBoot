package com.doyur.demo.service.concretes;

import com.doyur.demo.model.Menu;
import com.doyur.demo.repository.abstracts.MenuRepository;
import com.doyur.demo.service.abstracts.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceManager implements MenuService {
    private final MenuRepository menuRepository;

    public MenuServiceManager(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu findMenuById(int id) {
        return menuRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Menu not found"));
    }

    @Override
    public Menu saveMenu(Menu menu) {

        Optional<Menu> menuOptional = menuRepository.findByMenuName(menu.getMenuName());
        if (menuOptional.isPresent()) {
            throw new IllegalArgumentException("Menu already exists");
        }
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(int id, Menu menu) {
        Menu menuToUpdate = menuRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Menu not found"));

        menuToUpdate.setMenuName(menu.getMenuName());
        menuToUpdate.setDescription(menu.getDescription());
        menuToUpdate.setPrice(menu.getPrice());

        return menuRepository.save(menuToUpdate);
    }

    @Override
    public void deleteMenu(int id) {
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if (menuOptional.isPresent()) {
            menuRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("Menu not found");
        }
    }
}
