package com.luckymall.mbg.dao;

import com.luckymall.mbg.entity.TAccount;
import com.luckymall.mbg.entity.TAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    long countByExample(TAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    int deleteByExample(TAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    int insert(TAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    int insertSelective(TAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    TAccount selectOneByExample(TAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    TAccount selectOneByExampleSelective(@Param("example") TAccountExample example, @Param("selective") TAccount.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    List<TAccount> selectByExampleSelective(@Param("example") TAccountExample example, @Param("selective") TAccount.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    List<TAccount> selectByExample(TAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TAccount record, @Param("example") TAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TAccount record, @Param("example") TAccountExample example);
}