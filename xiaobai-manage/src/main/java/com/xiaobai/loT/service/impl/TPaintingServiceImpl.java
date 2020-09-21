package com.xiaobai.loT.service.impl;

import com.xiaobai.loT.dao.TPaintingTopicDao;
import com.xiaobai.loT.entity.TPaintingTopicEntity;
import com.xiaobai.loT.vo.TPaintingTopicVo;
import com.xiaobai.loT.vo.TpaintingTopicUuidVo;

import entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.xiaobai.loT.dao.TPaintingDao;
import com.xiaobai.loT.entity.TPaintingEntity;
import com.xiaobai.loT.service.TPaintingService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;


@Service("tPaintingService")
public class TPaintingServiceImpl extends ServiceImpl<TPaintingDao, TPaintingEntity> implements TPaintingService {

    @Resource
    private TPaintingDao tPaintingDao;
    @Resource
    private TPaintingTopicDao tPaintingTopicDao;


    @Value("${image.localDir}")
    private String localDir;    // = "D:/software/images";  //定义本地存储路径
    @Value("${image.urlPath}")
    private String urlPath;        // = "http://image.jt.com";	 //定义虚拟空间地址

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TPaintingEntity> page = this.page(
                new Query<TPaintingEntity>().getPage(params),
                new QueryWrapper<TPaintingEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 图片的上传
     *
     * @param uploadFile
     * @param vo
     * @return
     */
    @Override
    public R upload(MultipartFile uploadFile, TPaintingTopicVo vo) {
        String fileName = uploadFile.getOriginalFilename();
        fileName = fileName.toLowerCase();
        //2 正则表达式  匹配字符串是否满足规范
        if (!fileName.matches("^.+\\.(jpg|png|jpeg|gif)$")) {
            return R.error("上传图片无效");
        }
        /**
         * 判断图片是否为恶意程序
         */
        try {
            BufferedImage bufferedImage =
                    ImageIO.read(uploadFile.getInputStream());
            int height = bufferedImage.getHeight();    //获取高度
            int width = bufferedImage.getWidth();    //获取宽度
            if (height == 0 || width == 0) {
                return R.error("上传图片无效");
            }
            //文件路径，目录
            String dateDir = new SimpleDateFormat("/yyyy/MM/dd/")
                    .format(new Date());
            //5.准备文件保存的目录
            String imageDir = localDir + dateDir;
            File dirFile = new File(imageDir);
            if (!dirFile.exists()) {

                dirFile.mkdirs();    //如果文件目录不存在,则创建
            }
            //定义文件名称
            String paintinguuid = UUID.randomUUID().toString();
            String uuid = paintinguuid.replace("-", "");
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            String realFileName = uuid + fileType;
            uploadFile.transferTo(new File(imageDir + realFileName));
            String url = urlPath + dateDir + realFileName;
            vo.setPaintingUrl(url.toString());
            vo.setDataUuid(paintinguuid);
            TPaintingEntity tPaintingEntity = new TPaintingEntity();
            BeanUtils.copyProperties(vo, tPaintingEntity);
            Date date = new Date();
            tPaintingEntity.setCreateTime(date);
            tPaintingEntity.setUpdateTime(date);
            this.savaBaseInfo(tPaintingEntity);
            TPaintingTopicEntity tPaintingTopicEntity = new TPaintingTopicEntity();
            tPaintingTopicEntity.setTopicUuid(vo.getTopicId());
            tPaintingTopicEntity.setPaintingUuid(vo.getDataUuid());
            tPaintingEntity.setCreateTime(tPaintingEntity.getCreateTime());
            tPaintingTopicEntity.setUpdateTime(tPaintingTopicEntity.getUpdateTime());
////如果是多个图片
//            List<String >images=new ArrayList<>();
//            List<TPaintingEntity> collect = images.stream().map((image) -> {
//                tPaintingTopicEntity.setUpdateTime();
//                return tPaintingEntity;
//
//            }).collect(Collectors.toList());
//            this.saveBatch(collect);  描述用逗号隔开：  String。join（“，”，images）
            return R.ok().put("url", url);
        } catch (IOException e) {
            e.printStackTrace();
            return R.error();
        }

    }

    @Override
    public R downloadPic(String uuid) {

        QueryWrapper<TPaintingEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("data_uuid", uuid);
        TPaintingEntity tPaintingEntity = tPaintingDao.selectOne(queryWrapper);
        String paintingUrl = tPaintingEntity.getPaintingUrl();
        URL url = null;
        String encrypt="";
        try {
            url = new URL(paintingUrl);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

          //  FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            buffer = output.toByteArray();
            String encode = new BASE64Encoder().encode(buffer);
            encrypt = AESUtil.encrypt(encode);
            dataInputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            return  R.error("下载失败");
        }
         return R.ok().put("data",encrypt);
    }


    @Transactional
    @Override
    public R findObjectbyTopicId(String[] topicIds) {
//        List<TPaintingTopicEntity> tPaintingTopicEntities = tPaintingTopicDao.selectBatchIds(Arrays.asList(topicIds));
//        List<String> paintingUuid = tPaintingTopicEntities.stream().map((p) -> {
//            return p.getPaintingUuid();
//        }).collect(Collectors.toList());


        if (topicIds == null) {
            List<TPaintingEntity> tPaintingEntities = tPaintingDao.selectList(null);
            return R.ok().put("data", tPaintingEntities);
        }
        List<String> paintingId = tPaintingTopicDao.findPaintIdsByTopicId(topicIds);
        if (paintingId == null || paintingId.size() == 0) {
            return null;
        }
        List<TPaintingEntity> entities = tPaintingDao.findObjectById(paintingId);
        return R.ok().put("data", entities);
    }


//    @Transactional
//    @Override
//    public void updatepaintingById(TPaintingTopicVo t) {
//        TPaintingEntity tPaintingEntity=new TPaintingEntity();
//        BeanUtils.copyProperties(t,tPaintingEntity);
//
//        this.updateById(tPaintingEntity);
//        TPaintingTopicEntity tPaintingTopicEntity=new TPaintingTopicEntity();
//        tPaintingTopicEntity.setPaintingUuid(t.getDataUuid());
//        tPaintingTopicEntity.setTopicUuid(t.getTopicId());
//        QueryWrapper<TPaintingTopicEntity> wrapper = new QueryWrapper<>();
//        Integer count = tPaintingTopicDao.selectCount(wrapper.eq("painting_uuid", t.getDataUuid()));
//        if(count>0){
//            tPaintingTopicDao.update(tPaintingTopicEntity,new UpdateWrapper<TPaintingTopicEntity>().eq("painting_uuid", t.getDataUuid()));
//        }else {
//            tPaintingTopicDao.insert(tPaintingTopicEntity);
//
//        }
//
//
//    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, String categoryUuid) {
        String key = (String) params.get("key");
        QueryWrapper<TPaintingEntity> wrapper = new QueryWrapper<TPaintingEntity>();
        if (!StringUtils.isEmpty(key)) {
            wrapper.and((obj) -> {
                obj.eq("category_uuid", key).or().like("painting_name", key);
            });
        }
        if (StringUtils.isEmpty(categoryUuid)) {
            IPage<TPaintingEntity> page = this.page(new Query<TPaintingEntity>().getPage(params),
                    wrapper);
            return new PageUtils(page);
        } else {
            wrapper.eq("category_uuid", categoryUuid);
            IPage<TPaintingEntity> page = this.page(new Query<TPaintingEntity>().getPage(params),
                    wrapper);

            return new PageUtils(page);
        }

    }

