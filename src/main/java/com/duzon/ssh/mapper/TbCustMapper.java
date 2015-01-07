package com.duzon.ssh.mapper;

import com.duzon.ssh.model.TbCust;
import com.duzon.ssh.model.TbCustExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCustMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_CUST
     *
     * @mbggenerated Tue Jun 24 11:42:50 KST 2014
     */
    int countByExample(TbCustExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_CUST
     *
     * @mbggenerated Tue Jun 24 11:42:50 KST 2014
     */
    int deleteByExample(TbCustExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_CUST
     *
     * @mbggenerated Tue Jun 24 11:42:50 KST 2014
     */
    int deleteByPrimaryKey(String NO_CUST);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_CUST
     *
     * @mbggenerated Tue Jun 24 11:42:50 KST 2014
     */
    int insert(TbCust record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_CUST
     *
     * @mbggenerated Tue Jun 24 11:42:50 KST 2014
     */
    int insertSelective(TbCust record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_CUST
     *
     * @mbggenerated Tue Jun 24 11:42:50 KST 2014
     */
    List<TbCust> selectByExample(TbCustExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_CUST
     *
     * @mbggenerated Tue Jun 24 11:42:50 KST 2014
     */
    TbCust selectByPrimaryKey(String NO_CUST);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_CUST
     *
     * @mbggenerated Tue Jun 24 11:42:50 KST 2014
     */
    int updateByExampleSelective(@Param("record") TbCust record, @Param("example") TbCustExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_CUST
     *
     * @mbggenerated Tue Jun 24 11:42:50 KST 2014
     */
    int updateByExample(@Param("record") TbCust record, @Param("example") TbCustExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_CUST
     *
     * @mbggenerated Tue Jun 24 11:42:50 KST 2014
     */
    int updateByPrimaryKeySelective(TbCust record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_CUST
     *
     * @mbggenerated Tue Jun 24 11:42:50 KST 2014
     */
    int updateByPrimaryKey(TbCust record);
}