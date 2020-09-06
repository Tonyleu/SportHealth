package com.liangxionghua.sporthealth.dao;

import com.liangxionghua.sporthealth.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}
