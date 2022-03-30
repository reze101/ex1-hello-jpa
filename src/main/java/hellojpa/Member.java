package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //jpa가 관리
//@Table(name = "USER")   //USER테이블과 매핑
public class Member {

    @Id //pk위에
    private Long id;

    //   @Column(name = "username")  //db 컬럼명이 username인 컬럼과 매핑
    private String name;
    private int age;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
