package com.kunlun.api.client;

import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-26下午2:00
 * @desc
 */
public interface FileUploadClient {
    /**
     * 图片上传
     *
     * @param file MultipartFile
     * @return DataRet
     */
    @RequestLine("POST")
    DataRet uploadImage(@RequestParam("file") MultipartFile file);
}

