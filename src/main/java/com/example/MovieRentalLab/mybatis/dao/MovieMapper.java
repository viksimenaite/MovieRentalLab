package com.example.MovieRentalLab.mybatis.dao;

import com.example.MovieRentalLab.mybatis.model.Movie;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE
     *
     * @mbg.generated Tue May 04 00:12:11 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE
     *
     * @mbg.generated Tue May 04 00:12:11 EEST 2021
     */
    int insert(Movie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE
     *
     * @mbg.generated Tue May 04 00:12:11 EEST 2021
     */
    Movie selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE
     *
     * @mbg.generated Tue May 04 00:12:11 EEST 2021
     */
    List<Movie> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE
     *
     * @mbg.generated Tue May 04 00:12:11 EEST 2021
     */
    int updateByPrimaryKey(Movie record);
}