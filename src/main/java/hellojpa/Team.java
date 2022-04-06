package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")   //1팀에 n개의 멤버 올수 있음
    private List<Member01> members = new ArrayList<Member01>(); //ArrayList로 초기화 : add시 nullPointException 방지 가능

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

    public List<Member01> getMembers() {
        return members;
    }

    public void setMembers(List<Member01> members) {
        this.members = members;
    }
}
