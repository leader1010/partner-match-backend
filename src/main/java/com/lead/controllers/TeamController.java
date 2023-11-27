package com.lead.controllers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lead.common.BaseResponse;
import com.lead.common.DeleteRequest;
import com.lead.common.ErrorCode;
import com.lead.common.ResultUtils;
import com.lead.exception.BusinessException;
import com.lead.model.domain.Team;
import com.lead.model.domain.User;
import com.lead.model.request.TeamAddRequest;
import com.lead.service.TeamService;
import com.lead.service.UserService;
import com.lead.service.UserTeamService;
import com.sun.source.doctree.SummaryTree;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

@Tag(name = "team接口")
@Slf4j
@RestController
@RequestMapping("/team")
@CrossOrigin(origins = {"http://127.0.0.1:5173"}, allowCredentials = "true")
public class TeamController {

    @Resource
    private TeamService teamService;

    @Resource
    private UserService userService;

    @Resource
    private UserTeamService userTeamService;

    @Operation(summary = "创建队伍")
    @PostMapping("/create")
    public BaseResponse<Long> addTeam(TeamAddRequest teamAddRequest, HttpServletRequest request){
        if (teamAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User logininUser = userService.getLogininUser(request);
        Team team = new Team();
        BeanUtils.copyProperties(teamAddRequest, team);
        long teamId = teamService.addTeam(team, logininUser);
        return ResultUtils.success(teamId);
    }

    @Operation(summary = "删除队伍")
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteTeam(DeleteRequest deleteRequest, HttpServletRequest request){

        User logininUser = userService.getLogininUser(request);
        long id = deleteRequest.getId();
//        long id =

        Boolean result = teamService.deleteTeam(id, logininUser);
        return ResultUtils.success(true);



    }



}
