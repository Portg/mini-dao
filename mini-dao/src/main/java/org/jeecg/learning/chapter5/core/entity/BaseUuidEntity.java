package org.jeecg.learning.chapter5.core.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

/**
 * 框架提供一个基础的UUID方式的实体对象定义参考
 */
@MappedSuperclass
public abstract class BaseUuidEntity {

    private String id;

    @Id
    @Column(nullable=false,length=32)
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        //容错处理id以空字符提交参数时修改为null避免hibernate主键无效修改
        if (StringUtils.isBlank(id)) {
            this.id = null;
        } else {
            this.id = id;
        }
    }
}
