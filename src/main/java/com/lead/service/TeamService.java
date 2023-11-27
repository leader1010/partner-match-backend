package com.lead.service;

import com.lead.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lead.model.domain.User;

/**
* @author my_computer
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2023-11-24 00:49:11
*/
public interface TeamService extends IService<Team> {

    long addTeam(Team team, User logininUser);

    Boolean deleteTeam(long id, User logininUser);
}
