package com.muhammet.controller;

import com.muhammet.dto.request.GetNameUpperCaseRequestDto;
import com.muhammet.exceptions.ErrorType;
import com.muhammet.exceptions.Java8startException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personeldepartman")
@RequiredArgsConstructor
public class PersonelDepartmanController {

    @PostMapping("/getname")
    public ResponseEntity<String> getNameUpperCase(@RequestBody GetNameUpperCaseRequestDto dto){
        if (dto.getName() == null)
            throw new Java8startException(ErrorType.NAME_IS_NULL);
        String nameUpper = dto.getName().toUpperCase();
        return ResponseEntity.ok(nameUpper);
    }
}
