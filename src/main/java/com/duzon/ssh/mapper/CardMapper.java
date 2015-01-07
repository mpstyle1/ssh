package com.duzon.ssh.mapper;

import com.duzon.ssh.model.Card;
import com.duzon.ssh.model.CardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int countByExample(CardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int deleteByExample(CardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int deleteByPrimaryKey(String CARD_ITEM);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int insert(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int insertSelective(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    List<Card> selectByExample(CardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    Card selectByPrimaryKey(String CARD_ITEM);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int updateByExampleSelective(@Param("record") Card record, @Param("example") CardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int updateByExample(@Param("record") Card record, @Param("example") CardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int updateByPrimaryKeySelective(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CARD
     *
     * @mbggenerated Thu Jun 19 17:56:35 KST 2014
     */
    int updateByPrimaryKey(Card record);
}