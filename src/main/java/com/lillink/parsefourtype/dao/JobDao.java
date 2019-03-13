package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Job;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobDao extends Dao implements BaseDao<Job>{

    public static final String FIND_ALL_QUERRY = "select * from jobs";
    public static final String UPDATE_ALL_QUERRY = "update jobs set start_work = ?, position = ?, end_work = ?";
    public static final String INSERT_ALL_QUERRY = "INSERT INTO jobs (start_work,position,end_work) VALUES (?,?,?)";
    public static final String FIND_BY_ID_QUERRY = "SELECT * FROM jobs WHERE id = ?";

    @Override
    public Job findById(Long id) {
        Job job = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERRY);
            statement.setObject(1,id);
            ResultSet set = statement.executeQuery();
            if (set.first()){
                job = new Job();
                job.setId(id);
                job.setBeginWork(LocalDate.parse(set.getDate("start_work").toString()));
                job.setPosition("position");
                job.setEndWork(LocalDate.parse(set.getDate("end_work").toString()));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return job;
    }

    @Override
    public List<Job> findAll() {
        List<Job> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERRY);

            while (set.next()){
                Job job = new Job();

                job.setId(set.getLong("id"));
                job.setBeginWork(LocalDate.parse(set.getDate("start_work").toString()));
                job.setPosition(set.getString("position"));
                job.setEndWork(LocalDate.parse(set.getDate("end_work").toString()));

                resultList.add(job);
            }
            System.out.println("All jobs get from database");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    @Override
    public void save(Job job) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_ALL_QUERRY);
            statement.setString(1, job.getBeginWork());
            statement.setString(2, job.getPosition());
            statement.setString(3, job.getEndWork());

            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        PreparedStatement statement = null;
        try {

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
