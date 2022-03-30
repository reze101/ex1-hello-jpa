package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        //영속상태
        //em.persist()해서 저장하거나, em.find()로 조회해서 1차캐시에 존재하는 상태

        //Persistence 클래스에서 META-INF에 있는 persistence.xml 설정 정보를 조회해 EntityManagerFactory를 생성함
        //EntityManagerFactory에서는 필요에 따라 EntityManager들을 생성함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //서버가 올라가는 시점에 db당 한개만 생성
        EntityManager em = emf.createEntityManager();   //트랜잭션 단위마다 하나씩 생성, 스레드간 공유xxx

        EntityTransaction tx = em.getTransaction();
        tx.begin(); //jpa의 모든 데이터 변경은 transaction안에서 실행되어야 함

        try{
            //등록
            /*
            Member member = new Member();
            member.setId(1L);
            member.setName("helloA");
            ///////////////////////////////////비영속 상태////////////////////////////////////

            em.persist(member); //영속성 컨텍스트 1차캐시에 저장 
            ///////////////////////////////////영속 상태(db에 저장되지 않음)////////////////////////////////////
            em.flush(member); //db에 반영 (쿼리 날아감)

            em.detach(member);    //영속성 컨텍스트에서 삭제(비영속상태)
            em.remove(member);    //db에 삭제요청(객체 삭제)

            */

            //조회
//            Member findMember = em.find(Member.class, 1L);    //방금 저장한 1L이므로 1차캐시 내에서 조회함 -> select query 가 나가지 않음
//            Member findMember2 = em.find(Member.class, 1L);
//            System.out.println("findMember.getId : " + findMember.getId());
//            System.out.println("findMember.getName : " + findMember.getName());
//            System.out.println("result = " + (findMember == findMember2));    //true  -> 같은 1차 캐시 내에 존재하므로

            //수정
//            findMember.setName("helloJPA");
//            em.persist(member); 가 필요없이 set으로 저장됨
//            변경이 생기면 트랜잭션 종료 전 자동으로 update쿼리를 생성하여 실행함

            //삭제
//            em.remove(findMember);            
            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();    //Member객체를 대상으로 하는 쿼리
            for (Member member : result) {
                System.out.println("memberName : " + member.getName());
            }

            //em.flush() : 영속성 컨텍스트의 변경 내용을 db에 반영
            //tx가 commit되는 시점에 자동으로 호출/ jpql쿼리 실행시 자동 호출
            //1차캐시에는 여전히 남아있고, 쓰기지연 sql저장소에 담겨있던 쿼리들만 날아감
            // 1. dirty checking(변경 감지)
            // 2. 수정된 엔티티를 쓰기지연 sql저장소에 등록
            // 3. 쓰기지연 sql저장소의 쿼리를 db에 전송(등록, 수정, 삭제쿼리 . . .)

            //준영속 상태(영속성컨텍스트에서 제거)
            //em.detach(entity) //특정 엔티티만 준영속상태로 전환
            //em.clear()    //영속성 컨텍스트 완전히 초기화
            //em.close()    //영속성 컨텍스트 종료


            tx.commit();    //이 때 db에 쿼리 전송
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();    //was 내려갈 때 emf도 닫기

    }

}
