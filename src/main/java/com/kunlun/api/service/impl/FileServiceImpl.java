package com.kunlun.api.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.kunlun.api.client.FileClient;
import com.kunlun.api.service.FileService;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-26下午2:03
 * @desc
 */
public class FileServiceImpl implements FileService {

    @Autowired
    private FileClient fileClient;

    @Override
    public DataRet uploadImage(MultipartFile file, String jsonContent) throws IOException {
        if (file == null || StringUtils.isEmpty(jsonContent)) {
            return new DataRet("param_error", "参数有误");
        }
        return fileClient.uploadImage(file, jsonContent);
    }

    @Override
    public DataRet deleteByUrl(String url) {
        if (url == null) {
            return new DataRet("param_error", "参数有误");
        }
        return fileClient.deleteByUrl(url);
    }

    @Override
    public DataRet findByUrl(String url) {
        if (url == null) {
            return new DataRet("param_error", "参数有误");
        }
        return fileClient.findByUrl(url);
    }

    @Override
    public DataRet deleteById(Long id) {
        if (id == null) {
            return new DataRet("param_error", "参数有误");
        }
        return fileClient.deleteById(id);
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, Long targetId, String type) {
        if (pageNo == null || pageSize == null) {
            return new PageResult();
        }
        return fileClient.findByCondition(pageNo, pageSize, targetId, type);
    }
}
