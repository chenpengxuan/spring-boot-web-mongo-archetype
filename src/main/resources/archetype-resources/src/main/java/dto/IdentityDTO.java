package ${package}.dto;

import lombok.*;
import org.jongo.marshall.jackson.oid.MongoId;

import java.io.Serializable;
import java.util.Date;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
public class IdentityDTO implements Serializable {

    private static final long serialVersionUID = -6214385640883845689L;

    @MongoId
    private String uid;
}
