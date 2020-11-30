package com.luckymall.mbg.dao;

import com.luckymall.mbg.entity.LuckyPermission;
import com.luckymall.mbg.entity.LuckyPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuckyPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lucky_permission
     *
     * @mbg.generated
     */
    long countByExample(LuckyPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lucky_permission
     *
     * @mbg.generated
     */
    int deleteByExample(LuckyPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lucky_permission
     *
     * @mbg.generated
     */
    int insert(LuckyPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lucky_permission
     *
     * @mbg.generated
     */
    int insertSelective(LuckyPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lucky_permission
     *
     * @mbg.generated
     */
    LuckyPermission selectOneByExample(LuckyPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lucky_permission
     *
     * @mbg.generated
     */
    LuckyPermission selectOneByExampleSelective(@Param("example") LuckyPermissionExample example, @Param("selective") LuckyPermission.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lucky_permission
     *
     * @mbg.generated
     */
    List<LuckyPermission> selectByExampleSelective(@Param("example") LuckyPermissionExample example, @Param("selective") LuckyPermission.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lucky_permission
     *
     * @mbg.generated
     */
    List<LuckyPermission> selectByExample(LuckyPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lucky_permission
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LuckyPermission record, @Param("example") LuckyPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lucky_permission
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LuckyPermission record, @Param("example") LuckyPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lucky_permission
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LuckyPermissionExample example);
}