package com.doyur.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Entity
@Data
@Table(name = "users") //tablolar için sona -s geliyor
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder

public class User implements UserDetails { //Spring Securitye ait bir entity old. sec. contexte bildiriyoruz(impl)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", updatable = false, nullable = false)
    private int userId;

    @Column(name = "userFName")
    private String userFName;

    @Column(name = "userLName")
    private String userLName;

    @Column(name = "userPassword", nullable = false) //lenght
    private String userPassword;


    @Email(message = "Hatali email")//Mail check Annotation'u
    @Column(name = "userEmail", unique = true, nullable = false)
    private String userEmail;


  //  @Pattern(regexp ="[0-9\\s]{12}")//Regex Annotation'u
    @Column(name = "userPhone", unique = true)
    private String userPhone;

    @Enumerated(EnumType.STRING) //Bu anotasyon, bu alanın bir Enum (sıralı sabitler) tipini temsil ettiðini belirtir. EnumType.STRING parametresi, Enum sabitlerinin veritabanında string olarak saklanmasınıoralType.STRING yapar.
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER) //Bu anotasyon, küme içindeki elemanların (yani rollerin) bir koleksiyon olarak ele alınmasını sağlar.
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id")) //Bu anotasyon, ilişkilendirilen koleksiyonun saklandığı tabloyu tanımlar. Bu durumda, "user_roles" adında bir tablo oluşturulur.Bu özel durumda, name = "user_id" ifadesi, ilişkilendirilmiş koleksiyonun (userRoles koleksiyonu) hangi sütunu kullanarak ana tablo ile birleştirileceğini belirtir. Yani, bu durumda "user_roles" tablosu ile "user" tablosu arasındaki ilişki, "user_id" sütunu üzerinden kurulacaktır.
    @Column(name = "role", nullable = false) //Bu anotasyon, ilişkilendirilen koleksiyondaki değerlerin hangi sütunda saklanacağını belirtir. Bu durumda, "role" adında bir sütun oluşturulur.
    private Set<Role> authorities;

    //Override
    private boolean accountNonExpired;//Hesap geçerlilik
    private boolean isEnabled;//Aktiflik
    private boolean accountNonLocked;//Hesap kilitli
    private boolean credentialsNonExpired;//Kimlik dogrulama

   /* @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)//Bu anotasyon, bir kullanıcının bir siparişte birden fazla menü olabilir
    private ShoppingCart shoppingCart; *
    
    */


    public User()
    {

    }

    public User(String userFName, String userLName, String userPassword, String userEmail, String userPhone, Set<Role> authorities,
                boolean accountNonExpired, boolean isEnabled, boolean accountNonLocked, boolean credentialsNonExpired) {
        this.userFName = userFName;
        this.userLName = userLName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.isEnabled = isEnabled;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
    }

    //@Column(name = "userAddress")
   /* @ElementCollection
    @CollectionTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Address> userAddress;  //Bu anotasyon, bir kullanıcının birden fazla adresi olabilir
    //Listeye yeni bir adres ekleyince diğer verileri tekrar girmemek için burda boş bir liste oluşturabilirsin */

   /* User() {

    }

    User(String userFName, String userLName, String userPassword, String userEmail, String userPhone, Set<Role> authorities) {
        this.userFName = userFName;
        this.userLName = userLName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.authorities = authorities;
    } */




    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userEmail;
    }


}
