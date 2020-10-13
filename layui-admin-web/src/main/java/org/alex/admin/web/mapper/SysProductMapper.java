package org.alex.admin.web.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import javafx.scene.control.Pagination;
import org.alex.admin.web.entity.SysProduct;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 产品表 Mapper 接口
 * </p>
 *
 * @author Song.Guo
 * @since 2020-09-11
 */
public interface SysProductMapper extends BaseMapper<SysProduct> {

    SysProduct getById(@Param("id") long id);

    void add(SysProduct product);

    /**
     * 查询所有product
     * @return
     */
    List<SysProduct> queryAll();

    /**
     * 查询符合条件的product
     * @return
     */
    List<SysProduct> queryProduct(@Param("productName") String productName);
}