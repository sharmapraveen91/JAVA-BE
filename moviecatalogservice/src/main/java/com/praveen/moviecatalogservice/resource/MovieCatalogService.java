package com.praveen.moviecatalogservice.resource;

import com.praveen.moviecatalogservice.model.CatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientSsl;
import org.springframework.boot.web.reactive.;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogService {

    @Autowired
    WebClientSsl webClientSsl;

    @GetMapping("/{userId}")
    public List<CatalogItem> getMovieCatalog(@PathVariable String userId){


        return new ArrayList<CatalogItem>();
    }
}
