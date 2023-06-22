package com.muhammet.hastanerandevu.controller;

import com.muhammet.hastanerandevu.dto.request.RandevuSaveReqestDto;
import com.muhammet.hastanerandevu.repository.entity.Randevu;
import com.muhammet.hastanerandevu.service.RandevuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.muhammet.hastanerandevu.constants.RestApiList.*;
@RestController
@RequestMapping(RANDEVU)
@RequiredArgsConstructor
public class RandevuController {
    private final RandevuService randevuService;

    @PostMapping(SAVE)
    public Randevu save(@RequestBody @Valid RandevuSaveReqestDto dto){
        return randevuService.save(dto);
    }
}
