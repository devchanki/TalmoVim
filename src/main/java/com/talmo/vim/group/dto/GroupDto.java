package com.talmo.vim.group.dto;

import com.talmo.vim.group.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class GroupDto {
    @Getter
    @AllArgsConstructor @Builder
    public static class Create {
        private String name;
        private String desc;

        //TODO : Group의 status 정책을 dto에서 설정하는 것이 맞는가?
        public Group toEntity() {
            String status = "USE";
            Group entity = Group.builder().name(this.name).desc(this.desc).status(status).build();
            return entity;
        }
    }

    @Getter @Setter
    @AllArgsConstructor @Builder
    public static class Response {
        private Long groupId;
        private String groupName;
        private String groupDesc;
        private String groupStatus;

        public Response(Group group) {
            this.groupId = group.getId();
            this.groupName = group.getName();
            this.groupDesc = group.getDesc();
            this.groupStatus = group.getStatus();
        }
    }
}
