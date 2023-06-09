package com.muhammet.controller;

import com.muhammet.reposıtory.entity.Brans;
import com.muhammet.servıce.BransService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.muhammet.constants.RestApiList.*;

@RestController
@RequestMapping(BRANS)
@RequiredArgsConstructor
public class BransControler {

    private final BransService bransService;

    @PostMapping(SAVE)
    public Brans save(@RequestBody Brans brans){
        return bransService.save(brans);
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<Brans>> findAll(){
        return ResponseEntity.ok(bransService.findAll());
    }
}
