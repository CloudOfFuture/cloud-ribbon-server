package com.kunlun.api.controller;

import com.kunlun.api.service.DeliveryService;
import com.kunlun.entity.Delivery;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author by hws
 * @created on 2017/12/25.
 */
@RestController
@RequestMapping("delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    /**
     * 根据id查找收货地址
     *
     * @param id
     * @return
     */
    @GetMapping("findById")
    public DataRet<Delivery> findById(@RequestParam(value = "id") Long id) {
        return deliveryService.findById(id);
    }

    /**
     *用户收货地址分页
     *
     * @param wxCode
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/findByWxCode")
    public PageResult findByWxCode(@RequestParam(value = "wxCode") String wxCode,
                                   @RequestParam(value = "pageNo") Integer pageNo,
                                   @RequestParam(value = "pageSize") Integer pageSize){
        return deliveryService.findByWxCode(wxCode,pageNo,pageSize);
    }

    /**
     * 新增收货地址
     *
     * @param delivery
     * @return
     */
    @PostMapping("/add")
    public DataRet<String> add(@RequestBody Delivery delivery){
        return deliveryService.add(delivery);
    }

    /**
     * 修改收货地址
     *
     * @param delivery
     * @return
     */
    @PostMapping("/update")
    public DataRet<String> update(@RequestBody Delivery delivery){
        return deliveryService.update(delivery);
    }


    /**
     * 删除收货地址
     *
     * @param delivery
     * @return
     */
    @PostMapping("/delete")
    public DataRet<String> delete(@RequestBody Delivery delivery){
        return deliveryService.delete(delivery);
    }


    /**
     * 设置默认收货地址
     *
     * @param id
     * @return
     */
    @PostMapping("/defaultAddress")
    public DataRet<String> defaultAddress(@RequestParam(value = "id") Long id,
                                          @RequestParam(value = "wxCode") String wxCode) {
        return deliveryService.defaultAddress(id, wxCode);
    }


    /**
     * 获取默认地址
     *
     * @param wxCode
     * @return
     */
    @RequestMapping(value = "/getDefault", method = RequestMethod.GET)
    public DataRet<Delivery> getDefault(@RequestParam(value = "wxCode") String wxCode) {
        return deliveryService.getDefault(wxCode);
    }
}
