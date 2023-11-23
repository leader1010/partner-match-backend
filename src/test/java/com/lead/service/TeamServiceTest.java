package com.lead.service;
import java.util.Date;

import com.lead.model.domain.Team;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeamServiceTest {

    @Resource
    TeamService teamService;



    @Test
    public void addTeam(){
        Team team = new Team();
        team.setId(0L);
        team.setName("");
        team.setDescription("");
        team.setMaxNum(0);
        team.setExpireTime(new Date());
        team.setUserId(0L);
        team.setStatus(0);
        team.setPassword("");
        team.setUpdateTime(new Date());



    }


}