package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Job;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobDao extends Dao implements BaseDao<Job>{

    public static final String FIND_ALL_QUERRY = "select * from jobs";
    public static final String UPDATE_ALL_QUERRY = "update jobs set start_work = ?, position = ?, end_work = ?";

    @Override
    public Job findById(Long id) {

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
    public Job update(Job job) {
        List<Job> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(UPDATE_ALL_QUERRY);

            LocalDate begin = LocalDate.parse(set.getDate("start_work").toString());
            String position = set.getString("position");
            LocalDate end = LocalDate.parse(set.getDate("end_work").toString());

            job.setBeginWork(begin);
            job.setPosition(position);
            job.setEndWork(end);

            resultList.add(job);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Job save(Job job) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
