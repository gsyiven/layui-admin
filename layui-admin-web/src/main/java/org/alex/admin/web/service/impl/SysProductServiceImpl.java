package org.alex.admin.web.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import org.alex.admin.web.controller.FileUploadController;
import org.alex.admin.web.entity.SysProduct;
import org.alex.admin.web.entity.SysRoleMenu;
import org.alex.admin.web.mapper.SysMenuMapper;
import org.alex.admin.web.mapper.SysProductMapper;
import org.alex.admin.web.mapper.SysRoleMenuMapper;
import org.alex.admin.web.service.ISysProductService;
import org.alex.admin.web.util.BaseUtil;
import org.alex.admin.web.util.ExcelUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.base.Splitter;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.Subject;

/**
 * <p>
 * 产品表 服务实现类
 * </p>
 *
 * @author Song.Guo
 * @since 2020-09-11
 */
@Service
public class SysProductServiceImpl extends ServiceImpl<SysProductMapper, SysProduct> implements ISysProductService {

    public static final Logger logger = Logger.getLogger(FileUploadController.class);

    @Autowired
    private SysProductMapper sysProductMapper;

    @Override
    public SysProduct getById(long productId) {
        return sysProductMapper.getById(productId);
    }

    @Override
    public List<SysProduct> getList() {
        return sysProductMapper.queryAll();
    }

    @Override
    public List<SysProduct> queryProduct(String productName) {
        return sysProductMapper.queryProduct(productName);
    }
    @Override
    public String ajaxUploadExcel(MultipartFile file) {
        // TODO Auto-generated method stub
        // 获取IO流
        InputStream in = null;
        try {
            in = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return "系统导入表格出错！";
        }

        // 获取IO流的数据
        List<List<Object>> listob = null;
        try {
            listob = new ExcelUtils().getBankListByExcel(in, file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            return "系统获取表格内容出错！";
        }

        // 对表格内容进行初步检验，避免同一张表中，有些人注册了有些人没有，不能重新导入表格
        logger.debug("表格数据条数: " + listob.size());
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);


            // 对表格内容是否缺少，格式是否正确进行检查
            try {
                String.valueOf(lo.get(0));
                String.valueOf(lo.get(1));
                String.valueOf(lo.get(2));
                String.valueOf(lo.get(3));
                String.valueOf(lo.get(4));
                String.valueOf(lo.get(5));
                String.valueOf(lo.get(6));
                String.valueOf(lo.get(7));
                String.valueOf(lo.get(8));
                String.valueOf(lo.get(9));
                String.valueOf(lo.get(10));
                String.valueOf(lo.get(11));
                String.valueOf(lo.get(12));
                String.valueOf(lo.get(13));
            } catch (Exception e) {
                return "表格内容有误，请重新导入表格！";
            }
        }

        // 此处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            SysProduct product = new SysProduct();
            product.setProductName(String.valueOf(lo.get(0)));
            product.setDetectionLocation(String.valueOf(lo.get(1)));
            product.setDetectionDate(String.valueOf(lo.get(2)));
            product.setDetectionResult(String.valueOf(lo.get(3)));
            product.setFirstClass(String.valueOf(lo.get(4)));
            product.setSecondClass(String.valueOf(lo.get(5)));
            product.setThirdClass(String.valueOf(lo.get(6)));
            product.setFourthClass(String.valueOf(lo.get(7)));
            product.setCompany(String.valueOf(lo.get(8)));
            product.setManufacturer(String.valueOf(lo.get(9)));
            product.setBrand(String.valueOf(lo.get(10)));
            product.setSpec(String.valueOf(lo.get(11)));
            product.setProductionDate(String.valueOf(lo.get(12)));
            product.setInspectionAgency(String.valueOf(lo.get(13)));
            //写入数据库
            sysProductMapper.add(product);
        }

        return "导入成功！";
    }
}
