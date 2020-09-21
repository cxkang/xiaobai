package com.xiaobai.loT.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;


import com.xiaobai.loT.dao.TAppDao;
import entity.PageUtils;
import entity.R;
import entity.Result;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiaobai.loT.entity.TAppEntity;
import com.xiaobai.loT.service.TAppService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Android App
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@RestController
@RequestMapping("loT/tapp")
public class TAppController {

    @Autowired
    private TAppService tAppService;
/**
 * apk文件下载
 */
@GetMapping(value = "/manage/download")
  public  R download(HttpServletRequest request, HttpServletResponse response,Long id) throws ServletException, IOException {

    String fileUrl = tAppService.getById(id).getFileUrl();
    // String fileUrl="http://pic2.sc.chinaz.com/files/pic/pic9/202009/hpic2924.jpg";
    String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);//获取要下载的文件名
    fileName = URLEncoder.encode(fileName,"UTF-8");
    response.setHeader("Content-Disposition","attachment;filename=" + fileName);
    response.setContentType("application/force-download");//应用程序强制下载
    //读取文件
    OutputStream out = response.getOutputStream();
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(fileUrl);
    CloseableHttpResponse httpResp = httpclient.execute(httpGet);
    try{
        HttpEntity httpEntity = httpResp.getEntity();
        response.setContentLength((int) httpEntity.getContentLength());
        IOUtils.copy(httpEntity.getContent(),out);
        return R.ok();
    }catch(Exception ex){
        httpclient.close();
        ex.printStackTrace();
        return R.error();
    }finally{
        out.flush();
        out.close();
    }
}



    /**
     * 版本号检测
     */


    @RequestMapping("/manage/VersionCheck")
    public R VsersionCheck(@RequestBody String appVersion) {

        TAppEntity tApp = tAppService.versionCheck(appVersion);
        if (tApp.getAppVer().equals(appVersion)) {
            return R.ok("当前版本就是最新版本");
        }
        return R.ok().put("tApp", tApp);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //  @RequiresPermissions("loT:tapp:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = tAppService.queryPage(params);

        return new Result();
    }


    /**
     * 查询设备信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("loT:tapp:info")
    public R info(@PathVariable("id") Integer id) {
        TAppEntity tApp = tAppService.getById(id);

        return R.ok().put("tApp", tApp);
    }


    @RequestMapping("/save")
    //@RequiresPermissions("loT:tapp:save")
    public R save(@RequestBody TAppEntity tApp) {

        return tAppService.saveApp(tApp);


    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TAppEntity tApp) {
        tAppService.updateById(tApp);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("loT:tapp:delete")
    public R delete(@RequestBody Integer[] ids) {
        tAppService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}
