package com.kunlun.api.hystrix;

import com.kunlun.api.client.FileClient;
import com.kunlun.result.DataRet;
import com.kunlun.result.PageResult;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author JackSpeed
 * @version V1.0 <>
 * @date 17-12-26上午11:49
 * @desc
 */
@Component
public class FileClientHystrix implements FileClient {

    @Override
    public DataRet uploadImage(MultipartFile file, String jsonContent) {
        return new DataRet("del_error", "请求失败");
    }

    @Override
    public DataRet deleteByUrl(String url) {
        return new DataRet("del_error", "删除失败");
    }

    @Override
    public DataRet findByUrl(String url) {
        return new DataRet("not_found", "查无结果");
    }

    @Override
    public DataRet deleteById(Long id) {
        return new DataRet("del_error", "删除失败");
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, Long targetId, String type) {
        return new PageResult();
    }
}
