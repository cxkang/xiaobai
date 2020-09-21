package com.xiaobai.loT.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.xiaobai.loT.entity.TPaintingEntity;
import com.xiaobai.loT.vo.TPaintingTopicVo;
import com.xiaobai.loT.vo.TpaintingTopicUuidVo;
import entity.PageUtils;
import entity.R;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 画作表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:00
 */
public interface TPaintingService extends IService<TPaintingEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R upload(MultipartFile uploadFile, TPaintingTopicVo tpaintingEntity);

    R downloadPic(String uuid);

    R findObjectbyTopicId(String[] topicIds);


//    void updatepaintingById(TPaintingTopicVo t);

    PageUtils queryPage(Map<String, Object> params, String categoryUuid);

    R removeMenuByIds(TpaintingTopicUuidVo[] vos);

    void updatepaintingById(TPaintingEntity entity, String[] topicIds);
}

