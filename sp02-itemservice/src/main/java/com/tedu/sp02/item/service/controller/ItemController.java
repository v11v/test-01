package com.tedu.sp02.item.service.controller;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.service.ItemService;
import com.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    //为了后面测试集群 1
    @Value("${server.port}")
    private int port;

    @GetMapping("/{orderId}")
    //也就是@RequestMapping(path="/{orderId}",method = RequestMethod.GET)

    public JsonResult<List<Item>> getItems(@PathVariable String orderId) throws Exception {
        log.info("server.port="+port+", orderId="+orderId);

        ///--设置随机延迟
        if(Math.random()<0.6) {
            long t = new Random().nextInt(5000);
            log.info("item-service-"+port+" - 暂停 "+t);
            Thread.sleep(t);
        }
        ///~~

        List<Item> items = itemService.getItems(orderId);
        return JsonResult.ok(items).msg("port="+port);
    }
    @PostMapping("/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        log.info("减少商品库存");
        itemService.decreaseNumbers(items);
        return JsonResult.ok();
    }
}