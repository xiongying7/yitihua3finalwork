package cn.edu.nenu.domain;

import javax.persistence.Id;
import javax.persistence.ManyToOne;


//@Data
//@Accessors(chain = true)
//@Entity
//@Table(name = "T_CATEGORY_POST_CORR")
public class CategoryPostCorr {

    @Id
    private String id;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Post post;
}
