package com.lead.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lead.common.ErrorCode;
import com.lead.exception.BusinessException;
import com.lead.mapper.TeamMapper;
import com.lead.model.domain.Team;
import com.lead.model.domain.User;
import com.lead.model.domain.UserTeam;
import com.lead.service.TeamService;
import com.lead.service.UserService;
import com.lead.service.UserTeamService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author my_computer
 * @description 针对表【team(队伍)】的数据库操作Service实现
 * @createDate 2023-11-24 00:49:11
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
        implements TeamService {

    @Resource
    private UserTeamService userTeamService;

    @Resource
    private UserService userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long addTeam(Team team, User logininUser) {
        if (team == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (logininUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        Long userId = logininUser.getId();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", userId);
        team.setUserId(userId);
        boolean result = this.save(team);
        Long teamId = team.getId();
        if (!result || teamId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "创建队伍失败");
        }

        UserTeam userTeam = new UserTeam();
        result = userTeamService.save(userTeam);
        if (!result) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "创建队伍失败");
        }
        return teamId;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean deleteTeam(long id, User loginUser) {
        Long loginUserId = loginUser.getId();
        Team team = this.getById(id);
        Long createUserId = team.getUserId();
        if (!Objects.equals(loginUserId, createUserId)){
            throw new BusinessException(ErrorCode.NO_AUTH, "无访问权限");
        }

        // 移除所有加入队伍的关联信息
        QueryWrapper<UserTeam> userTeamQueryWrapper = new QueryWrapper<>();
        userTeamQueryWrapper.eq("teamId", id);
        boolean result = userTeamService.remove(userTeamQueryWrapper);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "删除队伍关联信息失败");
        }

        boolean res = this.removeById(id);
        return null;
    }
}




