package com.lead.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lead.mapper.UserTeamMapper;
import com.lead.model.domain.UserTeam;
import com.lead.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author my_computer
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2023-11-24 00:48:29
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




