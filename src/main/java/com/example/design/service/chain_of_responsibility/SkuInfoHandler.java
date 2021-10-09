package com.example.design.service.chain_of_responsibility;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class SkuInfoHandler extends AbstractDataHandler<SkuInfoHandler.SkuInfo> {

    @Override
    protected SkuInfo doRequest(String query) throws Exception {
        SkuInfoHandler.SkuInfo info = new SkuInfoHandler.SkuInfo();
        info.setSkuId(78910L);
        info.setSkuName("测试SKU");
        return info;
    }

    @Data
    public static class SkuInfo {
        private Long skuId;
        private String skuName;
    }
}
