package com.doyur.demo.service.abstracts;

import com.doyur.demo.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getAllMenus();

    Menu findMenuById(int id);

    Menu saveMenu(Menu menu);

    Menu updateMenu(int id, Menu menu);

    void deleteMenu(int id);
}
