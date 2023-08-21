package FirstProject.MINI.domain;


import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass       //Entity 들이 BaseTimeEntity를 상속할 경우 필드들을 Column으로 인식하게 한다.
@EntityListeners(AuditingEntityListener.class)  //BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;
    //Entity 생성시간 자동저장
    
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    //Entity 값 변경할때 시간 자동저장
}
