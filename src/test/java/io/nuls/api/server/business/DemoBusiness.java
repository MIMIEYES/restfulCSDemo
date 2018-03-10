package io.nuls.api.server.business;

import io.nuls.api.server.dao.mapper.DemoMapper;
import io.nuls.api.server.entity.Demo;
import io.nuls.api.server.entity.DemoParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemoBusiness {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table demo
     *
     * @mbggenerated
     */
    private static Logger logger = LoggerFactory.getLogger(DemoBusiness.class);

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table demo
     *
     * @mbggenerated
     */
    @Autowired 
    private DemoMapper demoMapper;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated
     */
    @Transactional(propagation=Propagation.REQUIRED,isolation =Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int insertSelective(Demo obj) throws Exception {
        if(obj  == null ){
            return 0;
        }
        return this.demoMapper.insertSelective(obj);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated
     */
    @Transactional(propagation=Propagation.REQUIRED,isolation =Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int insertSelective(List<Demo> list) throws Exception {
        int insertCount = 0;
        if (list == null || list.size() == 0) {
            return insertCount;
        }
        for (Demo  obj : list) {
            if (obj == null) {
                continue;
            }
            try {
                insertCount += this.demoMapper.insertSelective(obj);
            } catch (Exception e) {
                throw e;
            }
        }
        return insertCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated
     */
    public Demo getDemoByKey(Long key) throws Exception {
        return this.demoMapper.selectByPrimaryKey(key);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated
     */
    @Transactional(propagation=Propagation.REQUIRED,isolation =Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int update(Demo obj) throws Exception {
        if(obj  == null ){
            return 0;
        }
        return this.demoMapper.updateByPrimaryKeySelective(obj);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated
     */
    @Transactional(propagation=Propagation.REQUIRED,isolation =Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int update(List<Demo> list) throws Exception {
        int updateCount = 0;
        if (list == null || list.size() == 0) {
            return updateCount;
        }
        for (Demo  obj : list) {
            if (obj == null || obj.getId() == null || obj.getId() <= 0 ) {
                continue;
            }
            try {
                updateCount += this.demoMapper.updateByPrimaryKeySelective(obj);
            } catch (Exception e) {
                throw e;
            }
        }
        return updateCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated
     */
    public List<Demo> selectDemoList(DemoParam param) throws Exception {
        return this.demoMapper.selectByExample(param);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated
     */
    public int countDemoList(DemoParam param) throws Exception {
        return this.demoMapper.countByExample(param);
    }
}