package com.xiaobai.loT.controller;


import com.xiaobai.loT.entity.TPaintingEntity;
import com.xiaobai.loT.service.TPaintingService;
import com.xiaobai.loT.vo.TPaintingTopicVo;
import entity.R;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("loT/image")
public class TImageController {

    @Resource
    private TPaintingService tPaintingService;

    /**
     * 图片的上传
     */
    @RequestMapping("/pic/upload")
    public R upload(MultipartFile uploadFile, @RequestBody TPaintingTopicVo tpaintingEntity) {

        return tPaintingService.upload(uploadFile, tpaintingEntity);
    }

    /**
     * 下载
     */
    @RequestMapping("/pic/download")
    public R downloadPic(String uuid) {

        return tPaintingService.downloadPic(uuid);
    }
    /**
     * 根据多个主题id查询
     *
     * @param topicIds
     * @return
     */
    @RequestMapping("/findObjectbyTopicId")
    public R findObjectbyTopicId(@RequestBody String[] topicIds) {

        return tPaintingService.findObjectbyTopicId(topicIds);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id) {
        TPaintingEntity tPainting = tPaintingService.getById(id);

        return R.ok().put("tPainting", tPainting);
    }


}
