package com.example.design.service.chain_of_responsibility;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ItemInfoHandler extends AbstractDataHandler<ItemInfoHandler.ItemInfo>{


    @Override
    protected ItemInfo doRequest(String query) throws Exception {
        ItemInfoHandler.ItemInfo info = new ItemInfo();
        info.setItemId(123456L);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("1","ok");
        info.setItemName("测试商品");
        return info;
    }

    @Data
    public static class ItemInfo {
        private Long itemId;
        private String itemName;
    }
}
