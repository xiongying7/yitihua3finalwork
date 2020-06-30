package cn.edu.nenu.domain;

import cn.edu.nenu.config.Constants;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;


@Data
@Accessors(chain = true)
@Entity
@Table(name = "T_PART")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 36,nullable = false)
    private String type; //文章类型
    @Column(length = 64,nullable = false)
    private String name; //文章名称
    @Column(length = 64,nullable = false)
    private String writer; //文章作者

    private float sort=0;//排序


}
