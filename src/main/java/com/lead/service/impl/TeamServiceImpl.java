package com.lead.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lead.mapper.TeamMapper;
import com.lead.model.domain.Team;
import com.lead.service.TeamService;
import org.springframework.stereotype.Service;

/**
* @author my_computer
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2023-11-24 00:49:11
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService{

}




