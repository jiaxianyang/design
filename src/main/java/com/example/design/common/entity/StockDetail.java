package com.example.design.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class StockDetail {

    @JsonProperty("resultValue")
    private ResultValueDTO resultValue;
    @JsonProperty("resultCode")
    private Integer resultCode;
    @JsonProperty("resultMessage")
    private Object resultMessage;
    @JsonProperty("messageCode")
    private Object messageCode;
    @JsonProperty("args")
    private Object args;
    @JsonProperty("success")
    private Boolean success;

    @NoArgsConstructor
    @Data
    public static class ResultValueDTO {
        @JsonProperty("total")
        private Integer total;
        @JsonProperty("list")
        private List<ListDTO> list;
        @JsonProperty("pageNum")
        private Integer pageNum;
        @JsonProperty("pageSize")
        private Integer pageSize;
        @JsonProperty("size")
        private Integer size;
        @JsonProperty("startRow")
        private Integer startRow;
        @JsonProperty("endRow")
        private Integer endRow;
        @JsonProperty("pages")
        private Integer pages;
        @JsonProperty("prePage")
        private Integer prePage;
        @JsonProperty("nextPage")
        private Integer nextPage;
        @JsonProperty("isFirstPage")
        private Boolean isFirstPage;
        @JsonProperty("isLastPage")
        private Boolean isLastPage;
        @JsonProperty("hasPreviousPage")
        private Boolean hasPreviousPage;
        @JsonProperty("hasNextPage")
        private Boolean hasNextPage;
        @JsonProperty("navigatePages")
        private Integer navigatePages;
        @JsonProperty("navigatepageNums")
        private List<Integer> navigatepageNums;
        @JsonProperty("navigateFirstPage")
        private Integer navigateFirstPage;
        @JsonProperty("navigateLastPage")
        private Integer navigateLastPage;

        @NoArgsConstructor
        @Data
        public static class ListDTO {
            @JsonProperty("sku")
            private String sku;
            @JsonProperty("skuName")
            private String skuName;
            @JsonProperty("skuLevel")
            private String skuLevel;
            @JsonProperty("skuLevelName")
            private String skuLevelName;
            @JsonProperty("packCode")
            private String packCode;
            @JsonProperty("packCodeName")
            private Object packCodeName;
            @JsonProperty("lotNo")
            private String lotNo;
            @JsonProperty("ownerNo")
            private String ownerNo;
            @JsonProperty("ownerName")
            private String ownerName;
            @JsonProperty("zoneNo")
            private String zoneNo;
            @JsonProperty("zoneName")
            private String zoneName;
            @JsonProperty("zoneType")
            private String zoneType;
            @JsonProperty("locationNo")
            private String locationNo;
            @JsonProperty("containerLevel1")
            private String containerLevel1;
            @JsonProperty("containerLevel2")
            private String containerLevel2;
            @JsonProperty("stockQty")
            private Object stockQty;
            @JsonProperty("prePickedQty")
            private Object prePickedQty;
            @JsonProperty("preMovedQty")
            private Object preMovedQty;
            @JsonProperty("frozenQty")
            private Object frozenQty;
            @JsonProperty("diffQty")
            private Object diffQty;
            @JsonProperty("brokenQty")
            private Object brokenQty;
            @JsonProperty("stockStatus")
            private String stockStatus;
            @JsonProperty("lotDetail")
            private LotDetailDTO lotDetail;
            @JsonProperty("shelfLifeDays")
            private Integer shelfLifeDays;
            @JsonProperty("updateTime")
            private String updateTime;
            @JsonProperty("createUser")
            private String createUser;
            @JsonProperty("updateUser")
            private String updateUser;
            @JsonProperty("propertiesMap")
            private PropertiesMapDTO propertiesMap;
            @JsonProperty("imagePath")
            private Object imagePath;
            @JsonProperty("snapshotStockQty")
            private Integer snapshotStockQty;
            @JsonProperty("operateStockQty")
            private Integer operateStockQty;
            @JsonProperty("snapshotOccupiedQty")
            private Integer snapshotOccupiedQty;
            @JsonProperty("operateOccupiedQty")
            private Integer operateOccupiedQty;
            @JsonProperty("locateExceptionQty")
            private Integer locateExceptionQty;
            @JsonProperty("changeProperty")
            private String changeProperty;
            @JsonProperty("changeFrom")
            private String changeFrom;
            @JsonProperty("changeTo")
            private String changeTo;
            @JsonProperty("businessType")
            private String businessType;
            @JsonProperty("businessTypeName")
            private String businessTypeName;
            @JsonProperty("businessNo")
            private String businessNo;
            @JsonProperty("subBusinessNo")
            private String subBusinessNo;
            @JsonProperty("lockType")
            private String lockType;
            @JsonProperty("snapshotPrepickedQty")
            private Integer snapshotPrepickedQty;
            @JsonProperty("operatePrepickedQty")
            private Integer operatePrepickedQty;
            @JsonProperty("snapshotPremovedQty")
            private Integer snapshotPremovedQty;
            @JsonProperty("operatePremovedQty")
            private Integer operatePremovedQty;
            @JsonProperty("snapshotFrozenQty")
            private Integer snapshotFrozenQty;
            @JsonProperty("operateFrozenQty")
            private Integer operateFrozenQty;
            @JsonProperty("snapshotDiffQty")
            private Integer snapshotDiffQty;
            @JsonProperty("operateDiffQty")
            private Integer operateDiffQty;
            @JsonProperty("snapshotBrokenQty")
            private Integer snapshotBrokenQty;
            @JsonProperty("operateBrokenQty")
            private Integer operateBrokenQty;
            @JsonProperty("lockedQty")
            private Integer lockedQty;

            @NoArgsConstructor
            @Data
            public static class LotDetailDTO {
                @JsonProperty("productionDate")
                private String productionDate;
                @JsonProperty("expirationDate")
                private String expirationDate;
                @JsonProperty("safeDays")
                private String safeDays;
                @JsonProperty("adventDate")
                private String adventDate;
                @JsonProperty("qualityState")
                private String qualityState;
                @JsonProperty("gysGl")
                private String gysGl;
                @JsonProperty("supplier")
                private String supplier;
                @JsonProperty("prevSupplier")
                private String prevSupplier;
                @JsonProperty("manufacturer")
                private String manufacturer;
                @JsonProperty("noSale")
                private String noSale;
                @JsonProperty("boxNo")
                private String boxNo;
                @JsonProperty("po")
                private String po;
                @JsonProperty("businessPo")
                private String businessPo;
                @JsonProperty("batchNo")
                private String batchNo;
                @JsonProperty("packageBatch")
                private String packageBatch;
                @JsonProperty("logisticCompany")
                private String logisticCompany;
                @JsonProperty("origin")
                private String origin;
                @JsonProperty("plu")
                private String plu;
                @JsonProperty("receiveDate")
                private String receiveDate;
                @JsonProperty("store")
                private String store;
                @JsonProperty("shelfLifeDays")
                private Integer shelfLifeDays;
                @JsonProperty("extendLotAttrMap")
                private ExtendLotAttrMapDTO extendLotAttrMap;

                @NoArgsConstructor
                @Data
                public static class ExtendLotAttrMapDTO {
                }
            }

            @NoArgsConstructor
            @Data
            public static class PropertiesMapDTO {
                @JsonProperty("brandName")
                private String brandName;
                @JsonProperty("notMarking")
                private String notMarking;
                @JsonProperty("color")
                private String color;
                @JsonProperty("highValueGoods")
                private String highValueGoods;
                @JsonProperty("repackage")
                private String repackage;
                @JsonProperty("productSeason")
                private String productSeason;
                @JsonProperty("allowedDay")
                private Integer allowedDay;
                @JsonProperty("isvSku")
                private String isvSku;
                @JsonProperty("upc")
                private String upc;
                @JsonProperty("collectPackCodeFlag")
                private String collectPackCodeFlag;
                @JsonProperty("isToDistributionLine")
                private String isToDistributionLine;
                @JsonProperty("size")
                private String size;
                @JsonProperty("storeProperty")
                private String storeProperty;
                @JsonProperty("newFlag")
                private String newFlag;
                @JsonProperty("breakable")
                private String breakable;
                @JsonProperty("brandNo")
                private String brandNo;
                @JsonProperty("collectLogisticsAttrFlag")
                private String collectLogisticsAttrFlag;
            }
        }
    }
}
