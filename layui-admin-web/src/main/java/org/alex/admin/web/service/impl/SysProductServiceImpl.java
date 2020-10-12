package org.alex.admin.web.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import org.alex.admin.web.entity.SysProduct;
import org.alex.admin.web.entity.SysRoleMenu;
import org.alex.admin.web.mapper.SysMenuMapper;
import org.alex.admin.web.mapper.SysProductMapper;
import org.alex.admin.web.mapper.SysRoleMenuMapper;
import org.alex.admin.web.service.ISysProductService;
import org.alex.admin.web.util.BaseUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.base.Splitter;

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
}
