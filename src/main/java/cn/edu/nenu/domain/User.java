package cn.edu.nenu.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Accessors(chain = true)
@Entity
@Table(name = "t_user") //数据库表名
public class User {


    @Id //主键ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 生成主键策略
    private Integer id; //

    // 列名、长度32个字符、是否为空（false否，不允许为空）、是否唯一（true唯一）
    @Column(name = "username",length = 32,nullable = false,unique = true)
    private String username;
    private String password;
    private String phone;
    private String email;
    private String createTime;
    private Integer status;//状态

    private float sort=0;
    //@Temporal(value = TemporalType.DATE )

}
