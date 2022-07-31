package com.csj.account.service.feign;

import com.csj.api.api.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("hadoop-provider")
public interface HadoopServiceFeign {

    @GetMapping("/file/mkdir/{path}")
    public Result<?> createDir(@PathVariable("path") String path);

}
