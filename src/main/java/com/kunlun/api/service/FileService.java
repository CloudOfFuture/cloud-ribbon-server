package com.kunlun.api.service;

import com.kunlun.api.hystrix.FileClientHystrix;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-26上午11:48
 * @desc
 */

public interface FileService {

    /**
     * 图片上传
     *
     * @param jsonContent String
     * @param file        MultipartFile
     * @return DataRet
     * @throws IOException e
     */
    DataRet uploadImage(MultipartFile file, String jsonContent) throws IOException;

    /**
     * 图片删除
     *
     * @param url 图片url
     * @return DataRet
     */
    DataRet deleteByUrl(String url);


    /**
     * 根据url查询图片
     *
     * @param url 图片url
     * @return DataRet
     */
    DataRet findByUrl(String url);

    /**
     * 图片删除
     *
     * @param id 图片id
     * @return DataRet
     */
    DataRet deleteById(Long id);

    /**
     * 图片列表
     *
     * @param pageNo   Integer
     * @param pageSize Integer
     * @param type     商品图片 0,
     *                 品牌图片 1,
     *                 文章图片 2,
     *                 商品评价图片 3,
     *                 广告图片 4,
     *                 活动图片 5,
     *                 富文本图片路径 6
     *                 证件照 7
     * @return List
     */
    PageResult findByCondition(Integer pageNo,
                               Integer pageSize,
                               Long targetId,
                               String type);

}
