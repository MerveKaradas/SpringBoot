package com.doyur.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "cities")
@NoArgsConstructor
@AllArgsConstructor

public class Cities {

    @Id
    @Column(name = "cityId")
    private int cityId;

    @Column(name = "cityName")
    private String cityName;

   /* //FOREIGN KEY ATAMASI YAPMIŞ OLDUK
    @Column(name = "cityCode")
    @OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL) // Bu ifade, City nesnesinde yapılan değişikliklerin (ekleme, güncelleme, silme gibi) bu ilişkili County nesnelerine de yansıtılmasını sağlar. Örneğin, bir şehir silindiğinde ilişkili ilçelerin de silinmesini sağlar.
    private List<Counties> counties; */

    @OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL) // Bu ifade, City nesnesinde yapılan değişikliklerin (ekleme, güncelleme, silme gibi) bu ilişkili County nesnelerine de yansıtılmasını sağlar. Örneğin, bir şehir silindiğinde ilişkili ilçelerin de silinmesini sağlar.
    private List<Counties> counties;







    //@OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL): Bu ifade, City sınıfının counties
    // alanındaki ilişkiyi tanımlar. mappedBy parametresi, ilişkinin Counties sınıfındaki hangi alan
    // tarafından yönetildiğini belirtir. Burada, Counties sınıfının cityId alanı ile eşleşen bir ilişki kuruluyor.
    //Ayrıca, cascade = CascadeType.ALL ifadesi, City sınıfında yapılan değişikliklerin (Persist, Remove, Merge vb.)
    // ilişkili Counties nesnelerine de uygulanmasını sağlar. Yani, bir şehirle ilgili herhangi bir değişiklik
    // (örneğin silme) ilgili ilçelere de yansıtılır.

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityId")
    private int cityId;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "cityCode")
    @OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL) // Bu ifade, City nesnesinde yapılan değişikliklerin (ekleme, güncelleme, silme gibi) bu ilişkili County nesnelerine de yansıtılmasını sağlar. Örneğin, bir şehir silindiğinde ilişkili ilçelerin de silinmesini sağlar.
    private List<Counties> counties;
    *
    *
    *
    * */
}
