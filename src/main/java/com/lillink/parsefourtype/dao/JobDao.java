package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Job;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.apache.logging.log4j.LogManager.getLogger;
import static com.lillink.parsefourtype.utility.ClassNameUtil.getClassName;

public class JobDao extends Dao implements BaseDao<Job>{

    public static final String FIND_ALL_QUERY = "SELECT * FROM jobs";
    public static final String UPDATE_ALL_QUERY = "UPDATE jobs SET start_work = ?, position = ?, end_work = ? WHERE id = ?";
    public static final String INSERT_ALL_QUERY = "INSERT INTO jobs (start_work,position,end_work) VALUES (?,?,?)";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM jobs WHERE id = ?";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM jobs WHERE id = ?";

    private static final Logger LOGGER = getLogger(getClassName());

    @Override
    public Job findById(Long id) {
        Job job = null;
        LOGGER.trace("Started finding by id {} in database", id);
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY);
            statement.setObject(1,id);
            ResultSet set = statement.executeQuery();
            if (set.first()){
                job = new Job();
                job.setId(id);
                job.setBeginWork(LocalDate.parse(set.getDate("start_work").toString()));
                job.setPosition("position");
                job.setEndWork(LocalDate.parse(set.getDate("end_work").toString()));
            }
            LOGGER.trace("Job {} found by id successfully ", id);
        }catch (SQLException e){
            LOGGER.warn("Job {} wasn't found in database ", id, e);
        }
        return job;
    }

    @Override
    public List<Job> findAll() {
        List<Job> resultList = new ArrayList<>();
        LOGGER.trace("Started finding all in database ");
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERY);

            while (set.next()){
                Job job = new Job();

                job.setId(set.getLong("id"));
                job.setBeginWork(LocalDate.parse(set.getDate("start_work").toString()));
                job.setPosition(set.getString("position"));
                job.setEndWork(LocalDate.parse(set.getDate("end_work").toString()));

                resultList.add(job);
            }
            LOGGER.trace("Job found all successfully ");
        } catch (SQLException e) {
            LOGGER.warn("Job wasn't found in database ", e);
        }

        return resultList;
    }

    @Override
    public Long save(Job job) {
//        LOGGER.trace("Started saving");
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
            LOGGER.trace("Job {} entered all in database", job);
        } catch (SQLException e){
            LOGGER.warn("Job {} wasn't entered in database", job, e);
        }
        return job.getId();
    }

    @Override
    public void delete(Long id) {
        PreparedStatement statement = null;
        LOGGER.trace("Started deleting client with id {} from database", id);
        try {
            statement = Objects.requireNonNull(connection).prepareStatement(DELETE_BY_ID_QUERY);
            statement.setLong(1,id);
            statement.execute();
            LOGGER.trace("Job with id {} deleted successfully ", id);
        }catch (SQLException e){
            LOGGER.warn("Job {} wasn't delete in database");
        }
    }
}
