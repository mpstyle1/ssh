package com.duzon.ssh.mapper;

import com.duzon.ssh.model.MemberCard;
import com.duzon.ssh.model.MemberCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberCardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int countByExample(MemberCardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int deleteByExample(MemberCardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int deleteByPrimaryKey(String CARD_NO);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int insert(MemberCard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int insertSelective(MemberCard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    List<MemberCard> selectByExample(MemberCardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    MemberCard selectByPrimaryKey(String CARD_NO);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int updateByExampleSelective(@Param("record") MemberCard record, @Param("example") MemberCardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int updateByExample(@Param("record") MemberCard record, @Param("example") MemberCardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int updateByPrimaryKeySelective(MemberCard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEMBER_CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int updateByPrimaryKey(MemberCard record);
}