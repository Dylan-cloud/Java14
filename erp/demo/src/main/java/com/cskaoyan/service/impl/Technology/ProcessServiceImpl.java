package com.cskaoyan.service.impl.Technology;

import com.cskaoyan.bean.Technology.TechnologyPlan;
import com.cskaoyan.mapper.Technology.ProcessMapper;
import com.cskaoyan.bean.Technology.Process;
import com.cskaoyan.mapper.Technology.TechnologyPlanMapper;
import com.cskaoyan.service.Technology.ProcessService;
import com.cskaoyan.util.EUDataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Override
    public int deleteByPrimaryKey(String processId) {
        return processMapper.deleteByPrimaryKey(processId);
    }

    @Override
    public int insert(Process record) {
        return processMapper.insert(record);
    }

    @Override
    public int insertSelective(Process record) {
        return processMapper.insertSelective(record);
    }

    @Override
    public Process selectByPrimaryKey(String processId) {
        return processMapper.selectByPrimaryKey(processId);
    }

    @Override
    public int updateByPrimaryKeySelective(Process record) {
        return processMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Process record) {
        return processMapper.updateByPrimaryKey(record);
    }

    @Override
    public EUDataGridResult selectPageTechnology(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Process> list = processMapper.selectAll();
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Process> pageInfo = new PageInfo<>(list);
        result.setTotal(list.size());
        return result;
    }

    @Override
    public List<Process> findAll() {
        List<Process> list = processMapper.selectAll();
        return list;
    }

    @Override
    public Process selectProcessById(String searchValue) {
        return processMapper.selectProcessById(searchValue);
    }

    @Override
    public List<Process> selectProcessByTechnologyId(String searchValue) {
        return processMapper.selectProcessByTechnologyId(searchValue);
    }

}
