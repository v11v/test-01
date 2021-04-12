package com.tedu.sp02.item.service.item;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> getItems(String orderId) {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item(1,"aaa",5));
        list.add(new Item(2,"bb",5));
        list.add(new Item(3,"ccc",5));
        list.add(new Item(4,"ddd",5));
        list.add(new Item(5,"eee",5));
        list.add(new Item(6,"fff",5));
        return list;
    }

    @Override
    public void decreaseNumbers(List<Item> list) {
        if (log.isInfoEnabled()){
            for (Item item : list){
                log.info("减少库存"+item);
            }
        }

    }
}
