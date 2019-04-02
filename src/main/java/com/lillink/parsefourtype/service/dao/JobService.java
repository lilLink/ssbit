package com.lillink.parsefourtype.service.dao;

import com.lillink.parsefourtype.dao.JobDao;
import com.lillink.parsefourtype.model.Job;
import com.lillink.parsefourtype.model.Person;

import java.util.List;

public class JobService implements Service<Job> {
    private JobDao jobDao = new JobDao();

    @Override
    public List<Job> getAll(){
        return jobDao.findAll();
    }

    @Override
    public void delete(Long id){
        jobDao.delete(id);
    }

    @Override
    public Job getByPersonId(Long id){
        return jobDao.findByPersonId(id);
    }

    @Override
    public Job getById(Long id){
        return jobDao.findById(id);
    }

    public Long save(Job job, Long personId){
        return jobDao.save(job,personId);
    }
}
