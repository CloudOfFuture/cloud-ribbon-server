package com.kunlun.api.client;

import com.kunlun.api.hystrix.FileClientHystrix;
import com.kunlun.config.FeignMultipartConfig;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-26下午2:00
 * @desc
 */
@FeignClient(value = "cloud-service-common",
        configuration = FeignMultipartConfig.class,
        fallback = FileClientHystrix.class)
public interface FileClient {


    /**
     * 图片上传
     *
     * @param jsonContent String
     * @param file        MultipartFile
     * @return DataRet
     */
    @PostMapping(value = "/file/uploadImage",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    DataRet uploadImage(@RequestPart("file") MultipartFile file,
                        @RequestParam("jsonContent") String jsonContent);



    /**
     * 图片删除
     *
     * @param url 图片url
     * @return DataRet
     */
    @PostMapping("/file/deleteByUrl")
    DataRet deleteByUrl(@RequestParam(value = "url") String url);


    /**
     * 根据url查询图片
     *
     * @param url 图片url
     * @return DataRet
     */
    @GetMapping("/file/findByUrl")
    DataRet findByUrl(@RequestParam(value = "url") String url);

    /**
     * 图片删除
     *
     * @param id 图片id
     * @return DataRet
     */
    @PostMapping("/file/deleteById")
    DataRet deleteById(@RequestParam(value = "id") Long id);

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
    @GetMapping("/file/findByCondition")
    PageResult findByCondition(@RequestParam(value = "pageNo") Integer pageNo,
                               @RequestParam(value = "pageSize") Integer pageSize,
                               @RequestParam(value = "targetId", required = false) Long targetId,
                               @RequestParam(value = "type", required = false) String type);
}
