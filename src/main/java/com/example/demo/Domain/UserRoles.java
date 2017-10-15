package com.example.demo.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Adeebo on 2017/08/26.
 */
@Entity
public class UserRoles implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer roleID;
    private String role;
    private Integer clubID;
    private String password;
    private String status;

    public UserRoles() {
    }

    public UserRoles (Builder builder){

        this.roleID = builder.roleID;
        this.role = builder.role;
        this.clubID= builder.clubID;
        this.password = builder.password;
        this.status = builder.status;
    }

    public static class Builder{

        private Integer roleID;
        private String role;
        private Integer clubID;
        private String password;
        private String status;

        public Builder setRoleID(Integer roleID) {
            this.roleID = roleID;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setClubID(Integer clubID) {
            this.clubID = clubID;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(UserRoles value){

            this.roleID = value.roleID;
            this.role = value.role;
            this.clubID= value.clubID;
            this.password = value.password;
            this.status = value.status;

            return this;
        }

        public UserRoles build(){

            return new UserRoles(this);
        }
    }


    public Integer getRoleID() {
        return roleID;
    }

    public String getRole() {
        return role;
    }

    public Integer getClubID() {
        return clubID;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoles)) return false;

        UserRoles userRoles = (UserRoles) o;

        return roleID.equals(userRoles.roleID);

    }

    @Override
    public int hashCode() {
        return roleID.hashCode();
    }

    @Override
    public String toString() {
        return "UserRoles" + '\n' +
                "RoleID: " + roleID + '\n' +
                "Role: " + role + '\n' +
                "ClubID: " + clubID + '\n' +
                "Status: " + status;
    }
}
