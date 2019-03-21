package com.lillink.parsefourtype.service.dao;

import com.lillink.parsefourtype.dao.JobDao;
import com.lillink.parsefourtype.model.Job;

import java.util.List;

public class JobService implements Service<Job> {
    private JobDao jobDao = new JobDao();

    @Override
    public List<Job> getAll(){
        return jobDao.findAll();
    }

    @Override
    public void remove(Long id){
        jobDao.delete(id);
    }

    @Override
    public Job getById(Long id){
        return jobDao.findById(id);
    }

    public Long add(Job job){
        return jobDao.save(job);
    }
}
