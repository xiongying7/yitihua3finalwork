package cn.edu.nenu.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Accessors(chain = true)
@Entity
@Table(name = "T_ORGANIZATION")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//主键编码
    @Column(length = 128,nullable = false)
    private String name;//名称
    @Column(nullable = false)
    private float sort;//排序
    @Column(nullable = false)
    private Integer pId;//父编码
    @Column(length = 240,unique = true)
    private String autoCode;//四位一体编码(60层)
}

