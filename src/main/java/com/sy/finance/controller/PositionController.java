package com.sy.finance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.finance.domain.Position;
import com.sy.finance.domain.Userinfo;
import com.sy.finance.service.PositionService;
import com.sy.finance.surictiy.SelfUserDetails;
import com.sy.finance.surictiy.SelfUserService;
import com.sy.finance.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author sy
 * @date Created in 2020.9.18 23:15
 * @description 操作人员
 */
@RestController
@RequestMapping("/position")
@Api(tags = "操作人员管理")
public class PositionController  {

    @Resource
    private  PositionService positionService;


    @PostMapping(value = "updateById")
    @ApiOperation(value = "根据主键id修改信息 ")
    public RespBean sdf(@RequestBody Position position){
        positionService.updateByPrimaryKeySelective(position);
        return RespBean.succeed();
    }

    @GetMapping("/getPositionList")
    @ApiOperation(value = "获取操作人员列表")
    public  RespBean<PageInfo<List<Position>>> getUserInfoList(@RequestParam Integer page, @RequestParam Integer pageSize,  @RequestParam(required = false) String userName){

        PageHelper.startPage(page,pageSize);
        Position position = new Position();

        SelfUserDetails userInfo = SelfUserService.getUserInfo();
        if (!"admin".equals(userInfo.getRoleName())){
            position.setAddUserId(userInfo.getId());
        }
        position.setUserName(userName);
        List<Position> userinfos = positionService.selectByAll(position);
        PageInfo<List<Position>> listPageInfo = new PageInfo(userinfos);
        return RespBean.succeed(listPageInfo);
    }

    @PostMapping(value = "addPosition")
    @ApiOperation(value = "添加操作人员")
    public RespBean addPosition(@RequestBody Position position){
        SelfUserDetails userInfo = SelfUserService.getUserInfo();
        position.setCreated(new Date());
        position.setAddUserId(userInfo.getId());
        positionService.insert(position);
        return RespBean.succeed();
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "主键id查询")
    public RespBean<Position> selectById(@RequestParam Integer id){
        Position position = positionService.selectByPrimaryKey(id);
        return RespBean.succeed(position);
    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "主键id删除")
    public RespBean<Position> deleteById(@RequestParam Integer id){
        positionService.deleteByPrimaryKey(id);
        return RespBean.succeed();
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "获取全部操作人员")
    public RespBean<List<Position>> getAll(){
        SelfUserDetails userInfo = SelfUserService.getUserInfo();
        Position position = new Position();
        if (!"admin".equals(userInfo.getRoleName())){
            position.setAddUserId(userInfo.getId());
        }
        List<Position> positions = positionService.selectByAll(position);
        return RespBean.succeed(positions);
    }

}
