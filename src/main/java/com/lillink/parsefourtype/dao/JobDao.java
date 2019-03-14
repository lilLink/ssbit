package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Job;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JobDao extends Dao implements BaseDao<Job>{

    public static final String FIND_ALL_QUERRY = "select * from jobs";
    public static final String UPDATE_ALL_QUERY = "update jobs set start_work = ?, position = ?, end_work = ? WHERE id = ?";
    public static final String INSERT_ALL_QUERY = "INSERT INTO jobs (start_work,position,end_work) VALUES (?,?,?)";
    public static final String FIND_BY_ID_QUERRY = "SELECT * FROM jobs WHERE id = ?";
    public static final String DELETE_BY_ID_QUERRY = "DELETE FROM jobs WHERE id = ?";

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
            String actionQuery = (job.getId() == null) ? INSERT_ALL_QUERY
                                                       : UPDATE_ALL_QUERY;
            PreparedStatement statement = connection.prepareStatement(actionQuery);

            statement.setTimestamp(1, Timestamp.valueOf(job.getBeginWork().atStartOfDay()));
            statement.setString(2, job.getPosition());
            statement.setTimestamp(3, Timestamp.valueOf(job.getEndWork().atStartOfDay()));
            if (job.getId() != null) {
                statement.setLong(4, job.getId());
            }

            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        PreparedStatement statement = null;
        try {
            statement = Objects.requireNonNull(connection).prepareStatement(DELETE_BY_ID_QUERRY);
            statement.setLong(1,id);
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
