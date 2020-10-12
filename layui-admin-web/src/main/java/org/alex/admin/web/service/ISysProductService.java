package org.alex.admin.web.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import org.alex.admin.web.entity.SysMenu;

import com.baomidou.mybatisplus.service.IService;
import org.alex.admin.web.entity.SysProduct;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author GaoJun.Zhou
 * @since 2017-06-30
 */
public interface ISysProductService extends IService<SysProduct> {

    /**
     * 查询一种产品
     * @param productId
     */
    SysProduct getById(long productId);

    /**
     * 查询所有product
     * @return
     */
    List<SysProduct> getList();

    /**
     * 查询符合条件的product
     * @return
     */
    List<SysProduct> queryProduct(String productName);

//    /**
//     * 获取当前用户的权限资源
//     * @param uid
//     * @return
//     */
//    List<String> selectResourceByUid(String uid);

}
