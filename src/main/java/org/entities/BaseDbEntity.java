package org.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Audited
public class BaseDbEntity extends PanacheEntityBase {

  protected static final Boolean IS_ACTIVE = Boolean.TRUE;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "public_id")
  private String publicId;

  @Column(nullable = false, name = "active")
  private Boolean active;

  @Column(nullable = false, name = "created_at")
  private Instant createdAt;

  @Column(nullable = false, name = "last_modified")
  private Instant lastModified;

  @PrePersist
  @PreUpdate
  public void performPrePersistAndPreUpdateActions() {

    if (active == null) {
      active = true;
    }

    lastModified = Instant.now();
  }
}
