package com.cskaoyan.service.Impl.Technology;

import com.cskaoyan.mapper.Technology.ProcessMapper;
import com.cskaoyan.bean.Technology.Process;
import com.cskaoyan.service.Technology.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;

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
    public List<Process> selectAll() {
        return processMapper.selectAll();
    }
}
