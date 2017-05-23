package org.bssimin.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * Created by joo on 2017. 5. 22..
 */
public class GeUser_info implements UserDetails{
    private int geUserNo;
    private String geUserId;
    private String geUserPw;
    private String geUserAddr;
    private String geUserCellInfo;
    private String geUserEmail;
    private Date geUserRegiDate;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonexpired;
    private boolean isEnabled;
    private Collection<? extends GrantedAuthority> authorities;


    public int getGeUserNo() {
        return geUserNo;
    }

    public void setGeUserNo(int geUserNo) {
        this.geUserNo = geUserNo;
    }

    public String getGeUserId() {
        return geUserId;
    }

    public void setGeUserId(String geUserId) {
        this.geUserId = geUserId;
    }

    public String getGeUserPw() {
        return geUserPw;
    }

    public void setGeUserPw(String geUserPw) {
        this.geUserPw = geUserPw;
    }

    public String getGeUserAddr() {
        return geUserAddr;
    }

    public void setGeUserAddr(String geUserAddr) {
        this.geUserAddr = geUserAddr;
    }

    public String getGeUserCellInfo() {
        return geUserCellInfo;
    }

    public void setGeUserCellInfo(String geUserCellInfo) {
        this.geUserCellInfo = geUserCellInfo;
    }

    public String getGeUserEmail() {
        return geUserEmail;
    }

    public void setGeUserEmail(String geUserEmail) {
        this.geUserEmail = geUserEmail;
    }

    public Date getGeUserRegiDate() {
        return geUserRegiDate;
    }

    public void setGeUserRegiDate(Date geUserRegiDate) {
        this.geUserRegiDate = geUserRegiDate;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonexpired() {
        return isCredentialsNonexpired;
    }

    public void setCredentialsNonexpired(boolean credentialsNonexpired) {
        isCredentialsNonexpired = credentialsNonexpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return geUserId;
    }

    @Override
    public String getUsername() {
        return geUserPw;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonexpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
