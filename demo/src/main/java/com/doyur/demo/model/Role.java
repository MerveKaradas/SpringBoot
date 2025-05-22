package com.doyur.demo.model;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    // Admin tüm yetkilere sahip olduğu için tüm değerler atılır ve girişte yönlendirme yaparken SuccesHandlerilkini kullanıyoruz
    // ve burda ilk rol değeri baz alınıyor o yüzden yetki sırası önemli

    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER"),
    ROLE_OWNER("OWNER");

    private String value;

    Role(String value)
    {
        this.value = value;
    }


    @Override
    public String getAuthority() {
        return name();
    }
}