    /**
     * 批量删除
     *
     * @param vos
     * @return
     */
    @Override
    public R removeMenuByIds(TpaintingTopicUuidVo[] vos) {

        if (vos == null || vos.length == 0) {
            throw new IllegalArgumentException("请选择");
        }
        List<TPaintingTopicEntity> entities = Arrays.asList(vos).stream().map((vo) -> {
            TPaintingTopicEntity t = new TPaintingTopicEntity();
            BeanUtils.copyProperties(vo, t);
            return t;
        }).collect(Collectors.toList());
        tPaintingTopicDao.deleteBatchVos(entities);
        List<String> paintingUuids = entities.stream().map((entity) -> {
            return entity.getPaintingUuid();
        }).collect(Collectors.toList());
        int rows = tPaintingDao.deleteObjects(paintingUuids);
        if (rows == 0) {
            return R.error("这个记录不存在，删除失败");
        }
        return R.ok("删除成功");
    }

    @Transactional
    @Override
    public void updatepaintingById(TPaintingEntity entity, String[] topicIds) {
        if (entity != null) {
            tPaintingDao.updateById(entity);
        }
        QueryWrapper<TPaintingTopicEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("painting_uuid", entity.getDataUuid());
        tPaintingTopicDao.delete(queryWrapper);
        tPaintingTopicDao.insertObjects(entity.getDataUuid(), topicIds);
    }


    private void savaBaseInfo(TPaintingEntity tPaintingEntity) {
        this.baseMapper.insert(tPaintingEntity);
    }

}