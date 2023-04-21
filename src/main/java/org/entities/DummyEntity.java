package org.entities;


import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "dummy")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class DummyEntity extends BaseDbEntity {

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String dot;

  @Column(name = "profile_picture_url")
  private String profilePictureUrl;


  @Column(name = "external_id")
  private String externalId;

  @Column(name = "searchable_content")
  private String searchableContent;

  @Column(name = "last_modified_user_be", nullable = false)
  private Instant lastModifiedUserBe;
}
