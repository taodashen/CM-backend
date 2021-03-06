package org.unamedgroup.conference.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unamedgroup.conference.entity.Building;

import java.util.List;

/**
 * @Author: liumengxiao
 * @Date： 2019/4/2
 */

@Repository
public interface BuildingRepository extends CrudRepository<Building, Integer> {
    /**
     * 返回所有楼宇
     * 请慎用此方法！
     *
     * @return 列表：所有楼宇
     */
    @Override
    List<Building> findAll();

    /**
     * 根据楼宇号返回楼宇实体
     *
     * @param buildingID
     * @return 楼宇实体
     */
    Building getBuildingByBuildingID(Integer buildingID);

    /**
     * 根据地址名查询楼宇id
     * @param address 楼宇所在地址
     * @return 楼宇列表
     */
    List<Building> findByAddress(String address);

    @Query(value = "select distinct address from Building ")
    List<String> findDistinctAddress();
}
