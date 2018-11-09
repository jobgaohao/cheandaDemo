package com.cad.carlink.weixin.test.annotation;

@Table("Tbuser")
public class Filter {

    @Column(columnName = "pkid",searchType = ESearchType.EQUAL)
    public Long pkid;

    @Column(columnName = "name",searchType = ESearchType.LIKE)
    public String name;

    @Column(columnName="email",searchType=ESearchType.IN)
    public String email;

    public Long getPkid() {
        return pkid;
    }

    public void setPkid(Long pkid) {
        this.pkid = pkid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
