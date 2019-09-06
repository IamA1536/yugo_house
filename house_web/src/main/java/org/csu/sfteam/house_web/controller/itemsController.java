package org.csu.sfteam.house_web.controller;

import org.csu.sfteam.house.biz.service.DecorationService;
import org.csu.sfteam.house.biz.service.RentService;
import org.csu.sfteam.house.biz.service.SaleOldHouseService;
import org.csu.sfteam.house.biz.service.SalePropertyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/6 9:26
 */
public class itemsController {
    @Autowired
    private SalePropertyService salePropertyService;

    @Autowired
    private SaleOldHouseService saleOldHouseService;

    @Autowired
    private RentService rentService;

    @Autowired
    private DecorationService decorationService;

    public String showProperty(){
        return "";
    }
}
