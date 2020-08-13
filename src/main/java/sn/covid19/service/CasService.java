package sn.covid19.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import sn.covid19.dao.ICas;
import sn.covid19.entities.Cas;

import java.util.Date;
import java.util.List;

@RestController
public class CasService {
    @Autowired
    private ICas casdao;

    @RequestMapping(value = "/corona/cas", method = RequestMethod.GET)
    public List<Cas> getAll() {
        return casdao.findAll();
    }
    @RequestMapping(value = "/corona/casparville", method = RequestMethod.GET)
    public List<Cas> getAllCasByVille(@RequestParam String ville){
        return casdao.getAllCasByVille(ville);
    }

    @RequestMapping(value = "/corona/casparquartier", method = RequestMethod.GET)
    public List<Cas> getAllCasByQuartier(@RequestParam String quartier){

        return casdao.getAllCasByQuartier(quartier);
    }

//    @RequestMapping(value = "/corona/cas/save", method = RequestMethod.POST)
//    public List<Cas> save(Cas cas){
//        casdao.save(cas);
//        return casdao.findAll();
//    }

    @RequestMapping(value = "/corona/cas/save", method = RequestMethod.POST)
    public List<Cas> save(Cas cas, @RequestParam("datecas") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datecas){
        cas.setDate(datecas);
        casdao.save(cas);
        return casdao.findAll();
    }

    @RequestMapping(value = "/corona/cas/delete/{id}", method = RequestMethod.DELETE)
    public List<Cas> delete(@PathVariable int id){
        if(casdao.getById(id) != null) {
            casdao.delete(casdao.getById(id));
        }
        return casdao.findAll();
    }

    @RequestMapping(value = "/corona/cas/get", method = RequestMethod.GET)
    public Cas get(@RequestParam int id){
        return casdao.getById(id);
    }

//    @RequestMapping(value = "/corona/cas/update/{id}", method = RequestMethod.PUT)
//    public List<Cas> update(@PathVariable int id, Cas cas){
//        cas.setId(id);
//        casdao.save(cas);
//        return casdao.findAll();
//    }

    @RequestMapping(value = "/corona/cas/update/{id}", method = RequestMethod.PUT)
    public List<Cas> update(@PathVariable int id, Cas cas, @RequestParam("datecas") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datecas){
        cas.setId(id);
        cas.setDate(datecas);
        casdao.save(cas);
        return casdao.findAll();
    }
}

