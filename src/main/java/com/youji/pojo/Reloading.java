package com.youji.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Reloading {
    private Integer reloadingId;

    private Integer elfId;

    private Integer goodsId;

    private BigDecimal price;

    private Date addTime;

    private Integer status;

    public Integer getReloadingId() {
        return reloadingId;
    }

    public void setReloadingId(Integer reloadingId) {
        this.reloadingId = reloadingId;
    }

    public Integer getElfId() {
        return elfId;
    }

    public void setElfId(Integer elfId) {
        this.elfId = elfId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}