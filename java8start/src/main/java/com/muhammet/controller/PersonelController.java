package com.muhammet.controller;

import com.muhammet.dto.reponse.FindAllVwUserResponseDto;
import com.muhammet.dto.request.SavePersonelRequestDto;
import com.muhammet.repository.entity.Personel;
import com.muhammet.services.PersonelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.muhammet.constants.RestApiList.*;

/**
 * 1- MVC yapısında Controller katmanı @Controller anatasyonu ile işaretlenir.
 * 2- RestAPI yapısında Controller katmanı @RestController anatasyonu ile işaretlenir.
 */
@RestController
/**
 * Path kısmında gelen isteklerin handle edildiği kısımdır. Burada bir URL adresinden gelen isteklerin uygulamamızda
 * nerede yakalanması gerektiği bilgisi iletilir.
 * Bir uygulamanın Root(Kök-Ana) dizini "/" ile ifade edilir. yani uyguamanız 9090 portunca çalışıyor olsun;
 * Local de çalıştırıyorsanız: http://localhost:9090/
 * bir internet adrsiniz var ise: http://www.muhammet.com/
 * --------
 * http://localhost:9090/personel
 */
@RequestMapping(PERSONEL)
@RequiredArgsConstructor
public class PersonelController {

    private final PersonelService personelService;

    /**
     * Burası son kullanıcının programımınz ile iletişime geçtiği kısımdır. Farklı şekillerde iletişim yapılabilir.
     * GET, POST, PUT, DELETE v.s. gibi.
     * Kullanıcının Request göndermesi.
     * ---> İsteklerin Değerlendirilmesi
     * GET -> genellikle get istekleri bir sayfanını açılması ya da bellir bir datanın talep edilmesi durumlarında geçerlidir.
     * http://localhost:9090/personel/save
     * Eğer istek sizden parametre talep ediyor ise bunların eklenmesi gereklidir.
     * http://localhost:9090/personel/save?ad=Muhammet&adres=İstanbul&yas=25&telefon=123456789
     * ? paremetre girileceğini belirtir.
     * key=value şeklinde parametreler girilir.
     * & ile bir sonraki parametreye geçilir.
     * DİKKAT!!!! girdiğiniz anahtar kelimeler methodun parametre isimleri ile aynı olmalıdır.
     */
    @GetMapping(SAVE)
    public void savePersonel(String ad,String adres, int yas,String telefon){
        Personel personel = Personel.builder()
                .ad(ad)
                .adres(adres)
                .yas(yas)
                .telefon(telefon)
                .build();
        personelService.save(personel);
    }

    /**
     * POST ---> get ve post ya da diğerleri bir birlşerinini yerine kullanılabilirler.
     * Ancak önemli olan konu şudur;
     * GET isteklerinde parametreler URL üzerinden gönderilir. Şöyle düşünelim, bir uygulamaya
     * giriş yapmak istiyoruz. Kullanıcı adı ve şifre girmemiz gerekiyor. Bu bilgileri GET ile gönderirsek
     * tüm bilgilerimiz başlık içeirisinde iletilir. Örneğin;
     * http://localhost:9090/login?kullaniciAdi=muhammet&parola=123456
     * bu işlem oldukça tehlikelidir ve bilgileriniz çalınır.
     * POST işleminde ise işler daha karmaşıktır ve bilgileriniz korunur.
     * GET ile bilgiler header(başlık) ta gider
     * POST ile bilgiler body(gövde) taşınır.
     *
     */
    @PostMapping(SAVE)
    public void savePersonel(String ad,String adres, int yas,String telefon, int type ){
        Personel personel = Personel.builder()
                .telefon(telefon)
                .yas(yas)
                .adres(adres)
                .ad(ad)
                .type(type)
                .build();
        personelService.save(personel);
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Personel>> findAll(){
        return ResponseEntity.ok(personelService.findAll());
    }
    @GetMapping(FINALLVWUSER)
    public ResponseEntity<List<FindAllVwUserResponseDto>> getAllVwPersonel(){
        List<Personel> plist = personelService.findAll();
        List<FindAllVwUserResponseDto> result = new ArrayList<>();
        plist.forEach(p->{
            FindAllVwUserResponseDto dto =  FindAllVwUserResponseDto.builder()
                    .id(p.getId())
                    .ad(p.getAd())
                    .photo(p.getPhoto())
                    .build();
            result.add(dto);
        });
        return ResponseEntity.ok(result);
    }

    @PostMapping(SAVEDTO)
    public ResponseEntity<Boolean> savePersonelDto(@RequestBody SavePersonelRequestDto dto){
        Personel personel = Personel.builder()
                .ad(dto.getAd())
                .adres(dto.getAdres())
                .telefon(dto.getTelefon())
                .build();
        personelService.save(personel);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/getUpperCaseName")
    public ResponseEntity<String> getUpperCaseName(String ad){
        String upperCaseName = ad.toUpperCase();
        return ResponseEntity.ok(upperCaseName);
    }
    @PostMapping("/postUpperCaseName")
    public ResponseEntity<String> postUpperCaseName(String ad){
        String upperCaseName = ad.toUpperCase();
        return ResponseEntity.ok(upperCaseName);
    }
    @PutMapping("/putUpperCaseName")
    public ResponseEntity<String> putUpperCaseName(String ad){
        String upperCaseName = ad.toUpperCase();
        return ResponseEntity.ok(upperCaseName);
    }
    @DeleteMapping("/deleteUpperCaseName")
    public ResponseEntity<String> deleteUpperCaseName(String ad){
        String upperCaseName = ad.toUpperCase();
        return ResponseEntity.ok(upperCaseName);
    }
    @PatchMapping("/patchUpperCaseName")
    public ResponseEntity<String> patchUpperCaseName(String ad){
        String upperCaseName = ad.toUpperCase();
        return ResponseEntity.ok(upperCaseName);
    }

}