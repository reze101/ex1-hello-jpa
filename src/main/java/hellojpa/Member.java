//package hellojpa;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Entity //jpa가 관리
////@Table(name = "USER")   //USER테이블과 매핑
////@SequenceGenerator(
////        name = "MEMBER_SEQ_GENERATOR",  //id에 매핑시킬 고유 sequence name
////        sequenceName = "MEMBER_SEQ",    //db에 생성되는 sequence name
////        initialValue = 1,
////        allocationSize = 1
////)
//public class Member {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //id값 자동할당, db방언에 맞게 생성
//    private Long id;
//    @Column(name = "name", updatable = false, nullable = false, columnDefinition = "varchar(100) default 'EMPTY'")  //db컬럼명, update 될 수 없는 컬럼, not null제약조건, 직접 컬럼 제약조건 생성가능 (varchar100, 기본값 EMPTY )
//    private String username;
//    private Integer age;
//    @Enumerated(EnumType.STRING)    //Enum매핑(default EnumType.ORDINAL : ENUM의 순서를 저장하므로 위험/EnumType.STRING은 ENUM 그 자체를 저장하므로 권장 )
//    private RoleType roleType;
//    @Temporal(TemporalType.TIMESTAMP)   //날짜타입 매핑
//    private Date createdDate;   //생성일
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;  //수정일
//    @Lob    //길이에 제한 없는 varchar
//    private String description;
//
//    private LocalDate testLocalDate;    //연월(date)
//    private LocalDateTime testLocalDateTime;    //연월일(timestamp)
//
//    @Transient  //db컬럼과 관련없이 자바에서만 사용함을 알림, db에 create쿼리 안 날아감
//    private int temp;
//
//    public Member() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(RoleType roleType) {
//        this.roleType = roleType;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
////    @Id //pk위에
////    private Long id;
////
//////    @Column(name = "username", unique = true, length = 10)  //db 컬럼명이 username인 컬럼과 매핑, unique제약조건, varchar(10)으로 길이 지정해서 디비생성
////    private String name;
////    private int age;
////
////    public Member() {
////    }
////
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public int getAge() {
////        return age;
////    }
////
////    public void setAge(int age) {
////        this.age = age;
////    }
//
//}
