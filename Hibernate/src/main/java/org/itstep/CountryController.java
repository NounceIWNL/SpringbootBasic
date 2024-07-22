package org.itstep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("/countries/all")
    public List<Country> getCountries() {
        var countries = countryService.findAll();
        return countries;
    }
}
