package com.muhammet.repository;

import com.muhammet.repository.entity.Departman;
import com.muhammet.repository.view.VwDepartmanList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDepartmanRepository extends JpaRepository<Departman,Long> {

    /**
     * Spring Data JPA belli keyword ler ile sorguları method isimlerine göre otomatik oluşturur.
     * -- Örneğin: yönetici id sinden yöneticinin bağlı bulunduğu departman listesini bul.
     * ---- Spring Keeyword ler ile sorgu methodu oluşturmak;
     * 1- find ile başlıyoruz.
     * 2- By ile devam ediyoruz. bir kaç yerde değişlikliğe uyrayarak arasına değer girebiliyor.
     * 3- Entity içinde var olan bir property adını ekliyoruz.
     * DİKKAT!!!! burada yazılacak değişken adı mutlaka büyük harf ile başlar ve değişken yazım şekline göre devam eder.
     * 4- bu method için ek özellikler varsa eklenir.
     * 5- methodun talep ettiği değer parametre olarak eklenir.
     * 6- geri dönüş tipi yazılan methodun başına getirilir.
     */
    List<Departman> findByYoneticiid(Long yoneticiid); // find By Yoneticiid -> yoneticiid => select * from tbldepartman where yoneticiid = ?
    List<Departman> findAllByKonum(String konumadi_istedigini_yazabilirsin); // select * from tbldepartman where konum = ?


    /**
     * select * from tbldepartman where ad=?
     * Bu kısımda arama yaparken eğer aynı ad ile kayıt edilmiş birden fazla kayıt var ise ilk bulduğu kaydı getirir.
     * @param  ad
     * @return
     */
    Departman findByAd(String ad);
    /**
     * Eğer gerekli olduğunda aranılan bilginin varlığının kontrolü sağlanılacak ise, burada gelen bilginin null olması
     * durumunda hata alınacağı için Optional kullanılır.
     * DİKKAT!!!!!
     * Burada dikkat etmeniz gereken husus aradığınız bilginin ya hiç olmaması yada bir tane olması gereklidir. Eğer birden
     * fazla kayıt dönüyorsa hata alırsınız. Bu nedenle optional kullanırken dikkat etmelisiniz.
     */
    Optional<Departman> findOptionalByAd(String ad);
    /**
     * aradığım kelime departman adı içinde var ise bunların listesini getirsin.
     * select * from tbldepartman where ad like %?%
     * Eğer like kullanıyor iseniz özel karakterleri sizi belirmeniz gereklidir. %ad, %de%, d__% gibi
     * NOT -> eğer belli bir kelime dışında kalan kayıtları listelemek istiyor isek bunu kullanırız NotLike
     * */
    List<Departman> findByAdLike(String searchKey);
    List<Departman> findByAdNotLike(String searchKey);

    /**
     * Eğer istediğimiz şey tam olarak aradığımız kelimenin propety datası içinde geçip geçmediğiniz kontrolü ise
     */
    List<Departman> findByAdContaining(String searchKey);

    /**
     * Aradığımız kelime ile başlayan kayıtları listelemek için
     */
    List<Departman> findByAdStartingWith(String searchKey); // muh% -> muh ile başlayan kayıtlar

    /**
     * Birden fazla property üzerinden arama yapmak istiyor isek
     * AND key kullanılarak işlemlerimizi yürütebiliriz.
     * Birden fazla kriter içinde herhangi birisini sağlayan kayıtları getirmek için OR kullanılır.
     * select * from tbldepartman where ad=? and konum=?
     */
    List<Departman> findAllByYoneticiidAndKonum(Long yoneticiid,String konum);

    /**
     * select * from tbldepartman where yoneticiid=? or konum=?
     */
    List<Departman> findAllByYoneticiidOrKonum(Long yoneticiid,String konum);

    /**
     * select * from tbldepartman where yoneticiid=? or like konum %kk%
     * StartingWith -> k%
     * Containing -> %k%
     */
    List<Departman> findAllByYoneticiidOrKonumStartingWith(Long yoneticiid,String konum);
    List<Departman> findAllByYoneticiidOrKonumLike(Long yoneticiid,String konum);
    List<Departman> findAllByYoneticiidOrKonumContaining(Long yoneticiid,String konum);

    /**
     * KAyıtları belli bir property ye göre sıralamak için
     * OrderBy kullanılır.
     * ASC -> a...z  Küçükten büyüğe (default)
     * DESC -> z...a Büyükten küçüğe
     */
    List<Departman> findAllByOrderByKonum(); // a..z
    List<Departman> findAllByOrderByKonumDesc(); // z..a

    /**
     * Bellir bir kritere göre kısıtlayıp sonrasında sıralama yapmak mantıklıdır.
     */
    List<Departman> findAllByKonumOrderByKonum(String konum);

    /**
     * Satış platformu, en çok satan ürünleri listelemek istiyor. Ve bu ürünlerin
     * en çok satılan 5 ürününü listemek istiyorsunuz.
     *  TOP - LIMIT
     *  select * from tblurun order by adet desc limit 5
     */
    List<Departman> findTop3AllByOrderByKonum();
    List<Departman> findTop50ByKonumContaining(String konum);
    /**
     * Bir kiştapçıda en çok satılan kitabı bulmak istiyoruz.
     */
    Departman findTopByOrderByKonum();

    /**
     * Durumunun aktif olduğu kayıtları getirmek yada true/false olan alanlara göre listeleme
     * yapmak için kullanılacak methodlar
     */
    List<Departman> findAllByIsactive(Boolean isactive);
    List<Departman> findAllByIsactiveTrue();
    List<Departman> findAllByIsactiveFalse();

    /**
     * Belli bir string alanda arama yaparken kullanıcıların yazım şekillerinie
     * çok riayet ettikleri söylenemez yani, bir kişi giriş yapmak için kullanıcı
     * adını girerken; muhammet,Muhammet, MUHAMMET, MuHammEt gibi yazımlar olabilir.
     * böyle durumlarda arama yaparken sorun yaşarsınız.
     * Yani -> "muhammet".Equals("Muhammet") -> false
     * Doğru Yaklaşım -> "muhammet".equalsIgnoreCase("Muhammet") -> true
     */
    List<Departman> findAllByKonumIgnoreCase(String konum);

    /***
     * DİKKAT!!! PERFORMANS İÇERİR. :)
     * Örneğin, elinizde uygulamanızda en çok ürün satın alan kişilerin satış işlemlerine
     * ulaşmak istiyorsunuz, fakat bu bilgilere ulşamak için önce satışalrı çekmeniz
     * ardından bu kişilerin listesini ayıklamanız gereklidir. yada join kullanarak
     * tüm tabloları birleştirip arama yapmanız gereklidir. iki durumda yüksek işlem
     * hacmi tüketeceği için sorunludur.
     * Doğru Yöntem;
     * önce kişiler bulunur ve bu kişilerin id bilgisi bir List<Long> içine atılır,
     * bu liste satış tablosunda sorgulanarak sadece bu kişilere ait satışların listesinin
     * çekilmesi sağlanır ve performan iyileşir.
     * select * from tblsatis where musteriid in (1,2,3,4,5,6,7,8,9,10)
     */
    List<Departman> findAllByYoneticiidIn(List<Long> yoneticiidList);

    /**
     * Günlük challenge yapılan bir sistemde Aktif olan challengeları listelemek için
     * bulunduğumuz anda bitiş tarihinin büyük olması surumları irdelenir.
     * select * from tblchallenge where enddate > ?
     * Örn; 01.01.2023 den sonra açılan departamları listesi
     */
    List<Departman> findAllByCreateatGreaterThan(Long time);
    List<Departman> findAllByCreateatLessThan(Long time);

    /**
     * Eğer kontrol ettiğiniz tarihi de kapsamak isterseniz yani > yerine >= kullanmak isterseniz
     * kullanılır
     */
    List<Departman> findAllByCreateatGreaterThanEqual(Long time);
    List<Departman> findAllByCreateatLessThanEqual(Long time);

    /**
     * Eğer belli bir tarih aralığında kayıtları getirmek isterseniz
     */
    List<Departman> findAllByUpdateatBetween(Long start,Long end); // updateat >= start and updateat <= end

    /**
     * İhtiyaç duyduğumuz datalar bazen anahtar kelimelerle elde edilemez. bu durumlarda özel sorgular
     * yazmak ve bu sorguları çalıştırmak gerekebilir.
     */
    @Query("select d from Departman d where d.ad = ?1") // select * from tbldepartman where ad = ?
    Departman senBulDepartmaniAdinaGore(String ad);

    @Query("select d from Departman d where d.yoneticiid = ?1 and d.konum = ?2")
    List<Departman> yoneticiVeKonumaGore(Long yoneticiid,String konum);

    @Query(value= "select * from tbldepartman where konum like %?1%", nativeQuery = true)
    List<Departman> konumaGoreGetir(String konum);

    @Query("select d from Departman d where d.ad = :departmanadi")
    Departman bulParametreIle(@Param("departmanadi") String ad);

    /**
     * DİKKAT!!!! ******* lı kullanım
     */
    @Query("select count(d)>0 from Departman d where d.konum like %?1% and d.ad ilike %?2%")
    Boolean boyleBirKayitVarMiOla(String konum, String ad);

    @Query("select new com.muhammet.repository.view.VwDepartmanList(d.id,d.ad) from Departman d")
    List<VwDepartmanList> findAllVwDepartman();
}
