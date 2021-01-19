package group.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class GroupVO {
	private long groupId;
	private String groupName;
	private long createUserId;
	private String groupDesc;
}
