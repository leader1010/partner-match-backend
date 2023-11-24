package com.lead.service;

import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lead.model.domain.Team;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamServiceTest {

    @Resource
    TeamService teamService;

    @Test
    public void testAddTeam() {
        Team team = new Team();
        team.setId(0L);
        team.setName("");
        team.setDescription("");
        team.setMaxNum(0);
        team.setExpireTime(new Date());
        team.setUserId(0L);
        team.setStatus(0);
        team.setPassword("123456");
        boolean res = teamService.save(team);
        Assertions.assertTrue(res);
    }

    @Test
    public void testGetTeam() {
        QueryWrapper<Team> teamQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Team> name = teamQueryWrapper.eq("name", "妹子,认识一下吧");
        Team one = teamService.getOne(name);
        Assertions.assertNotNull(one);
    }

    @Test
    public void testUpdateTeam() {
        Team team = new Team();
        team.setId(1L);
        team.setName("aq520");
        team.setDescription("");
        team.setMaxNum(0);
        team.setExpireTime(new Date());
        team.setUserId(0L);
        team.setStatus(0);
        team.setPassword("xxx");

        boolean res = teamService.updateById(team);
        Assertions.assertTrue(res);
    }

    @Test
    public void testDeleteTeam() {
        boolean res = teamService.removeById(1L);
        Assertions.assertTrue(res);
    }


}