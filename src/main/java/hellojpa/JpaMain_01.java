package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_01 {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //서버가 올라가는 시점에 db당 한개만 생성
            EntityManager em = emf.createEntityManager();   //트랜잭션 단위마다 하나씩 생성, 스레드간 공유xxx

            EntityTransaction tx = em.getTransaction();
            tx.begin(); //jpa의 모든 데이터 변경은 transaction안에서 실행되어야 함

            try{
                //저장
                Team team = new Team();
                team.setName("TeamA");
                em.persist(team);

                Member01 member = new Member01();
                member.setUsername("지원");
                member.setTeam(team);
                em.persist(member);

                //db에서 값을 가져오기 위함
                em.flush();
                em.clear();

                //조회
                Member01 findMember = em.find(Member01.class, member.getId());  //select쿼리가 날아가지 않는 이유 : em.persist로 1차캐시에 등록되어있으므로
                List<Member01> members = findMember.getTeam().getMembers();
                for (int i = 0; i < members.size(); i++) {
                    System.out.println("team의 멤버는 > " + members.get(i).getUsername());
                }


                tx.commit();    //이 때 db에 쿼리 전송

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();    //was 내려갈 때 emf도 닫기
    }
}