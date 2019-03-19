package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Job;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;


public class JobDaoTest {

    private BaseDao<Job> jobDao;

    @BeforeClass
    public void init(){
        this.jobDao = new JobDao();
    }

    @Test
    public void testSave() {
        Job job1 = new Job();
        LocalDate beginWorkJob1 = LocalDate.now();
        job1.setBeginWork(beginWorkJob1);
        job1.setEndWork(beginWorkJob1.plusDays(5));
        job1.setPosition("Java dev");

        jobDao.save(job1);

        Job job2 = new Job();
        job2.setId(2L);
        LocalDate beginWorkJob2 = LocalDate.now();
        job2.setBeginWork(beginWorkJob2);
        job2.setEndWork(beginWorkJob2.plusDays(5));
        job2.setPosition("Lol dev");

        jobDao.save(job2);
    }

    @Test
    public void testFindById(){
        Job job1 = new Job();
        LocalDate beginWorkJob1 = LocalDate.now();
        job1.setBeginWork(beginWorkJob1);
        job1.setEndWork(beginWorkJob1.plusDays(5));
        job1.setPosition("Java dev");

        Long savedId = jobDao.save(job1);

        Assert.assertEquals(jobDao.findById(savedId),job1);
    }

    @Test
    public void testDelete(){
        jobDao.delete(9L);
    }
}
