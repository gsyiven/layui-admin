package org.alex.admin.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.alex.admin.core.anno.Log;
import org.alex.admin.core.anno.Resource;
import org.alex.admin.core.bean.Rest;
import org.alex.admin.core.controller.CrudController;
import org.alex.admin.web.entity.SysProduct;
import org.alex.admin.web.entity.SysUser;
import org.alex.admin.web.service.ISysProductService;
import org.alex.admin.web.util.BaseUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.storm.shade.org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
/**
 * 标准的Rest接口,实例控制器
 * Created by Song Guo 2020年9月11日
 */
@Controller
@RequestMapping("/product")
public class ProductController extends CrudController<SysProduct, ISysProductService>{

    @Autowired private ISysProductService sysProductService;

    @Resource("listProduct")
    @ResponseBody
    @RequestMapping("/page")
    public Rest page(
            @RequestParam (required = true,defaultValue="1") Integer page,
            @RequestParam (defaultValue="15")Integer size,String keyword,Model model){
        EntityWrapper<SysProduct> ew = new EntityWrapper<SysProduct>();
//        if(StringUtils.isNotBlank(keyword)){
//            ew.like("productName", keyword);
//        }
        Page<SysProduct> pageData = sysProductService.selectPage(new Page<SysProduct>(page, size), ew);
        return Rest.okData(pageData);
    }

    /**
     * 按条件查询product
     */
    @ResponseBody
    @RequestMapping("/queryProduct")
    public Rest queryProduct(String productName) {
        Integer page = 1;
        Integer size = 15;
        EntityWrapper<SysProduct> ew = new EntityWrapper<SysProduct>();
        Page<SysProduct> pageData = sysProductService.selectPage(new Page<SysProduct>(page, size), ew.like("productName", productName));
        return Rest.okData(pageData);

//        String productName = params.get("productName").toString();
//        List<SysProduct> products = sysProductService.queryProduct(productName);
//        return Rest.okData(pageData);
//        SysProduct products = sysProductService.selectOne(new EntityWrapper<SysProduct>().like("productName",productName));
//        Page<SysProduct> pageData = new Page<>();
//        pageData.setRecords(products);
//        return Rest.okData(pageData);
//        JSONObject json = new JSONObject();
//        json.put("code", 0);
//        json.put("data", products);
//        return json.toJSONString();
//        return Json(new { code = 0, count = Count, data = list, msg = "获取数据成功！" });
    }

    /**
     * 获取所有product
     * @return
     */
    @ResponseBody
    @GetMapping("/listproduct")
    public Rest listproduct(HttpServletRequest request){
        List<SysProduct> list = sysProductService.getList();
        return Rest.okData(list);
    }

    /**
     * 执行新增product
     * @param product
     * @param result
     * @return
     */
    @Log("新增product")
    @Resource("addProduct")
    @ResponseBody
    @RequestMapping("/doAdd")
    public Rest doAdd(@Valid SysProduct product,BindingResult result){

        if(result.hasErrors()){
            String firstError = result.getFieldErrors().get(0).getDefaultMessage();
            return Rest.failure(firstError);
        }
        sysProductService.insert(product);
        return Rest.ok("添加成功!");
    }
    /**
     * 执行编辑用户
     * @param product
     * @param result
     * @return
     */
    @Log("编辑product")
    @Resource("editProduct")
    @ResponseBody
    @RequestMapping("/doEdit")
    public Rest doEdit(@Valid SysProduct product,BindingResult result){
        if(result.hasErrors()){
            String firstError = result.getFieldErrors().get(0).getDefaultMessage();
            return Rest.failure(firstError);
        }
        if(product == null || StringUtils.isBlank(String.valueOf(product.getId()))){
            throw new RuntimeException("参数{id}不能为空");
        }
        sysProductService.updateById(product);
        return Rest.ok("编辑成功!");
    }

    @Override
    public String getViewName() {
        // TODO Auto-generated method stub
        return "product";
    }

    @Override
    public String getModelName() {
        // TODO Auto-generated method stub
        return "product";
    }

    @Override
    public String edit(String id, Model model) {
        // TODO Auto-generated method stub
        if(StringUtils.isBlank((String)id)){
            throw new RuntimeException("参数{id}不能为空");
        }
        SysProduct sysProduct = sysProductService.selectById(id);
        if(sysProduct == null){
            throw new RuntimeException("未查询到要编辑的菜单");
        }
        model.addAttribute("product", sysProduct);
        return "product/edit";
    }

    /**
     * 添加子product
     * @param id
     * @param model
     * @return
     */
    @Resource("addProduct")
    @RequestMapping("/addProduct")
    public String addItem(String id, Model model) {
        // TODO Auto-generated method stub
        if(StringUtils.isBlank((String)id)){
            throw new RuntimeException("参数{id}不能为空");
        }
        SysProduct sysProduct= sysProductService.selectById(id);
        if(sysProduct == null){
            throw new RuntimeException("未查询到要操作的菜单");
        }
        model.addAttribute("product", sysProduct);
        return "product/add";
    }

    /**
     * 执行添加子product
     * @param product
     * @param result
     * @return
     */
    @Log("编辑子product")
    @Resource("addProduct")
    @ResponseBody
    @RequestMapping("/doAddItem")
    public Rest doAddItem(@Valid SysProduct product,BindingResult result){
        if(result.hasErrors()){
            String firstError = result.getFieldErrors().get(0).getDefaultMessage();
            return Rest.failure(firstError);
        }
        sysProductService.insert(product);
        return Rest.ok("添加成功!");
    }
}
